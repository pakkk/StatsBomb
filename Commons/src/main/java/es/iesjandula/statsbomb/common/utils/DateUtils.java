package es.iesjandula.statsbomb.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeParseException;
import java.util.Date;

/**
 * @author Neil Hdez
 * @version 1.0.0
 * @since 01/12/2022
 */
public class DateUtils
{
    /**
     * Convert Date in format HH:mm:ss.SSS to format Date
     *
     * @param dateString Date in format String
     * @return Date in format Date
     */
    public Date convertStringToDateFormatHHmmssSSS(final String dateString)
    {
        if (dateString == null)
        {
            return null;
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS");
        Date date = null;
        try
        {
            date = simpleDateFormat.parse(dateString);
        }
        catch (ParseException parseException)
        {
            parseException.printStackTrace();
        }

        return date;
    }

    public Date convertStringToDateFormatyyyyMMdd(final String dateString)
    {
        if (dateString == null)
        {
            return null;
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try
        {
            date = simpleDateFormat.parse(dateString);
        }
        catch (ParseException parseException)
        {
            parseException.printStackTrace();
        }

        return date;
    }

    public Date convertStringToDateFormatddMMyyyy(final String dateString)
    {
        if (dateString == null)
        {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try
        {
            date = simpleDateFormat.parse(dateString);
        }
        catch (ParseException parseException)
        {
            parseException.printStackTrace();
        }

        return date;
    }

    public Date convertStringToDateFormatddMMyyyyWithHyphen(final String dateString)
    {
        if (dateString == null)
        {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try
        {
            date = simpleDateFormat.parse(dateString);
        }
        catch (ParseException parseException)
        {
            parseException.printStackTrace();
        }

        return date;
    }

    /**
     * Convert Date in format yyyy-MM-ddTHH:mm:ss.SSS to String
     *
     * @param dateString Date in format String
     * @return Date in format Date
     */
    public Date convertStringToDateFormatyyyyMMddTHHmmssSSS(String dateString)
    {
        if (dateString == null)
        {
            return null;
        }
        Date date = null;
        try
        {
            LocalDateTime localDateTime = LocalDateTime.parse(dateString);
            Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
            date = Date.from(instant);
        }
        catch (DateTimeParseException dateTimeParseException)
        {
            return null;
        }

        return date;
    }

}
