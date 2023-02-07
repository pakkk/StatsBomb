package es.iesjandula.statsbomb.common.dtos;


public class CompetitionsDto
{
    /** Attribute - The unique identifier for the competition. */
    private Integer competition_id;

    /** Attribute - The unique identifier for the season. */
    private Integer season_id;

    /**
     * Attribute
     * The date and time at which an available match
     * was updated, or a match was made available
     * (whichever is more recent) from three-sixty.
     */
    private String match_available_360;

    /**
     * Attribute
     * The date and time at which an available match
     * was updated, or a match was made available
     * (whichever is more recent).
     */
    private String match_available;

    public CompetitionsDto()
    {
    }

    public Integer getCompetition_id()
    {
        return this.competition_id;
    }

    public void setCompetition_id(Integer competition_id)
    {
        this.competition_id = competition_id;
    }

    public Integer getSeason_id()
    {
        return this.season_id;
    }

    public void setSeason_id(Integer season_id)
    {
        this.season_id = season_id;
    }

    public String getMatch_available_360()
    {
        return this.match_available_360;
    }

    public void setMatch_available_360(String match_available_360)
    {
        this.match_available_360 = match_available_360;
    }

    public String getMatch_available()
    {
        return this.match_available;
    }

    public void setMatch_available(String match_available)
    {
        this.match_available = match_available;
    }
}
