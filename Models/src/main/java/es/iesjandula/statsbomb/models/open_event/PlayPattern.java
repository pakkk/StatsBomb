package es.iesjandula.statsbomb.models.open_event;

/**
 * @author Neil Hdez
 * @version 1.0.0
 * @since 29/11/2022
 * This Class Storage the PlayPattern, Ej. Regular Play, From Corner, From Free Kick
 */
public class PlayPattern
{

    private int id; // id
    private String name; // name of the Play Pattern

    public PlayPattern()
    {

    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "PlayPattern{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
