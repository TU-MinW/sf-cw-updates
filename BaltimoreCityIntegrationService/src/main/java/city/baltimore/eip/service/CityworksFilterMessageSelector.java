package city.baltimore.eip.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.core.MessageSelector;
import org.springframework.messaging.Message;

import city.baltimore.eip.model.motorola.csr.Document;

/**
 * A Spring Integration message filter expression implementation to reject service requests that already exist in Cityworks.
 * @author James.Somerville
 *
 */
public class CityworksFilterMessageSelector implements MessageSelector {
    @Autowired
    CityworksService cityworksApiService;
	
	public CityworksFilterMessageSelector() {
	}

	/* 
	 * Check whether the Motorola CSR exists in Cityworks. For use as a message filter to reject a message if the CSR already exists.
	 * Expects a city.baltimore.eip.model.motorola.csr.Document object as payload of message.
	 * (non-Javadoc)
	 * @see org.springframework.integration.core.MessageSelector#accept(org.springframework.messaging.Message)
	 */
	@Override
	public boolean accept(Message<?> motorolaSrDocumentMessage) {
		Document csrDocument = (Document)motorolaSrDocumentMessage.getPayload();
		String motorolaId = csrDocument.getPrcInstance().getPrcNumber();
		//Inverse logic of method, because if the service request already exists, then do not want to accept the message.
		boolean exists = false;
		try {
			exists = cityworksApiService.SrExistsInCityworks(motorolaId);
		} catch (Exception e) {
			return !exists;
		}
		return !exists;
	}
}