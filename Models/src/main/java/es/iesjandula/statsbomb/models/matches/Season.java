package es.iesjandula.statsbomb.models.matches;

/**
 * @author Nacho Belda
 */
public class Season
{
    /**
     * Attributes -
     * The ID is the unique identifier for the stadium and the name is the name of the stadium
     */
    private int id;
    private String name;

    /**
     * Empty constructor
     */
    public Season()
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
     * @return the name with the information about the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name with the informatio about the name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return an instance of the class Season as String
     */
    @Override
    public String toString() {
        return "Season{" +
                "id=" + id +
                ", name='" + name +
                '}';
    }
}
