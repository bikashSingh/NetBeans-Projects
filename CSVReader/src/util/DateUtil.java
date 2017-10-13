
package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static String changeDateFormat(String inputPattern, String outputPattern, String givenDate) throws ParseException {
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);
        
        Date date = inputFormat.parse(givenDate);
        String requiredDate = outputFormat.format(date);
        
        return requiredDate;
    }
}
