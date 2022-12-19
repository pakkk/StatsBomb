package es.iesjandula.statsbomb.models.lineups;


/**
 *
 * @author Manuel Martin Murillo
 *
 */
public class Country
{
    /**
     * Attribute
     * The id of the country
     */
    private Integer id;
    /**
     * Attribute
     * The name of the country
     */
    private String name;
    /**
     * Default constructor
     */
    public Country()
    {
        super();
        this.id = id;
        this.name = name;
    }
    /**
     *
     * @return the id of the country
     */
    public Integer getId()
    {
        return id;
    }
    /**
     *
     * @param id, with the id of the country
     */
    public void setId(Integer id)
    {
        this.id = id;
    }
    /**
     *
     * @return the name of the country
     */
    public String getName()
    {
        return name;
    }
    /**
     *
     * @param name, with the name of the country
     */
    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "Country [id=" + id + ", name=" + name + "]";
    }
}
