package es.iesjandula.statsbomb.models.event;

import es.iesjandula.statsbomb.models.event.shot.FreezeFrame;
import es.iesjandula.statsbomb.models.event.tactics.Lineup;
import jakarta.persistence.*;

/**
 * @author Neil Hdez
 * @author Nacho Belda
 * @author Alejandro Aljarilla
 * In this Class Storage the Player
 */
@Entity
@Table(name = "player")
public class Player
{
    /**
     * Attributes -
     * Id / Name of the player this
     * event relates to (player
     * object will only display if the
     * event is tied to a specific
     * player).
     */
    @Id
    @Column(length = 10)
    private int id; // id
    @Column(length = 25)
    private String name; // name of the Player

    @OneToOne
    private FreezeFrame freezeFrame;
    @OneToOne
    private Lineup lineup;
    @OneToOne
    private Event event;

    /**
     * Empty Constructor
     */
    public Player()
    {

    }

    /**
     * @return the information about the id
     */
    public int getId()
    {
        return id;
    }

    /**
     * @param id with the information about the id
     */
    public void setId(int id)
    {
        this.id = id;
    }

    /**
     * @return name with the information about the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name with the information about the name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return an instance of the class Player as String
     */
    @Override
    public String toString()
    {
        return "Player{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
