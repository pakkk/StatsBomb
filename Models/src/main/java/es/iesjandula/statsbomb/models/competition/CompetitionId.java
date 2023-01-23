package es.iesjandula.statsbomb.models.competition;

import jakarta.persistence.Embeddable;

import java.io.Serial;
import java.io.Serializable;

@Embeddable
public class CompetitionId implements Serializable
{

    @Serial
    private static final long serialVersionUID = 8794888247931281796L;

    private Integer competition_id;

    private Integer season_id;

    public CompetitionId()
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
}
