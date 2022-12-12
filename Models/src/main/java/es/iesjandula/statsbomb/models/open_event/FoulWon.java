package es.iesjandula.statsbomb.models.open_event;

/**
 * @author Neil Hdez
 * @version 1.0.0
 * @since 01/12/2022
 */
public class FoulWon
{
    private Boolean defensive;
    private Boolean advantage;

    FoulWon()
    {

    }

    public Boolean getAdvantage()
    {
        return advantage;
    }

    public void setAdvantage(Boolean advantage)
    {
        this.advantage = advantage;
    }

    public Boolean getDefensive()
    {
        return defensive;
    }

    public void setDefensive(Boolean defensive)
    {
        this.defensive = defensive;
    }

    @Override
    public String toString()
    {
        return "FoulWon{" +
                "defensive=" + defensive +
                '}';
    }
}
