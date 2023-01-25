package es.iesjandula.statsbomb.models.event;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author Neil Hdez
 * @author Nacho Belda
 * @author Alejandro Aljarilla
 * In this Class Storage the Position
 */
@Entity
@Table(name = "position")
public class Position
{
    /**
     * Attributes -
     * Id / Name of the position the
     * player was in at the time of
     * this event..
     */
    @Id
    @Column(length = 10)
    private int id; // id
    @Column(length = 25)
    private String name; // name of the Position

    /**
     * Empty constructor
     */
    public Position()
    {

    }

    /**
     * @return the information about the id
     */
    public int getId()
    {
        return this.id;
    }

    /**
     * @param id with the information abbout the id
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
        return this.name;
    }

    /**
     * @param name with the information about the name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return an instance of the class Position as String
     */
    @Override
    public String toString()
    {
        return "Position{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
