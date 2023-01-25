package es.iesjandula.statsbomb.models.matches;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * @author Nacho Belda
 * @author David Armijo
 * @author Manuel Canio Gil
 */
@Entity
@Table(name = "away_team")
public class AwayTeam
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
    private int away_team_id;
    @Column(name = "away_team_name", length = 50, nullable = false)
    private String away_team_name;

    /** Attribute - Gender of the away team in the match */
    @Column(name = "away_team_gender", length = 20, nullable = false)
    private String away_team_gender;

    /** Attribute - Name of the group/conference of the team in the match */
    @Column(name = "away_team_group", length = 50)
    private String away_team_group;

    /** Attribute -
     * ID number and name corresponding to the origin country for
     * the home team in the match
     */
    @OneToOne(mappedBy = "away_team")
    private Country country;

    /** Attribute -
     * Data frame of the manager for the home team with information
     * about the manager described with the variables listed below
     */
    @ManyToOne
    private List<Manager> managers;

    /**
     * Constructor with new managers
     */
    public AwayTeam() {
        this.managers = new ArrayList<>();
    }

    /**
     * @return the information about the id
     */
    public int getAway_team_id()
    {
        return away_team_id;
    }

    /**
     * @param away_team_id with the information about the id
     */
    public void setAway_team_id(int away_team_id)
    {
        this.away_team_id = away_team_id;
    }

    /**
     * @return the information about the name
     */
    public String getAway_team_name()
    {
        return away_team_name;
    }

    /**
     * @param away_team_name with the information about the name
     */
    public void setAway_team_name(String away_team_name)
    {
        this.away_team_name = away_team_name;
    }


    /**
     * @return the gender of the away team
     */
    public String getAway_team_gender()
    {
        return this.away_team_gender;
    }

    /**
     * @param away_team_gender with the gender of the away team
     */
    public void setAway_team_gender(String away_team_gender)
    {
        this.away_team_gender = away_team_gender;
    }

    /**
     * @return the name of the group/conference of the away team
     */
    public String getAway_team_group()
    {
        return this.away_team_group;
    }

    /**
     * @param away_team_group with the name of the group/conference of the away team
     */
    public void setAway_team_group(String away_team_group)
    {
        this.away_team_group = away_team_group;
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
        return "AwayTeam{" +
                "away_team_id=" + away_team_id +
                ", away_team_name='" + away_team_name + '\'' +
                ", away_team_gender='" + away_team_gender + '\'' +
                ", away_team_group='" + away_team_group + '\'' +
                ", country=" + country +
                ", managers=" + managers +
                '}';
    }
}
