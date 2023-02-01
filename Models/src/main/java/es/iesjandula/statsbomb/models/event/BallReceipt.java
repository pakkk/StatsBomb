package es.iesjandula.statsbomb.models.event;

import jakarta.persistence.*;

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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Attribute -
     * Options specifying the outcome
     * of the ball receipt
     */
    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private OutCome outcome;
    @OneToOne(mappedBy = "ball_receipt")
    private Event event;


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
