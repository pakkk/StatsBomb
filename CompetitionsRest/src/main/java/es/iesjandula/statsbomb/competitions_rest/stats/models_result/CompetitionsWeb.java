package es.iesjandula.statsbomb.competitions_rest.stats.models_result;

import es.iesjandula.statsbomb.models.competition.CompetitionId;

/**
 * @author Neil Hdez
 * @version 1.0.0
 * @since 02/02/2023
 */
public class CompetitionsWeb
{

    private CompetitionId competition_id;

    /*Atributee competition_name*/
    private String competition_name;

    /*Atributee season_name*/
    private String season_name;

    /* Constructor */
    public CompetitionsWeb(CompetitionId competition_id, String competition_name, String season_name)
    {
        this.competition_id = competition_id;
        this.competition_name = competition_name;
        this.season_name = season_name;
    }

    /* Getters and Setters */

    /**
     * @return the competition_id
     */
    public CompetitionId getCompetition_id()
    {
        return competition_id;
    }

    /**
     * @param competition_id the competition_id to set
     */
    public void setCompetition_id(CompetitionId competition_id)
    {
        this.competition_id = competition_id;
    }

    /**
     * @return the competition_name
     */
    public String getCompetition_name()
    {
        return competition_name;
    }

    /**
     * @param competition_name the competition_name to set
     */
    public void setCompetition_name(String competition_name)
    {
        this.competition_name = competition_name;
    }

    /**
     * @return the season_name
     */
    public String getSeason_name()
    {
        return season_name;
    }

    /**
     * @param season_name the season_name to set
     */
    public void setSeason_name(String season_name)
    {
        this.season_name = season_name;
    }
}
