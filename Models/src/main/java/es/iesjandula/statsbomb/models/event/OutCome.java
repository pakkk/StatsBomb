package es.iesjandula.statsbomb.models.event;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author Neil Hdez
 * @author Nacho Belda
 * This class will almacenates the Outcome
 */
@Entity
@Table(name = "outcome")
public class OutCome
{
    /**
     * Attributes -
     * Id / Name for the attribute
     * option specifying the outcome
     * of the shot.
     */
    @Id
    @Column(length = 10)
    private int id; // id
    @Column(length = 25)
    private String name; // name of the Outcome

    /**
     * Empty constructor
     */
    public OutCome()
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
     * @return an instance about the class Outcome as String
     */
    @Override
    public String toString()
    {
        return "OutCome{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
