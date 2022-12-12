package es.iesjandula.statsbomb.models.open_event;

/**
 * @author Neil Hdez
 * @version 1.0.0
 * @since 01/12/2022
 */
public class Card
{
    private int id; // id
    private String name;

    Card()
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
}
