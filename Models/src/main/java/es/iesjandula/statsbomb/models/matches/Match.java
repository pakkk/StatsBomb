package es.iesjandula.statsbomb.models.matches;

import es.iesjandula.statsbomb.common.exception.StatsBombException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Este es la clase principal del modelo matches
 * @author David Armijo Ramos
 */
public class Match
{
    private final Logger logger = LogManager.getLogger();

    private int match_id;
    private Competition competition;
    private String country_name;
    private Season season;
    private String match_date; // Es un Date en Json
    private Date match_date_javaUtilDate;
    private String kick_off; // Es un Date en Json
    private Date kick_off_javaUtilDate;
    private Stadium stadium;
    private String stadium_country;
    private RefereeName referee_name;
    private RefereeCountry referee_country;
    private HomeTeam home_team;
    private String home_team_gender;
    private HomeTeamManager home_team_manager;
    private HomeTeamCountry home_team_country;
    private AwayTeam away_team;
    private String away_team_gender;
    private AwayTeamManager away_team_manager;
    private String away_team_group;
    private int home_score;
    private int away_score;
    private String match_status;
    private int match_week;
    private CompetitionStage competition_stage;
    private String last_updated; // Es un Date en Json
    private Date last_updated_javaUtilDate;
    private Metadata metadata;
    private String data_version;

    /**
     * Constructor vacio para la clase
     */
    public Match()
    {

    }


    public int getMatch_id()
    {
        return this.match_id;
    }

    public void setMatch_id(int match_id)
    {
        this.match_id = match_id;
    }

    public Competition getCompetition()
    {
        return this.competition;
    }

    public void setCompetition(Competition competition)
    {
        this.competition = competition;
    }

    public String getCountry_name()
    {
        return this.country_name;
    }

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
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try
        {
            this.match_date_javaUtilDate = dateFormat.parse(this.match_date);
        }
        catch (ParseException parseException)
        {
            String errorMessage = "Cannot parse the field 'match_date' to java.util.Date";
            logger.error(errorMessage, parseException);
            throw new StatsBombException(errorMessage, parseException);
        }
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
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss.SSS");

        try
        {
            this.kick_off_javaUtilDate = dateFormat.parse(this.kick_off);
        }
        catch (ParseException parseException)
        {
            String errorMessage = "Cannot parse the field 'kick_off' to java.util.Date";
            logger.error(errorMessage, parseException);
            throw new StatsBombException(errorMessage, parseException);
        }
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

    public RefereeCountry getReferee_country()
    {
        return this.referee_country;
    }

    public void setReferee_country(RefereeCountry referee_country)
    {
        this.referee_country = referee_country;
    }

    public HomeTeam getHome_team()
    {
        return this.home_team;
    }

    public void setHome_team(HomeTeam home_team)
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

    public HomeTeamManager getHome_team_manager()
    {
        return this.home_team_manager;
    }

    public void setHome_team_manager(HomeTeamManager home_team_manager)
    {
        this.home_team_manager = home_team_manager;
    }

    public HomeTeamCountry getHome_team_country()
    {
        return this.home_team_country;
    }

    public void setHome_team_country(HomeTeamCountry home_team_country)
    {
        this.home_team_country = home_team_country;
    }

    public AwayTeam getAway_team()
    {
        return this.away_team;
    }

    public void setAway_team(AwayTeam away_team)
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

    public AwayTeamManager getAway_team_manager()
    {
        return this.away_team_manager;
    }

    public void setAway_team_manager(AwayTeamManager away_team_manager)
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

        try
        {
            this.last_updated_javaUtilDate = dateFormat.parse(this.last_updated);
        }
        catch (ParseException parseException)
        {
            String errorMessage = "Cannot parse the field 'last_updated' to java.util.Date";
            logger.error(errorMessage, parseException);
            throw new StatsBombException(errorMessage, parseException);
        }

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
}
