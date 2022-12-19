package es.iesjandula.statsbomb.models.matches;
/**
 * @author Oscar Herruzo
 * Added to reference the phase of the competition this particular match is in
 */
public class CompetitionStage
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
     * Empty constructor
     */
    public CompetitionStage()
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
     * @param  id, id of the competition.
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
     * @param  name, name of the competition.
     */
    public void setName(String name)
    {
        this.name = name;
    }
    /**
     * @return a instance of competition stage as string
     */
    @Override
    public String toString()
    {
        return "CompetitionStage{" +
                "id=" + id +
                ", name='" + name +
                '}';
    }
}
