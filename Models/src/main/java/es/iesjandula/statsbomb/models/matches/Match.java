package es.iesjandula.statsbomb.models.matches;

import es.iesjandula.statsbomb.common.exception.StatsBombException;
import es.iesjandula.statsbomb.common.utils.DateUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author David Armijo Ramos
 * The match information for each they collect
 */
public class Match
{

    private final Logger logger = LogManager.getLogger();

    /**
     * Attribute -
     * The unique identifier for the match (required to request
     * events)
     */
    private int match_id;

    /**
     * Attribute -
     * The ID is the unique identifier for the competition and the
     * name is the name of the competition
     */
    private Competition competition;

    /**
     * Attribute -
     * The name of the country the competition relates to (or region
     * for international competitions)
     */
    private String country_name;

    /**
     * Attribute -
     * The ID is the unique identifier for the season and the name is
     * the name of the season
     */
    private Season season;

    /** Attribute - The date of the Match */
    private String match_date;
    private Date match_date_javaUtilDate;

    /** Attribute - The time of the Match  */
    private String kick_off;
    private Date kick_off_javaUtilDate;

    /**
     * Attribute -
     * The ID is the unique identifier for the stadium and the name is
     * the name of the stadium
     */
    private Stadium stadium;

    /** Attribute - The name of the country the stadium is in */
    private String stadium_country;

    /** Attribute -
     * The ID is the unique identifier for the referee and the name is
     * the name of the referee
     */
    private RefereeName referee_name;

    /** Attribute -
     * The ID is the unique identifier for the country and the name is
     * the name of the country
     */
    private Country referee_country;

    /** Attribute -
     * The unique identifier integer and the name for the home team
     * in this match
     */
    private Team home_team;

    /** Attribute - Gender of the home team in the match */
    private String home_team_gender;

    /** Attribute -
     * Data frame of the manager for the home team with information
     * about the manager described with the variables listed below
     */
    private Manager home_team_manager;

    /** Attribute - Name of the group/conference of the team in the match */
    private String home_team_group;

    /** Attribute -
     * ID number and name corresponding to the origin country for
     * the home team in the match
     */
    private Country home_team_country;

    /** Attribute -
     * The unique identifier integer and the name for the away team
     * in this match
     */
    private Team away_team;

    /** Attribute - Gender of the away team in the match */
    private String away_team_gender;

    /** Attribute -
     * Data frame of the manager for the away team with information
     * about the manager described with the variables listed below
     */
    private Manager away_team_manager;

    /** Attribute - Name of the group/conference of the team in the match */
    private String away_team_group;


    /** Attribute -
     * ID number and name corresponding to the origin country for
     * the away team in the match
     */
    private Country away_team_country;

    /** Attribute - The final score of the home team */
    private int home_score;

    /** Attribute - The final score of the away team  */
    private int away_score;

    /** Attribute -
     * The current status of collection for this match. Only “available”
     * matches are present in the Open Data repository
     */
    private String match_status;

    /** Attribute -
     * Number corresponding to the weeks into the competition this
     * match is
     */
    private int match_week;

    /** Attribute - id/name pair of the phase of the competition this match is in  */
    private CompetitionStage competition_stage;

    /** Attribute -
     * The date and time at which this match information was last
     * updated
     */
    private String last_updated;
    private Date last_updated_javaUtilDate;

    /** Attribute -
     * Contains a list of tags detailing the versions of various parts of
     * the event data for this match
     */
    private Metadata metadata;

    /** Attribute -
     * The version number for the method in which the data was
     * collected
     */
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
    public Competition getCompetition()
    {
        return this.competition;
    }

    /**
     * @param competition with the information about competition
     */
    public void setCompetition(Competition competition)
    {
        this.competition = competition;
    }

    /**
     * @return the name of Country
     */
    public String getCountry_name()
    {
        return this.country_name;
    }

    /**
     * @param country_name with the name of Country
     */
    public void setCountry_name(String country_name)
    {
        this.country_name = country_name;
    }


    public Season getSeason()
    {
        return this.season;
    }

    public void setSeason(Season season)
    {
        this.season = season;
    }

    public String getMatch_date()
    {
        return this.match_date;
    }

    public void setMatch_date(String match_date) throws StatsBombException
    {
        this.match_date = match_date;
        DateUtils dateUtils = new DateUtils();

        this.match_date_javaUtilDate = dateUtils.convertStringToDateFormatyyyyMMdd(this.match_date);

    }

    public Date getMatch_date_javaUtilDate()
    {
        return this.match_date_javaUtilDate;
    }

    public String getKick_off()
    {
        return this.kick_off;
    }

    public void setKick_off(String kick_off) throws StatsBombException
    {
        this.kick_off = kick_off;
        DateUtils dateUtils = new DateUtils();

        this.kick_off_javaUtilDate = dateUtils.convertStringToDateFormatHHmmssSSS(this.kick_off);

    }

    public Date getKick_off_javaUtilDate() {
        return kick_off_javaUtilDate;
    }

    public Stadium getStadium()
    {
        return this.stadium;
    }

    public void setStadium(Stadium stadium)
    {
        this.stadium = stadium;
    }

    public String getStadium_country()
    {
        return this.stadium_country;
    }

