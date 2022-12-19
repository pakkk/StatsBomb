package es.iesjandula.statsbomb.models.matches;

public class Stadium
{
    /**
     * Attributes -
     * The ID is the unique identifier for the stadium and the name is the name of the stadium
     */
    private int id;
    private String name;

    /**
     * Empty constrcutor
     */
    public Stadium()
    {
    }

    /**
     * @return id with the information about the id
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
     * @return an instance of the class Stadium as String
     */
    @Override
    public String toString()
    {
        return "Stadium{" +
                "id=" + id +
                ", name='" + name +
                '}';
    }
}
