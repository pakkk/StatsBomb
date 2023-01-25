package es.iesjandula.statsbomb.models.event;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author Neil Hdez
 * @author Nacho Belda
 * @author Alejandro Aljarilla
 * This class almacenates the technique
 */
@Entity
@Table(name = "technique")
public class Technique
{
    /**
     * Attributes -
     * Id/ Name for the attribute
     * option specifying the
     * goalkeeper technique used.
     */
    @Id
    @Column(length = 10)
    private int id; // id
    @Column(length = 25)
    private String name; // name of the Technique

    /**
     * Empty constructor
     */
    public Technique()
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
     * @return a instamce of Technique as String
     */
    @Override
    public String toString()
    {
        return "Technique{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
