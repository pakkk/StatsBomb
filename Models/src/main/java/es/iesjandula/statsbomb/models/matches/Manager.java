package es.iesjandula.statsbomb.models.matches;

import es.iesjandula.statsbomb.common.exception.StatsBombException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Manager
{
    private final Logger logger = LogManager.getLogger();

    private int id;
    private String name;
    private String nickname;
    private String dob;
    private Date dob__javaUtilDate; //cambiar
    private Country country;

    public Manager()
    {

    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getNickname()
    {
        return nickname;
    }

    public void setNickname(String nickname)
    {
        this.nickname = nickname;
    }

    public String getDob()
    {
        return dob;
    }

    public void setDob(String dob) throws StatsBombException {
        this.dob = dob;
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        try
        {
            this.dob__javaUtilDate = dateFormat.parse(this.dob);
        }
        catch (ParseException parseException)
        {
            String errorMessage = "Cannot parse the field 'dob' to java.util.Date";
            logger.error(errorMessage, parseException);
            throw new StatsBombException(errorMessage, parseException);

        }
    }

    public Date getDob__javaUtilDate()
    {
        return dob__javaUtilDate;
    }


    public Country getCountry()
    {
        return country;
    }

    public void setCountry(Country country)
    {
        this.country = country;
    }

    @Override
    public String toString()
    {
        return "HomeTeamManager{" +
                "id=" + id +
                ", name='" + name +
                ", nickname='" + nickname +
                ", dob='" + dob +
                ", dob__javaUtilDate=" + dob__javaUtilDate +
                ", country=" + country +
                '}';
    }
}
