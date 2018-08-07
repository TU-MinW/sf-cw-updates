/**
 * 
 */
package city.baltimore.eip.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;

import city.baltimore.eip.dao.SalesforceDao;
import city.baltimore.eip.model.salesforce.SalesforceRequest;
import city.baltimore.eip.model.salesforce.SalesforceQueryRequest;

/**
 * 
 * @author Jun.Tao
 *
 */
@Service
public class SalesforceServiceImpl implements SalesforceService {	
	@Autowired
	private SalesforceDao salesforceDao;
	
	/*
	 * (non-Javadoc)
	 * @see city.baltimore.eip.service.SalesforceApiService#SalesforceGetServiceRequestDetails(city.baltimore.eip.model.salesforce.SalesforceQueryRequest)
	 */
	@Override
	public SalesforceRequest SalesforceGetServiceRequestDetails(SalesforceQueryRequest request) throws Exception {
		SalesforceRequest sr = salesforceDao.GetRequestDetails(request.getServiceRequestId());
		return sr;
	}	
}