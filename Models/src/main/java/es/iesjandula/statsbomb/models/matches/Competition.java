package es.iesjandula.statsbomb.models.matches;

/**
 * @author Oscar Herruzo
 * The ID is the unique identifier for the competition and the 
 * name is the name of the competition
 */
public class Competition
{
   /**
     * Attribute -
     * The unique identifier for the competition.
     */
    private int id;
   /**
     * Attribute -
     * The name of the competition.
     */
    private String name;
    /**
     * Empty Constructor
     */
    public Competition()
    {

    }
    /**
     * @return The unique identifier for the competition.
     */
    public int getId()
    {
        return id;
    }
    /**
     * @param id, of the competition.
     */
    public void setId(int id)
    {
        this.id = id;
    }
    /**
     * @return The name of the competition.
     */
    public String getName()
    {
        return name;
    }
    /**
     * @param name, name of the competition.
     */
    public void setName(String name)
    {
        this.name = name;
    }
    /**
     * @return a instance of competition as string
     */
    @Override
    public String toString() 
    {
        return "Competition{" +
                "id=" + id +
                ", name='" + name +
                '}';
    }
}
