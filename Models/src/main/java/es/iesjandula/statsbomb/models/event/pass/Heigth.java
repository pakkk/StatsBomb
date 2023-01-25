package es.iesjandula.statsbomb.models.event.pass;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author Neil Hdez
 * @author Jesus Guerrero
 * @author Alejandro Aljarilla
 *
 * In this Class Storage the Position
 */
@Entity
@Table(name = "heigth")
public class Heigth
{
    /**
     * Attribute -
     * identifier of height
     */
    @Id
    @Column(length = 10)
    private int id;
    /**
     * Attribute -
     * specifying the height of the pass.
     */
    @Column(length = 25)
    private String name;

    /**
     * Default constructor
     */
    public Heigth()
    {

    }

    /**
     * @return the id of height
     */
    public int getId()
    {
        return this.id;
    }

    /**
     * @param id of height
     */
    public void setId(int id)
    {
        this.id = id;
    }

    /**
     * @return the specifying of the height of the pass
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * @param name of the height of the pass
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return the instance of Heigth
     */
    @Override
    public String toString()
    {
        return "Heigth{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
