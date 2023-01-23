package es.iesjandula.statsbomb.models.event.pass;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author Neil Hdez
 * @author Jesus Guerrero
 *
 * specifying the player id of the recipient of
 * the pass, or for whom an incomplete pass was intended.
 */
@Entity
@Table(name = "recipient")
public class Recipient
{
    /**
     * Attribute -
     * id of the recipient
     */
    @Id
    @Column(length = 10)
    private int id;
    /**
     * Attribute -
     * name of the recipient of the pass
     */
    @Column(length = 25)
    private String name; // name of the Position

    /**
     * Default constructor
     */
    public Recipient ()
    {

    }

    /**
     * @return th id of the recipient
     */
    public int getId()
    {
        return this.id;
    }

    /**
     * @param id of the recipient
     */
    public void setId(int id)
    {
        this.id = id;
    }

    /**
     * @return the name of the recipient
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * @param name of the recipient
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return instance of recipient
     */
    @Override
    public String toString()
    {
        return "Recipient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
