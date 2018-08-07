/**
 * 
 */
package city.baltimore.eip.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author james.somerville
 * Util class for working with Cityworks and Motorola string date formats.
 */
public class DateUtils {
	
    /**
     * Gives the Java Date representation of the text date in the format: "MM/dd/yyyy hh:mm:ss aa"
     * @param textDate Expected format: "MM/dd/yyyy hh:mm:ss aa"
     * @return date
     * @throws ParseException
     */
    public static Date GetDate(String textDate) throws ParseException {
    	return (new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa")).parse(textDate);
    }
    
    /**
     * Gives the Java Date representation of the text date in the format: "yyyy-MM-dd'T'HH:mm:ss"
     * @param textDate Expected format: "yyyy-MM-dd'T'HH:mm:ss"
     * @return date
     * @throws ParseException
     */
    public static Date GetDate2(String textDate) throws ParseException {
    	return (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")).parse(textDate);
    }
    
    /**
     * Returns a string value of the date in the format Cityworks API needs.
     * @param date
     * @return Date in the format "yyyy-MM-dd'T'HH:mm:ss".
     */
    public static String GetDateAsTextForCityworks(Date date) {
    	return (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")).format(date);
    }
    
    /**
     * Returns a string value of the date in the format Motorola App Hub needs.
     * @param date
     * @return Date in the format "MMM dd, yyyy hh:mm:ss a".
     */
    public static String GetDateAsTextForMotorola(Date date) {
    	return (new SimpleDateFormat("MMM dd, yyyy hh:mm:ss a")).format(date);
    }

}
