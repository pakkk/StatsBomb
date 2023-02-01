package es.iesjandula.statsbomb.models.event;

import jakarta.persistence.*;

/**
 * @author Neil Hdez
 * @author Nacho Belda
 * @author Alejandro Aljarilla
 * This Class Storage the PlayPattern, Ej. Regular Play, From Corner, From Free Kick
 */
@Entity
@Table(name = "play_pattern")
public class PlayPattern
{
    /**
     * Attributes -
     * Id /name of the play pattern
     * relevant to this event.
     */
    @Id
    @Column(length = 10)
    private int id; // id

    @Column(length = 25)
    private String name; // name of the Play Pattern

    @OneToOne(mappedBy = "play_pattern")
    private Event event;

    /**
     * Empty constructor
     */
    public PlayPattern()
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
     * @return the information about the name
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
     * @return an instance of the class PlayPattern as String
     */
    @Override
    public String toString()
    {
        return "PlayPattern{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
