package es.iesjandula.statsbomb.models.open_event;

/**
 * @author Neil Hdez
 * @author Nacho Belda
 * This class almacenates the type of event
 */
public class Type
{
    /**
     * Attributes -
     * id -> Will be the identifier of the type.
     * name -> Will be the name of the type.
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
