package es.iesjandula.statsbomb.models.open_event;

/**
 * @author Neil Hdez
 * @author Nacho Belda
 * In this Class Storage the Player
 */
public class Player
{
    /**
     * Attributes -
     * id -> Will be the identifier of the Player
     * name -> Will be the name of the Player
     */
    private int id; // id
    private String name; // name of the Player

    /**
     * Empty Constructor
     */
    public Player()
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
     * @return name with the information about the name
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
     * @return an instance of the class Player as String
     */
    @Override
    public String toString()
    {
        return "Player{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
