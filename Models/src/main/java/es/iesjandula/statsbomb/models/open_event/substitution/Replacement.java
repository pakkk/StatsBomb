package es.iesjandula.statsbomb.models.open_event.substitution;

/**
 * @author Neil Hdez
 * @author Oscar Herruzo
 * @version 1.0.0
 * @since 01/12/2022
 * 
 */
public class Replacement
{
    /**
     * Attribute -
     * Id from Replacement
     */
    private int id; 
    /**
     * Attribute -
     * Name of replacement
     */
    private String name;
    /**
     * Empty Constructor
     */
    Replacement()
    {

    }
    /**
     * @return the id about the replacement
     */
    public int getId()
    {
        return id;
    }
    /**
     * @return set the id about the replacement
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
     * @return set the name about the replacement
     */
    public void setName(String name)
    {
        this.name = name;
    }
}
