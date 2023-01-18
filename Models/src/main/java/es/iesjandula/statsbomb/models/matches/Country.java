package es.iesjandula.statsbomb.models.matches;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author Oscar Herruzo
 * @author Manuel Canio Gil
 * A country object with unique
 * country ID and country name.
 */
@Entity
@Table(name = "country")
public class Country
{
	/**
     * Attribute -
     * The unique identifier of the country.
     */
    @Id
    @Column(length = 10)
    private int id;
	
    /**
     * Attribute -
     * The name of the country 
     */
    @Column(name = "name", nullable = false, length = 20)
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
