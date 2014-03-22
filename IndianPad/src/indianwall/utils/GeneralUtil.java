package indianwall.utils;



import java.text.SimpleDateFormat;

import java.util.Date;



public class GeneralUtil {

    public static final String STANDARD_DATE_FORMAT = "dd/MM/yyyy";

    

    public static String getFormattedDate(Date d,String dateFormat) {

        SimpleDateFormat inputDf = new SimpleDateFormat(dateFormat);

            return inputDf.format(d);

    }

   

}

