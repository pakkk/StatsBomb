package es.iesjandula.statsbomb.models.open_event;

/**
 * @author Neil Hdez
 * @version 1.0.0
 * @since 29/11/2022
 * In this Class Storage the Player
 */
public class Player
{

    private int id; // id
    private String name; // name of the Player

    public Player()
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
        return "Player{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
