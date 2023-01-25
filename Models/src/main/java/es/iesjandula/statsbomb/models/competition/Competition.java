package es.iesjandula.statsbomb.models.competition;

import java.util.Date;

import jakarta.persistence.*;

/**
 * @author Neil Hdez
 * @author Joaquín Moreno
 * @author Manuel Canio Gil
 *
 * Competition information is included for all matches collected.
 * The competition data contains the following information.
 */
@Entity
@Table(name = "competition")
public class Competition
{

	@OneToOne(mappedBy = "competition")
    @EmbeddedId
    private CompetitionId competitionId;

    /** Attribute - The unique identifier for the competition. */
    @Column(length = 10)
    private Integer competition_id;

    /** Attribute - The unique identifier for the season. */
    @Column(length = 10)
    private Integer season_id;

    /** Attribute - The name of the competition. */
    @Column(name = "country_name", nullable = false)
    private String country_name;

    /**
     * Attribute
     * The name of the country the competition relates
     * to (or region for international competitions).
     */
    @Column(name = "competition_name", nullable = false)
    private String competition_name;

    /**
     * Attribute
     * The gender of the players competing in the
     * competition.
     */
    @Column(name = "competition_gender", nullable = false)
    private String competition_gender;

    /** Attribute - Indicates if the competition is young or not. */
    @Column(name = "competition_youth", nullable = false)
    private Boolean competition_youth;

    /** Attribute - Indicates if the competition is international or not. */
    @Column(name = "competition_international", nullable = false)
    private Boolean competition_international;

    /** Attribute - The name of the season. */
    @Column(name = "season_name", nullable = false)
    private String season_name;

    /**
     * Attribute
     * The date and time at which a match within this competition
     * and season was last updated.
     */
    @Column(name = "match_updated", nullable = false)
    private String match_updated;

    /**
     * Attribute
     * The date and time at which a match within this competition
     * and season was last updated.
     */
    private Date match_updated_date;

    /**
     * Attribute
     * The date and time at which a match within this competition
     * and season was last updated from three-sixty
     */
    @Column(name = "match_updated_360", nullable = false)
    private String match_updated_360;

    /**
     * Attribute
     * The date and time at which a match within this competition
     * and season was last updated from three-sixty
     */
    private Date match_updated_360_date;

    /**
     * Attribute
     * The date and time at which an available match
     * was updated, or a match was made available
     * (whichever is more recent) from three-sixty.
     */
    @Column(name = "match_available_360")
    private String match_available_360;

    /**
     * Attribute
     * The date and time at which an available match
     * was updated, or a match was made available
     * (whichever is more recent) from three-sixty.
     */
    private Date match_available_360_date;

    /**
     * Attribute
     * The date and time at which an available match
     * was updated, or a match was made available
     * (whichever is more recent).
     */
    @Column(name = "match_available", nullable = false)
    private String match_available;

    /**
     * Attribute
     * The date and time at which an available match
     * was updated, or a match was made available
     * (whichever is more recent).
     */
    private Date match_available_date;


    /**
     * @return the competitionId KEY_PRIMARY
     */
    public CompetitionId getCompetitionId()
    {
        return this.competitionId;
    }

    /**
     * @param competitionId the competitionId to set KEY_PRIMARY
     */
    public void setCompetitionId(CompetitionId competitionId)
    {
        this.competitionId = competitionId;
    }

    /**
     * @return the competition identification.
     */
    public Integer getCompetition_id()
    {
        return this.competition_id;
    }

    /**
     * @param competition_id with the identification of the competition.
     */
    public void setCompetition_id(Integer competition_id)
    {
        this.competition_id = competition_id;
    }

    /**
     * @return the season identification.
     */
    public Integer getSeason_id()
    {
        return this.season_id;
    }

    /**
     * @param season_id with the identification of the season.
     */
    public void setSeason_id(Integer season_id)
    {
        this.season_id = season_id;
    }

    /**
     * @return the name of the country.
     */
    public String getCountry_name()
    {
        return this.country_name;
    }

    /**
     * @param country_name with the name of the country.
     */
    public void setCountry_name(String country_name)
    {
        this.country_name = country_name;
    }

    /**
     * @return the name of the competition.
     */
    public String getCompetition_name()
    {
        return this.competition_name;
    }

    /**
     * @param competition_name with the name of the competition.
     */
    public void setCompetition_name(String competition_name)
    {
        this.competition_name = competition_name;
    }

    /**
     * @return the gender of the competition.
     */
    public String getCompetition_gender()
    {
        return this.competition_gender;
    }

    /**
     * @param competition_gender with the gender of the competition.
     */
    public void setCompetition_gender(String competition_gender)
    {
        this.competition_gender = competition_gender;
    }

    /**
     * @return if the competition is youth or not.
     */
    public Boolean getCompetition_youth()
    {
        return this.competition_youth;
    }

    /**
     * @param competition_youth with if the competition is youth or not.
     */
    public void setCompetition_youth(Boolean competition_youth)
    {
        this.competition_youth = competition_youth;
    }

