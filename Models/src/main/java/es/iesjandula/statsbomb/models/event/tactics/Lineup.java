package es.iesjandula.statsbomb.models.event.tactics;

import es.iesjandula.statsbomb.models.event.Player;
import es.iesjandula.statsbomb.models.event.Position;

/**
 * @author Neil Hdez
 * @author Jesus Garcia Puerto
 * @version 1.0.0
 * @since 30/11/2022
 */
public class Lineup
{
	/**
	 * Attribute - Information of the player
	 */
    private Player player;
    /**
     * Attribute - Information about the position of the player
     */
    private Position position;
    /**
     * Attribute - The number on the player's shirt for the match
     */
    private int jersey_number;
    
    /**
     * Empty Constructor
     */
    public Lineup()
    {

    }
    
    /**
     * @return a instance of Player
     */
    public Player getPlayer()
    {
        return this.player;
    }
    
    /**
     * @param player, instance of Player with information about a player
     */
    public void setPlayer(Player player)
    {
        this.player = player;
    }

    /**
     * @return a instance of Position
     */
    public Position getPosition()
    {
        return this.position;
    }
    
    /**
     * @param position, instance of Position with information about the player's position
     */
    public void setPosition(Position position)
    {
        this.position = position;
    }

    /**
     * @return the number on the player's shirt for the match
     */
    public int getJersey_number()
    {
        return this.jersey_number;
    }
    
    /**
     * @param jersey_number, number on the player's shirt for the match
     */
    public void setJersey_number(int jersey_number)
    {
        this.jersey_number = jersey_number;
    }

    /**
     * @return a instance of Lineup as String
     */
    @Override
    public String toString()
    {
        return "Lineup{" + "player=" + player + ", position=" + position + '}';
    }
}
