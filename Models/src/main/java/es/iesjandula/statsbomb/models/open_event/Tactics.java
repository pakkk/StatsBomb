package es.iesjandula.statsbomb.models.open_event;


import es.iesjandula.statsbomb.models.open_event.tactics.Lineup;

import java.util.List;

/**
 * @author Neil Hdez
 * @version 1.0.0
 * @since 30/11/2022
 * In this Class Storage the Position
 */
public class Tactics
{
    public String formation;
    private List<Lineup> lineup;

    public Tactics()
    {

    }

    public String getFormation()
    {
        return this.formation;
    }

    public void setFormation(String formation)
    {
        this.formation = formation;
    }

    public List<Lineup> getLineup()
    {
        return this.lineup;
    }

    public void setLineup(List<Lineup> lineup)
    {
        this.lineup = lineup;
    }

    @Override
    public String toString()
    {
        return "Tactics{" + "formation='" + formation + '\'' + ", lineup=" + lineup + '}';
    }
}