    /**
     * @return if the competition is international or not.
     */
    public Boolean getCompetition_international()
    {
        return this.competition_international;
    }

    /**
     * @param competition_international with if the competition is international or not.
     */
    public void setCompetition_international(Boolean competition_international)
    {
        this.competition_international = competition_international;
    }

    /**
     * @return the season name.
     */
    public String getSeason_name()
    {
        return this.season_name;
    }

    /**
     * @param season_name with teh season name.
     */
    public void setSeason_name(String season_name)
    {
        this.season_name = season_name;
    }

    /**
     * @return the date and time at which a match within this competition
     * and season was last updated
     */
    public String getMatch_updated()
    {
        return this.match_updated;
    }

    /**
     * @param match_updated with the date and time at which a match within
     * this competition and season was last updated
     */
    public void setMatch_updated(String match_updated)
    {
        this.match_updated = match_updated;
    }

    /**
     * @return the date and time at which a match within this competition
     * and season was last updated
     */
    public Date getMatch_updated_date()
    {
        return this.match_updated_date;
    }

    /**
     * @param match_updated_date  with the date and time at which a match within this competition
     * and season was last updated
     */
    public void setMatch_updated_date(Date match_updated_date)
    {
        this.match_updated_date = match_updated_date;
    }

    /**
     * @return the date and time at which a match within this competition
     * and season was last updated from three-sixty
     */
    public String getMatch_updated_360()
    {
        return this.match_updated_360;
    }

    /**
     * @param match_updated_360  with the date and time at which a match within this competition
     * and season was last updated from three-sixty
     */
    public void setMatch_updated_360(String match_updated_360)
    {
        this.match_updated_360 = match_updated_360;
    }

    /**
     * @return the date and time at which a match within this
     * competition and season was last updated from three-sixty
     */
    public Date getMatch_updated_360_date()
    {
        return this.match_updated_360_date;
    }

    /**
     * @param match_updated_360_date with the date and time at which
     * a match within this competition and season was last updated
     * from three-sixty.
     */
    public void setMatch_updated_360_date(Date match_updated_360_date)
    {
        this.match_updated_360_date = match_updated_360_date;
    }

    /**
     * @return the date and time at which an available match
     * was updated, or a match was made available
     * (whichever is more recent) from three-sixty.
     */
    public String getMatch_available_360()
    {
        return this.match_available_360;
    }

    /**
     * @param match_available_360 with the date and
     * time at which an available match
     * was updated, or a match was made available
     * (whichever is more recent).
     */
    public void setMatch_available_360(String match_available_360)
    {
        this.match_available_360 = match_available_360;
    }

    /**
     * @return the date and time at which an available match
     * was updated, or a match was made available
     * (whichever is more recent) from three-sixty.
     */
    public Date getMatch_available_360_date()
    {
        return this.match_available_360_date;
    }

    /**
     * @param match_available_360_date with the date and
     * time at which an available match
     * was updated, or a match was made available
     * (whichever is more recent).
     */
    public void setMatch_available_360_date(Date match_available_360_date)
    {
        this.match_available_360_date = match_available_360_date;
    }

    /**
     * @return the date and time at which an available match
     * was updated, or a match was made available
     * (whichever is more recent).
     */
    public String getMatch_available()
    {
        return this.match_available;
    }

    /**
     * @param match_available with the date and time at which
     * an available match was updated, or a match was made available
     * (whichever is more recent).
     */
    public void setMatch_available(String match_available)
    {
        this.match_available = match_available;
    }

    /**
     * @return the date and time at which an available match
     * was updated, or a match was made available
     * (whichever is more recent).
     */
    public Date getMatch_available_date()
    {
        return this.match_available_date;
    }

    /**
     * @param match_available_date with the date and time at which
     * an available match was updated, or a match was made available
     * (whichever is more recent).
     */
    public void setMatch_available_date(Date match_available_date)
    {
        this.match_available_date = match_available_date;
    }

    /**
     * @return the instance of Competition as String.
     */
    @Override
    public String toString()
    {
        return "Competition{" +
                "competition_id=" + competition_id +
                ", season_id=" + season_id +
                ", country_name='" + country_name + '\'' +
                ", competition_name='" + competition_name + '\'' +
                ", competition_gender='" + competition_gender + '\'' +
                ", competition_youth=" + competition_youth +
                ", competition_international=" + competition_international +
                ", season_name='" + season_name + '\'' +
                ", match_updated='" + match_updated + '\'' +
                ", match_updated_date=" + match_updated_date +
                ", match_updated_360='" + match_updated_360 + '\'' +
                ", match_updated_360_date=" + match_updated_360_date +
                ", match_available_360='" + match_available_360 + '\'' +
                ", match_available_360_date=" + match_available_360_date +
                ", match_available='" + match_available + '\'' +
                ", match_available_date=" + match_available_date +
                '}';
    }
}
