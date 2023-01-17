package es.iesjandula.statsbomb.models.matches;

public class Stadium
{
    /**
     * Attributes -
     * The ID is the unique identifier for the stadium and the name is the name of the stadium
     */
    private int id;
    private String name;

    /** Attribute - The name of the country the stadium is in */
    private Country country;

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
     * @return name with the information about the stadium_country
     */
    public Country getCountry() {
        return country;
    }

    /**
     * @param country with the information about the stadium_country
     */
    public void setCountry(Country country) {
        this.country = country;
    }

    /**
     * @return an instance of the class Stadium as String
     */
    @Override
    public String toString() {
        return "Stadium{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stadium_country='" + country + '\'' +
                '}';
    }
}
