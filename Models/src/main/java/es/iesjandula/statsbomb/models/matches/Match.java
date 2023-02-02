package es.iesjandula.statsbomb.models.matches;


import com.fasterxml.jackson.annotation.JsonIgnore;
import es.iesjandula.statsbomb.common.utils.DateUtils;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

/**
 * @author David Armijo Ramos
 * @author Alejandro Aljarilla
 * The match information for each they collect
 */
@Entity
@Table(name = "match")
public class Match
{

    /**
     * Attribute -
     * The unique identifier for the match (required to request
     * events)
     */
    @Id
    @Column(length = 10)
    private int match_id;

    /**
     * Attribute -
     * The ID is the unique identifier for the competition and the
     * name is the name of the competition
     */
    @OneToMany(mappedBy = "match")
    private List<Competition> competition;


    /**
     * Attribute -
     * The ID is the unique identifier for the season and the name is
     * the name of the season
     */
    @OneToMany(mappedBy = "match")
    private List<Season> season;

    /** Attribute - The date of the Match in type String*/
    @Column(length = 10)
    private String match_date;

    /** Attribute - The date of the Match in type Date*/
    @JsonIgnore
    private Date match_date_javaUtilDate;

    /** Attribute - The time of the Match in type String*/
    @Column(length = 20)
    private String kick_off;

    /** Attribute - The time of the Match in type Date*/
    @JsonIgnore
    private Date kick_off_javaUtilDate;

    /**
     * Attribute -
     * The ID is the unique identifier for the stadium and the name is
     * the name of the stadium
     */
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Stadium stadium;

    /** Attribute -
     * The ID is the unique identifier for the referee and the name is
     * the name of the referee
     */
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Referee referee;

    /** Attribute -
     * The unique identifier integer and the name for the home team
     * in this match
     */
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private HomeTeam home_team;

    /** Attribute -
     * The unique identifier integer and the name for the away team
     * in this match
     */
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private AwayTeam away_team;

    /** Attribute - The final score of the home team */
    @Column(length = 2)
    private int home_score;

    /** Attribute - The final score of the away team  */
    @Column(length = 2)
    private int away_score;

    /** Attribute -
     * The current status of collection for this match. Only “available”
     * matches are present in the Open Data repository
     */
    @Column(length = 20)
    private String match_status;

    @Column(length = 20)
    private String match_status_360;

    /** Attribute -
     * Number corresponding to the weeks into the competition this
     * match is
     */
    @Column(length = 5)
    private int match_week;

    /** Attribute - id/name pair of the phase of the competition this match is in  */
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private CompetitionStage competition_stage;

    /** Attribute -
     * The date and time at which this match information was last
     * updated in type String
     */
    @Column(length = 20)
    private String last_updated;

    /** Attribute -
     * The date and time at which this match information was last
     * updated in type Date
     */
    @JsonIgnore
    private Date last_updated_javaUtilDate;

    @Column(length = 20)
    private String last_updated_360;

    @JsonIgnore
    private Date last_updated_360_javaUtilDate;

    /** Attribute -
     * Contains a list of tags detailing the versions of various parts of
     * the event data for this match
     */
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Metadata metadata;

    /** Attribute -
     * The version number for the method in which the data was
     * collected
     */
    @Column(length = 20)
    private String data_version;

    /**
     * Empty Constructor
     */
    public Match()
    {

    }

    /**
     * @return the identification of the match
     */
    public int getMatch_id()
    {
        return this.match_id;
    }

    /**
     * @param match_id with the identification of the match
     */
    public void setMatch_id(int match_id)
    {
        this.match_id = match_id;
    }

    /**
     * @return the information about competition
     */
    public List<Competition> getCompetition()
    {
        return this.competition;
    }

    /**
     * @param competition with the information about competition
     */
    public void setCompetition(Competition competition)
    {
        this.competition.add(competition);
    }

    /**
     * @return the information about season
     */
    public List<Season> getSeason()
    {
        return this.season;
    }

    /**
     * @param season with the information about season
     */
    public void setSeason(Season season)
    {
        this.season.add(season);
    }

    /**
     * @return the date of the Match in type String
     */
    public String getMatch_date()
    {
        return this.match_date;
    }

    /**
     * @param match_date with the date of the Match
     */
    public void setMatch_date(String match_date)
    {
        this.match_date = match_date;
        DateUtils dateUtils = new DateUtils();

        this.match_date_javaUtilDate = dateUtils.convertStringToDateFormatyyyyMMdd(this.match_date);

    }

    /**
     * @return the date of the Match in type Date
     */
    public Date getMatch_date_javaUtilDate()
    {
        return this.match_date_javaUtilDate;
    }

    /**
     * @return the time of the Match in type String
     */
    public String getKick_off()
    {
        return this.kick_off;
    }

    /**
     * @param kick_off the time of the Match
     */
    public void setKick_off(String kick_off)
    {
        this.kick_off = kick_off;
        DateUtils dateUtils = new DateUtils();

        this.kick_off_javaUtilDate = dateUtils.convertStringToDateFormatHHmmssSSS(this.kick_off);

    }

    /**
     * @return the time of the Match in type Date
     */
    public Date getKick_off_javaUtilDate()
    {
        return kick_off_javaUtilDate;
    }

