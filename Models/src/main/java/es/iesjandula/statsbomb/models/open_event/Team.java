package es.iesjandula.statsbomb.models.open_event;

/**
 * @author Neil Hdez
 * @version 1.0.0
 * @since 29/11/2022
 * This class storage the Team
 */
public class Team
{

    private int id; // id
    private String name; // name of the Team

    public Team()
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
        return "Team{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
