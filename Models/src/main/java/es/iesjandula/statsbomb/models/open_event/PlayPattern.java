package es.iesjandula.statsbomb.models.open_event;

/**
 * @author Neil Hdez
 * @author Nacho Belda
 * This Class Storage the PlayPattern, Ej. Regular Play, From Corner, From Free Kick
 */
public class PlayPattern
{
    /**
     * Attributes -
     * Id /name of the play pattern
     * relevant to this event.
     */
    private int id; // id
    private String name; // name of the Play Pattern

    /**
     * Empty constructor
     */
    public PlayPattern()
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
     * @return an instance of the class PlayPattern as String
     */
    @Override
    public String toString()
    {
        return "PlayPattern{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