    /**
     * @return the information about stadium
     */
    public Stadium getStadium()
    {
        return this.stadium;
    }

    /**
     * @param stadium with the information about stadium
     */
    public void setStadium(Stadium stadium)
    {
        this.stadium = stadium;
    }

    /**
     * @return the information about referee_name
     */
    public Referee getReferee()
    {
        return this.referee;
    }

    /**
     *
     * @param referee with the information about referee_name
     */
    public void setReferee(Referee referee)
    {
        this.referee = referee;
    }

    /**
     * @return the information about home_team
     */
    public HomeTeam getHome_team()
    {
        return this.home_team;
    }

    /**
     * @param home_Home_team with the information about home_team
     */
    public void setHome_team(HomeTeam home_Home_team)
    {
        this.home_team = home_Home_team;
    }

    /**
     * @return the information about away_team
     */
    public AwayTeam getAway_team()
    {
        return this.away_team;
    }

    /**
     * @param away_Home_team with the information about away_team
     */
    public void setAway_team(AwayTeam away_Home_team)
    {
        this.away_team = away_Home_team;
    }

    /**
     * @return the final score of the home team
     */
    public int getHome_score()
    {
        return this.home_score;
    }

    /**
     * @param home_score with the final score of the home team
     */
    public void setHome_score(int home_score)
    {
        this.home_score = home_score;
    }

    /**
     * @return the final score of the away team
     */
    public int getAway_score()
    {
        return this.away_score;
    }

    /**
     * @param away_score with the final score of the away team
     */
    public void setAway_score(int away_score)
    {
        this.away_score = away_score;
    }

    /**
     * @return the current status of collection
     */
    public String getMatch_status()
    {
        return this.match_status;
    }

    /**
     * @param match_status with the current status of collection
     */
    public void setMatch_status(String match_status)
    {
        this.match_status = match_status;
    }

    /**
     * @return the number corresponding to the weeks into the competition
     */
    public int getMatch_week()
    {
        return this.match_week;
    }

    /**
     * @param match_week with the number corresponding to the weeks into the competition
     */
    public void setMatch_week(int match_week)
    {
        this.match_week = match_week;
    }

    public String getMatch_status_360() {
        return match_status_360;
    }

    public void setMatch_status_360(String match_status_360) {
        this.match_status_360 = match_status_360;
    }

    /**
     * @return the information about competition_stage
     */
    public CompetitionStage getCompetition_stage()
    {
        return this.competition_stage;
    }

    /**
     * @param competition_stage with the information about competition_stage
     */
    public void setCompetition_stage(CompetitionStage competition_stage)
    {
        this.competition_stage = competition_stage;
    }

    /**
     * @return the date and time at which this match in type String
     */
    public String getLast_updated()
    {
        return this.last_updated;
    }

    /**
     * @param last_updated with the date and time at which this match
     */
    public void setLast_updated(String last_updated)
    {
        this.last_updated = last_updated;

        DateUtils dateUtils = new DateUtils();
        this.last_updated_javaUtilDate = dateUtils.convertStringToDateFormatyyyyMMddTHHmmssSSS(this.last_updated);
    }

    /**
     * @return the date and time at which this match in type Date
     */
    public Date getLast_updated_javaUtilDate() {
        return last_updated_javaUtilDate;
    }

    public String getLast_updated_360() {
        return last_updated_360;
    }

    public void setLast_updated_360(String last_updated_360) {
        this.last_updated_360 = last_updated_360;

        DateUtils dateUtils = new DateUtils();
        this.last_updated_360_javaUtilDate = dateUtils.convertStringToDateFormatyyyyMMddTHHmmssSSS(this.last_updated_360);
    }

    public Date getLast_updated_360_javaUtilDate() {
        return last_updated_360_javaUtilDate;
    }

    /**
     * @return the information about metadata
     */
    public Metadata getMetadata()
    {
        return this.metadata;
    }

    /**
     * @param metadata with the information about metadata
     */
    public void setMetadata(Metadata metadata)
    {
        this.metadata = metadata;
    }

    /**
     * @return the information about data_version
     */
    public String getData_version()
    {
        return this.data_version;
    }

    /**
     * @param data_version with the information about data_version
     */
    public void setData_version(String data_version)
    {
        this.data_version = data_version;
    }

    /**
     * @return the instance of Match as String
     */
    @Override
    public String toString() {
        return "Match{" +
                "match_id=" + match_id +
                ", competition=" + competition +
                ", season=" + season +
                ", match_date='" + match_date + '\'' +
                ", match_date_javaUtilDate=" + match_date_javaUtilDate +
                ", kick_off='" + kick_off + '\'' +
                ", kick_off_javaUtilDate=" + kick_off_javaUtilDate +
                ", stadium=" + stadium +
                ", referee=" + referee +
                ", home_team=" + home_team +
                ", away_team=" + away_team +
                ", home_score=" + home_score +
                ", away_score=" + away_score +
                ", match_status='" + match_status + '\'' +
                ", match_week=" + match_week +
                ", competition_stage=" + competition_stage +
                ", last_updated='" + last_updated + '\'' +
                ", last_updated_javaUtilDate=" + last_updated_javaUtilDate +
                ", metadata=" + metadata +
                ", data_version='" + data_version + '\'' +
                '}';
    }
}
