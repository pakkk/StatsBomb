package es.iesjandula.statsbomb.models.event.shot;

import es.iesjandula.statsbomb.models.event.Player;
import es.iesjandula.statsbomb.models.event.Position;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.List;

/**
 * @author Neil Hdez
 * @author Alejandro Aljarilla
 * @version 1.0.0
 * @since 30/11/2022
 *
 * Each shot includes an object
 * called freeze_frame which is
 * an array containing
 * information about relevant
 * players at the time of the shot.
 * Each freezeframe object is a
 * data frame with a row for each
 * player including their location,
 * team, id, name and position id
 * and name.
 */
@Entity
@Table(name = "freeze_frame")
public class FreezeFrame
{

    /** Attribute - With coordinate of player */
    @Id
    @Column(length = 20)
    private List<Integer> location;

    /** Attribute - With Information about Player */
    private Player player;

    /** Attribute - With information about position */
    private Position position;

    /** Attribute - With information about teammate */
    @Column(length = 7)
    private Boolean teammate;

    FreezeFrame()
    {

    }

    /**
     * @return The Location Information
     */
    public List<Integer> getLocation()
    {
        return location;
    }

    /**
     * @param location With the Information about location player
     */
    public void setLocation(List<Integer> location)
    {
        this.location = location;
    }

    /**
     * @return Players in the Shoot
     */
    public Player getPlayer()
    {
        return player;
    }

    /**
     * @param player Information about players in the Shot
     */
    public void setPlayer(Player player)
    {
        this.player = player;
    }

    /**
     * @return Position Information
     */
    public Position getPosition()
    {
        return position;
    }

    /**
     * @param position Information about positions in the shot
     */
    public void setPosition(Position position)
    {
        this.position = position;
    }

    /**
     * @return TeamMate Information
     */
    public Boolean getTeammate()
    {
        return teammate;
    }

    /**
     * @param teammate Information about teammate in the shot
     */
    public void setTeammate(Boolean teammate)
    {
        this.teammate = teammate;
    }

    @Override
    public String toString()
    {
        return "FreezeFrame{" +
                "location=" + this.location +
                ", player=" + this.player +
                ", position=" + this.position +
                ", teammate=" + this.teammate +
                '}';
    }
}
