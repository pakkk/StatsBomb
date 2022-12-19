package es.iesjandula.statsbomb.models.open_event;


/**
 * @author Neil Hdez
 * @author Nacho Belda
 * In this Class Storage the Position
 */
public class Position
{
    /**
     * Attributes -
     * id -> Will be the identifier of the Position
     * name -> Will be the name of the Position.
     */
    private int id; // id
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
