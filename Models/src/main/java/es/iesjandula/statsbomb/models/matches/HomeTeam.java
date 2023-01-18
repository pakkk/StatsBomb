package es.iesjandula.statsbomb.models.matches;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author Nacho Belda
 * @author Manuel Canio Gil
 */
@Entity
@Table(name = "home_team")
public class HomeTeam
{
    /**
     * Attributes -
     * id/Name of the team this
     * event relates to. Team object
     * will only display if the event
     * is tied to a specific team
     */
    @Id
    @Column(length = 10)
    private int home_team_id;
    @Column(name = "home_team_name", length = 30)
    private String home_team_name;

    /** Attribute - Gender of the home team in the match */
    @Column(name = "home_team_gender", length = 20)
    private String home_team_gender;


    /** Attribute - Name of the group/conference of the team in the match */
    @Column(name = "home_team_group", length = 40)
    private String home_team_group;

    /** Attribute -
     * ID number and name corresponding to the origin country for
     * the home team in the match
     */
    private Country country;

    /** Attribute -
     * Data frame of the manager for the home team with information
     * about the manager described with the variables listed below
     */
    private List<Manager> managers;

    /**
     * Constructor with new managers
     */
    public HomeTeam() {
        this.managers = new ArrayList<>();
    }

    /**
     * @return the information about the id
     */
    public int getHome_team_id()
    {
        return home_team_id;
    }

    /**
     * @param home_team_id with the information about the id
     */
    public void setHome_team_id(int home_team_id)
    {
        this.home_team_id = home_team_id;
    }

    /**
     * @return the information about the name
     */
    public String getHome_team_name()
    {
        return home_team_name;
    }

    /**
     * @param home_team_name with the information about the name
     */
    public void setHome_team_name(String home_team_name)
    {
        this.home_team_name = home_team_name;
    }


    /**
     * @return the gender of the home team
     */
    public String getHome_team_gender()
    {
        return this.home_team_gender;
    }

    /**
     * @param home_team_gender with the gender of the home team
     */
    public void setHome_team_gender(String home_team_gender)
    {
        this.home_team_gender = home_team_gender;
    }

    /**
     * @return the name of the group/conference of the home team
     */
    public String getHome_team_group() {
        return home_team_group;
    }

    /**
     * @param home_team_group with the name of the group/conference of the home team
     */
    public void setHome_team_group(String home_team_group) {
        this.home_team_group = home_team_group;
    }

    /**
     * @return the information about country
     */
    public Country getCountry() {
        return country;
    }

    /**
     * @param country with the information about country
     */
    public void setCountry(Country country) {
        this.country = country;
    }

    /**
     * @return the information about managers
     */
    public List<Manager> getManagers() {
        return managers;
    }

    /**
     * @param managers with the information about home_team_manager
     */
    public void setManagers(List<Manager> managers) {
        this.managers = managers;
    }

    /**
     * @return an instance of the class Team as String
     */
    @Override
    public String toString() {
        return "HomeTeam{" +
                "home_team_id=" + home_team_id +
                ", home_team_name='" + home_team_name + '\'' +
                ", home_team_gender='" + home_team_gender + '\'' +
                ", home_team_group='" + home_team_group + '\'' +
                ", country=" + country +
                ", managers=" + managers +
                '}';
    }
}