    public void setStadium_country(String stadium_country)
    {
        this.stadium_country = stadium_country;
    }

    public RefereeName getReferee_name()
    {
        return this.referee_name;
    }

    public void setReferee_name(RefereeName referee_name)
    {
        this.referee_name = referee_name;
    }

    public Country getReferee_country()
    {
        return this.referee_country;
    }

    public void setReferee_country(Country referee_country)
    {
        this.referee_country = referee_country;
    }

    public Team getHome_team()
    {
        return this.home_team;
    }

    public void setHome_team(Team home_team)
    {
        this.home_team = home_team;
    }

    public String getHome_team_gender()
    {
        return this.home_team_gender;
    }

    public void setHome_team_gender(String home_team_gender)
    {
        this.home_team_gender = home_team_gender;
    }

    public Manager getHome_team_manager()
    {
        return this.home_team_manager;
    }

    public void setHome_team_manager(Manager home_team_manager)
    {
        this.home_team_manager = home_team_manager;
    }

    public String getHome_team_group() {
        return home_team_group;
    }

    public void setHome_team_group(String home_team_group) {
        this.home_team_group = home_team_group;
    }

    public Country getHome_team_country()
    {
        return this.home_team_country;
    }

    public void setHome_team_country(Country home_team_country)
    {
        this.home_team_country = home_team_country;
    }

    public Team getAway_team()
    {
        return this.away_team;
    }

    public void setAway_team(Team away_team)
    {
        this.away_team = away_team;
    }

    public String getAway_team_gender()
    {
        return this.away_team_gender;
    }

    public void setAway_team_gender(String away_team_gender)
    {
        this.away_team_gender = away_team_gender;
    }

    public Manager getAway_team_manager()
    {
        return this.away_team_manager;
    }

    public void setAway_team_manager(Manager away_team_manager)
    {
        this.away_team_manager = away_team_manager;
    }

    public String getAway_team_group()
    {
        return this.away_team_group;
    }

    public void setAway_team_group(String away_team_group)
    {
        this.away_team_group = away_team_group;
    }

    public Country getAway_team_country() {
        return away_team_country;
    }

    public void setAway_team_country(Country away_team_country) {
        this.away_team_country = away_team_country;
    }

    public int getHome_score()
    {
        return this.home_score;
    }

    public void setHome_score(int home_score)
    {
        this.home_score = home_score;
    }

    public int getAway_score()
    {
        return this.away_score;
    }

    public void setAway_score(int away_score)
    {
        this.away_score = away_score;
    }

    public String getMatch_status()
    {
        return this.match_status;
    }

    public void setMatch_status(String match_status)
    {
        this.match_status = match_status;
    }

    public int getMatch_week()
    {
        return this.match_week;
    }

    public void setMatch_week(int match_week)
    {
        this.match_week = match_week;
    }

    public CompetitionStage getCompetition_stage()
    {
        return this.competition_stage;
    }

    public void setCompetition_stage(CompetitionStage competition_stage)
    {
        this.competition_stage = competition_stage;
    }

    public String getLast_updated()
    {
        return this.last_updated;
    }

    public void setLast_updated(String last_updated) throws StatsBombException {
        this.last_updated = last_updated;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSS");

        DateUtils dateUtils = new DateUtils();
        this.last_updated_javaUtilDate = dateUtils.convertStringToDateFormatyyyyMMddTHHmmssSSS(this.last_updated);


    }

    public Date getLast_updated_javaUtilDate() {
        return last_updated_javaUtilDate;
    }

    public Metadata getMetadata()
    {
        return this.metadata;
    }

    public void setMetadata(Metadata metadata)
    {
        this.metadata = metadata;
    }

    public String getData_version()
    {
        return this.data_version;
    }

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
                "match_id=" + this.match_id +
                ", competition=" + this.competition +
                ", country_name='" + this.country_name +
                ", season=" + this.season +
                ", match_date='" + this.match_date +
                ", match_date_javaUtilDate=" + this.match_date_javaUtilDate +
                ", kick_off='" + this.kick_off +
                ", kick_off_javaUtilDate=" + this.kick_off_javaUtilDate +
                ", stadium=" + this.stadium +
                ", stadium_country='" + this.stadium_country +
                ", referee_name=" + this.referee_name +
                ", referee_country=" + this.referee_country +
                ", home_team=" + this.home_team +
                ", home_team_gender='" + this.home_team_gender +
                ", home_team_manager=" + this.home_team_manager +
                ", home_team_group='" + this.home_team_group +
                ", home_team_country=" + this.home_team_country +
                ", away_team=" + this.away_team +
                ", away_team_gender='" + this.away_team_gender +
                ", away_team_manager=" + this.away_team_manager +
                ", away_team_group='" + this.away_team_group +
                ", away_team_country=" + this.away_team_country +
                ", home_score=" + this.home_score +
                ", away_score=" + this.away_score +
                ", match_status='" + this.match_status +
                ", match_week=" + this.match_week +
                ", competition_stage=" + this.competition_stage +
                ", last_updated='" + this.last_updated +
                ", last_updated_javaUtilDate=" + this.last_updated_javaUtilDate +
                ", metadata=" + this.metadata +
                ", data_version='" + this.data_version +
                '}';
    }
}
