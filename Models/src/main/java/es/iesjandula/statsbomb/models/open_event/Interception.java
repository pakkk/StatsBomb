package es.iesjandula.statsbomb.models.open_event;

/**
 * @author Neil Hdez
 * @author Nacho Belda
 * This class almacenates information about the interception
 */
public class Interception
{
    /**
     * Attributes -
     * Id / Name for the attribute
     * option specifying the outcome
     * of the interception
     */
    private OutCome outcome;

    /**
     * Empty constructor
     */
    Interception()
    {

    }

    /**
     * @return the information about the outcome
     */
    public OutCome getOutcome()
    {
        return outcome;
    }

    /**
     * @param outcome with the information about the outcome
     */
    public void setOutcome(OutCome outcome)
    {
        this.outcome = outcome;
    }

    /**
     * @return an instance of the class Interception as String
     */
    @Override
    public String toString()
    {
        return "Interception{" +
                "outcome=" + outcome +
                '}';
    }
}
