package es.iesjandula.statsbomb.models.event;

/**
 * @author Neil Hdez
 * @author Nacho Belda
 * This class almacenates the type of event
 */
public class Type
{
    /**
     * Attributes -
     * Id / Name for the attribute
     * option specifying the type of
     * goalkeeper event. (Every shot
     * will have a related goalkeeper
     * event. If a goal is not
     * conceded or a save is not
     * made, the goalkeeper type will
     * be “Shot Faced”).
     */
    private int id; // id
    private String name; // name of the event type

    /**
     * Empty constructor
     */
    public Type()
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
     * @return a instance of the type as String
     */
    @Override
    public String toString()
    {
        return "Type{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
