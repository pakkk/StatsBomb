package es.iesjandula.statsbomb.models.matches;

import es.iesjandula.statsbomb.common.exception.StatsBombException;
import es.iesjandula.statsbomb.common.utils.DateUtils;

import java.util.Date;

/**
 * @author Oscar Herruzo
 * Manager class to save
 * the managers information
 */
public class Manager
{
	/**
     * Attribute -
     * The unique identifier of the manager.
     */
    private int id;
    
	/**
     * Attribute -
     * The name of the country.
     */
    private String name;
    
	/**
     * Attribute -
     * Nickname of the manager.
     */
    private String nickname;
    
	/**
     * Attribute -
     * Date of birth
     */
    private String dob;
    
	/**
     * Attribute -
     * Date of birth
     */
    private Date dob__javaUtilDate;
    
    /**
     * Attribute -
     * The managers country origin
     */
    private Country country;
    
    /**
     * Empty constructor
     */
    public Manager()
    {

    }
    
    /**
     * @return the unique identifier for the manager.
     */
    public int getId()
    {
        return id;
    }
    
    /**
     * @param id, id of the manager.
     */
    public void setId(int id)
    {
        this.id = id;
    }

    /**
     * @return the name of the manager.
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name, name of the manager.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return the nickname of the manager.
     */
    public String getNickname()
    {
        return nickname;
    }
    
    /**
     * @param nickname, nickname of the manager.
     */
    public void setNickname(String nickname)
    {
        this.nickname = nickname;
    }

    /**
     * @return the birth of manager
     */
    public String getDob()
    {
        return dob;
    }

    /**
     * @param dob, birth of the manager parser
     */
    public void setDob(String dob) throws StatsBombException 
    {
        this.dob = dob;

        DateUtils dateUtils = new DateUtils();
        this.dob__javaUtilDate = dateUtils.convertStringToDateFormatddMMyyyy(this.dob);

    }

    /**
     * @return the birth of manager
     */
    public Date getDob__javaUtilDate()
    {
        return dob__javaUtilDate;
    }

    /**
     * @return the managers country origin
     */
    public Country getCountry()
    {
        return country;
    }

    /**
     * @param country, country of the manager origin.
     */
    public void setCountry(Country country)
    {
        this.country = country;
    }

    /**
     * @return a instance of Manager as string
     */
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
