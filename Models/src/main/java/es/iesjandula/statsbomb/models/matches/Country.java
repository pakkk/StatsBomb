package es.iesjandula.statsbomb.models.matches;
/**
 * @author Oscar Herruzo
 * A country object with unique
 * country ID and country name.
 */
public class Country
{
	/**
     * Attribute -
     * The unique identifier of the country.
     */
    private int id;
	
    /**
     * Attribute -
     * The name of the country 
     */
    private String name;
    
    /**
     * Empty constructor
     */
    public Country()
    {
    }
    
    /**
     * @param id, unique identifier for the country.
     */
    public void setId(int id)
    {
        this.id = id;
    }
    
    /**
     * @param name, name for the country.
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * @return the unique identifier for the country.
     */
    public int getId() 
    {
		return id;
	}
    /**
     * @return the name of the country.
     */
	public String getName() 
	{
		return name;
	}
	
    /**
     * @return a instance of country as string
     */
	@Override
    public String toString()
    {
        return "Country{" +
                "id=" + id +
                ", name='" + name +
                '}';
    }
}
