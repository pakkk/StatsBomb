package es.iesjandula.statsbomb.models.matches;

import jakarta.persistence.*;

/**
 * @author Oscar Herruzo
 * @author Manuel Canio Gil
 * The ID is the unique identifier for the competition and the 
 * name is the name of the competition
 */
@Entity
@Table(name = "competition")
public class Competition
{
    /**
     * Attribute -
     * The unique identifier for the competition.
     */
    @Id
    @Column(length = 10)
    private int competition_id;

    /**
     * Attribute -
     * The name of the competition.
     */
    @Column(name = "competition_name", length = 100, nullable = false)
    private String competition_name;


    /**
     * Attribute -
     * The name of the country the competition relates to (or region
     * for international competitions)
     */
    @Column(name = "country_name", length = 40)
    private String country_name;

    @ManyToOne
    @JoinColumn(name = "match_id", nullable = false)
    private Match match;

    /**
     * Empty Constructor
     */
    public Competition()
    {
    }

    /**
     * @return The unique identifier for the competition.
     */
    public int getCompetition_id()
    {
        return competition_id;
    }

    /**
     * @param competition_id, of the competition.
     */
    public void setCompetition_id(int competition_id)
    {
        this.competition_id = competition_id;
    }

    /**
     * @return The name of the competition.
     */
    public String getCompetition_name()
    {
        return competition_name;
    }

    /**
     * @param competition_name, name of the competition.
     */
    public void setCompetition_name(String competition_name)
    {
        this.competition_name = competition_name;
    }

    /**
     * @return The name of the country_name.
     */
    public String getCountry_name() {
        return country_name;
    }

    /**
     * @param country_name, name of the country_name.
     */
    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    /**
     * @return a instance of competition as string
     */
    @Override
    public String toString() {
        return "Competition{" +
                "id=" + competition_id +
                ", name='" + competition_name + '\'' +
                ", country_name='" + country_name + '\'' +
                '}';
    }
}
