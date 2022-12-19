package es.iesjandula.statsbomb.models.matches;

/**
 * @author Nacho Belda
 */
public class Team
{
    /**
     * Attributes -
     * id/Name of the team this
     * event relates to. Team object
     * will only display if the event
     * is tied to a specific team
     */
    private int id;
    private String name;

    /**
     * Empty Constructor
     */
    public Team()
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
     * @return an instance of the class Team as String
     */
    @Override
    public String toString()
    {
        return "AwayTeam{" +
                "id=" + id +
                ", name='" + name +
                '}';
    }
}
