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
    private int season_id;
    private String season_name;

    /**
     * Empty constructor
     */
    public Season()
    {
    }

    /**
     * @return the information about the id
     */
    public int getSeason_id()
    {
        return season_id;
    }

    /**
     * @param season_id with the information about the id
     */
    public void setSeason_id(int season_id)
    {
        this.season_id = season_id;
    }

    /**
     * @return the name with the information about the name
     */
    public String getSeason_name()
    {
        return season_name;
    }

    /**
     * @param season_name with the informatio about the name
     */
    public void setSeason_name(String season_name)
    {
        this.season_name = season_name;
    }

    /**
     * @return an instance of the class Season as String
     */
    @Override
    public String toString() {
        return "Season{" +
                "id=" + season_id +
                ", name='" + season_name +
                '}';
    }
}
