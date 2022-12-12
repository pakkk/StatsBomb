package es.iesjandula.statsbomb.models.open_event.tactics;

import es.iesjandula.statsbomb.models.open_event.Player;
import es.iesjandula.statsbomb.models.open_event.Position;

/**
 * @author Neil Hdez
 * @version 1.0.0
 * @since 30/11/2022
 */
public class Lineup
{

    private Player player;
    private Position position;
    private int jersey_number;


    public Lineup()
    {

    }

    public Player getPlayer()
    {
        return this.player;
    }

    public void setPlayer(Player player)
    {
        this.player = player;
    }

    public Position getPosition()
    {
        return this.position;
    }

    public void setPosition(Position position)
    {
        this.position = position;
    }

    public int getJersey_number()
    {
        return jersey_number;
    }

    public void setJersey_number(int jersey_number)
    {
        this.jersey_number = jersey_number;
    }

    @Override
    public String toString()
    {
        return "Lineup{" + "player=" + player + ", position=" + position + '}';
    }
}
