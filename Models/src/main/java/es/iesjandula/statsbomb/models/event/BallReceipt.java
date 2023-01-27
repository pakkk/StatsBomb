package es.iesjandula.statsbomb.models.event;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * @author Neil Hdez
 * @author Jesus Guerrero
 * @author Manuel Canio Gil
 *
 * Events describe the location of a pass and who that recipient was
 */
@Entity
@Table(name = "ball_receipt")
public class BallReceipt
{
    /**
     * Attribute -
     * Options specifying the outcome
     * of the ball receipt
     */
    @OneToOne(mappedBy = "ball_receipt")
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
