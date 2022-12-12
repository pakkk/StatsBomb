package es.iesjandula.statsbomb.models.open_event.shot;
import es.iesjandula.statsbomb.models.open_event.Player;
import es.iesjandula.statsbomb.models.open_event.Position;

import java.util.List;

public class FreezeFrame
{

    private List<Integer> location;
    private Player player;
    private Position position;
    private Boolean teammate;

    FreezeFrame()
    {

    }

    public List<Integer> getLocation()
    {
        return location;
    }

    public void setLocation(List<Integer> location)
    {
        this.location = location;
    }

    public Player getPlayer()
    {
        return player;
    }

    public void setPlayer(Player player)
    {
        this.player = player;
    }

    public Position getPosition()
    {
        return position;
    }

    public void setPosition(Position position)
    {
        this.position = position;
    }

    public Boolean getTeammate()
    {
        return teammate;
    }

    public void setTeammate(Boolean teammate)
    {
        this.teammate = teammate;
    }
}
