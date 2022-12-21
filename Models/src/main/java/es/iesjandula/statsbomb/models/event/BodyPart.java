package es.iesjandula.statsbomb.models.event;

/**
 * @author Neil Hdez
 * @author Jesus Guerrero
 *
 * Bodypart define with what body part
 * a player touch the ball
 */
public class BodyPart
{

    /**
     * Attribute -
     * id of the body part
     */
    private int id;
    /**
     * Attribute -
     * name of the body part used to an event
     */
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
