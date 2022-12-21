package es.iesjandula.statsbomb.models.event;

/**
 * @author Neil Hdez
 * @author Nacho Belda
 */
public class FoulWon
{
    /**
     * Attributes -
     * Defensive: Added if the foul was won
     * when out of possession.
     * Advantage: Added if play continued
     * (referee called advantage)
     */
    private Boolean defensive;
    private Boolean advantage;

    /**
     * Empty Constructor
     */
    FoulWon()
    {

    }

    /**
     *
     * @return the information about the advantage
     */
    public Boolean getAdvantage()
    {
        return advantage;
    }

    /**
     * @param advantage with the information about the advantage
     */
    public void setAdvantage(Boolean advantage)
    {
        this.advantage = advantage;
    }

    /**
     * @return the information about the defensive
     */
    public Boolean getDefensive()
    {
        return defensive;
    }

    /**
     * @param defensive with the information the defensive
     */
    public void setDefensive(Boolean defensive)
    {
        this.defensive = defensive;
    }

    /**
     * @return an instance of the class FoulWon as String
     */
    @Override
    public String toString()
    {
        return "FoulWon{" +
                "defensive=" + defensive +
                '}';
    }
}
