package es.iesjandula.statsbomb.models.event;

/**
 * @author Neil Hdez
 * @author Jesus Guerrero
 *
 * Events describe the location of a pass and who that recipient was
 */
public class BallReceipt
{
    /**
     * Attribute -
     * Options specifying the outcome
     * of the ball receipt
     */
    private OutCome outcome;

    /**
     * Empty Constructor
     */
    public BallReceipt()
    {

    }

    /**
     * @return the information about reception of the ball
     */
    public OutCome getOutcome()
    {
        return outcome;
    }

    /**
     * @param outcome with the information about reception of the ball
     */
    public void setOutcome(OutCome outcome)
    {
        this.outcome = outcome;
    }

    /**
     * @return the instance of BallReceipt as String
     */
    @Override
    public String toString() {
        return "BallReceipt{" +
                "outcome=" + outcome +
                '}';
    }
}
