package es.iesjandula.statsbomb.common.date_utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Neil Hdez
 * @version 1.0.0
 * @since 01/12/2022
 */
public class DateUtils
{
    /**
     * Convert Date in format String to format Date
     *
     * @param dateString Date in format String
     * @return Date in format Date
     */
    public Date convertStringToDate(final String dateString)
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS");
        Date date = null;
        try
        {
            date = simpleDateFormat.parse(dateString);
        } catch (ParseException parseException)
        {
            parseException.printStackTrace();
        }

        return date;
    }

}
