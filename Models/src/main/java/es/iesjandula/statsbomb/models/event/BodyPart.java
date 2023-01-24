package es.iesjandula.statsbomb.models.event;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author Neil Hdez
 * @author Jesus Guerrero
 * @author Manuel Canio Gil
 *
 * Bodypart define with what body part
 * a player touch the ball
 */
@Entity
@Table(name = "body_part")
public class BodyPart
{

    /**
     * Attribute -
     * id of the body part
     */
    @Id
    @Column(length = 10)
    private int id;
    /**
     * Attribute -
     * name of the body part used to an event
     */
    @Column(name = "name", nullable = false)
    private String name; // name of the body part

    /**
     * Default Constructor
     */
    public BodyPart()
    {

    }

    /**
     * @return the id of the body part
     */
    public int getId()
    {
        return this.id;
    }

    /**
     * @return the name of the body part used on an event
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * @param name of the body part used on an event
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return the instance of bodyPart as String
     */
    @Override
    public String toString()
    {
        return "BodyPart{" + "id=" + id + ", name='" + name + '\'' + '}';
    }

}
