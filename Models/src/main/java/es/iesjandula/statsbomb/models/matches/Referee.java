package es.iesjandula.statsbomb.models.matches;

/**
 * @author Nacho Belda
 */
public class Referee
{
    /**
     * Attributes -
     * The ID is the unique identifier for the stadium and the name is the name of the stadium
     */
    private int competition_id;
    private String country_name;

    /** Attribute -
     * The ID is the unique identifier for the country and the name is
     * the name of the country
     */
    private Country competition_name;

    /**
     * Empty Constructor
     */
    public Referee()
    {
    }

    /**
     * @return the information about the id
     */
    public int getCompetition_id()
    {
        return competition_id;
    }

    /**
     * @param competition_id with the information about the id
     */
    public void setCompetition_id(int competition_id)
    {
        this.competition_id = competition_id;
    }

    /**
     * @return the information about the name
     */
    public String getCountry_name()
    {
        return country_name;
    }

    /**
     * @param country_name with the information about the name
     */
    public void setCountry_name(String country_name)
    {
        this.country_name = country_name;
    }

    /**
     * @return the information about the country
     */
    public Country getCompetition_name() {
        return competition_name;
    }

    /**
     * @param competition_name with the information about the country
     */
    public void setCompetition_name(Country competition_name) {
        this.competition_name = competition_name;
    }

    /**
     * @return an instance of the class Referee as String
     */
    @Override
    public String toString() {
        return "Referee{" +
                "id=" + competition_id +
                ", name='" + country_name + '\'' +
                ", country=" + competition_name +
                '}';
    }
}
