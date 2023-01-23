package es.iesjandula.statsbomb.models.event;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author Neil Hdez
 * @author Nacho Belda
 * This class storage the Team
 */
@Entity
@Table(name = "team")
public class Team
{
    /**
     * Attributes -
     * Id / Name of the team this event relates to.
     * Team object will only display if the event
     * is tied to a specific team
     */
    @Id
    @Column(length = 10)
    private int id; // id
    @Column(length = 25)
    private String name; // name of the Team

    /**
     * Empty constructor
     */
    public Team()
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
     * @return with the information about the name
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
     * @return a instance of the class Team as String
     */
    @Override
    public String toString()
    {
        return "Team{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
