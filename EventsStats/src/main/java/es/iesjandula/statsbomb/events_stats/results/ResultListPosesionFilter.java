package es.iesjandula.statsbomb.events_stats.results;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Neil Hdez
 * @version 1.0.0
 * @since 24/12/2022
 */
public class ResultListPosesionFilter
{

    int posession;
    String team;
    List<String> actions;

    public ResultListPosesionFilter()
    {
        actions = new ArrayList<>();
    }

    public ResultListPosesionFilter(int posession, String team, List<String> actions)
    {
        this.posession = posession;
        this.team = team;
        this.actions = actions;
    }

    public int getPosession()
    {
        return posession;
    }

    public void setPosession(int posession)
    {
        this.posession = posession;
    }

    public String getTeam()
    {
        return team;
    }

    public void setTeam(String team)
    {
        this.team = team;
    }

    public List<String> getActions()
    {
        return actions;
    }

    public void setActions(List<String> actions)
    {
        this.actions = actions;
    }
}
