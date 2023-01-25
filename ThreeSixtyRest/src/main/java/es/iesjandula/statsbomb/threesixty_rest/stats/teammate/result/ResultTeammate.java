package es.iesjandula.statsbomb.threesixty_rest.stats.teammate.result;

public class ResultTeammate 
{
    private String event_uuid;
    private int team_mate;
    private int no_team_mate;
    
    public ResultTeammate(String event_uuid)
    {
        this.event_uuid = event_uuid ;
    }

    public String getEvent_uuid()
    {
        return this.event_uuid;
    }

    public int getTeam_mate()
    {
        return this.team_mate;
    }

    public void setTeam_mate(int team_mate)
    {
        this.team_mate = team_mate;
    }

    public int getNo_team_mate()
    {
        return this.no_team_mate;
    }

    public void setNo_team_mate(int no_team_mate)
    {
        this.no_team_mate = no_team_mate;
    }
}
