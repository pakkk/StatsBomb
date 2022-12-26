package es.iesjandula.statsbomb.threesixty_stats.teammate.result;

public class ResultTeammate 
{
    private String event_uuid;
    private int teammates;
    
    public ResultTeammate()
    {

    }

    public String getEvent_uuid() {
        return event_uuid;
    }

    public void setEvent_uuid(String event_uuid) {
        this.event_uuid = event_uuid;
    }

    public int getTeammates() {
        return teammates;
    }

    public void setTeammates(int teammates) {
        this.teammates = teammates;
    }
}
