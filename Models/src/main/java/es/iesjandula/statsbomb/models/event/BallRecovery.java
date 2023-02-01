package es.iesjandula.statsbomb.models.event;

import jakarta.persistence.*;

/**
 * @author Neil Hdez
 * @author Jesus Guerrero
 * @author Manuel Canio Gil
 *
 * An attempt to recover a loose ball
 */
@Entity
@Table(name = "ball_recovery")
public class BallRecovery
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Attribute -
     * Ball is lost while attempting
     * to recover a loose ball
     */
    @Column(name = "recovery_failure")
    private Boolean recovery_failure;

    /* Attribute - if is offensive Ball Recovery */
    @Column(name = "offensive")
    private Boolean offensive;
    @OneToOne(mappedBy = "ball_recovery")
    private Event event;

    /**
     * Empty Constructor
     */
    public BallRecovery()
    {

    }

    /**
     * @return a boolean if the ball recovery was success
     */
    public Boolean getRecovery_failure()
    {
        return this.recovery_failure;
    }

    /**
     *
     * @param recovery_failure is a boolean if the ball recovery was success
     */
    public void setRecovery_failure(Boolean recovery_failure)
    {
        this.recovery_failure = recovery_failure;
    }

    public Boolean getOffensive()
    {
        return this.offensive;
    }

    public void setOffensive(Boolean offensive)
    {
        this.offensive = offensive;
    }

    /**
     * @return the instance of BallRecovery as String
     */
    @Override
    public String toString()
    {
        return "BallRecovery{" + "recovery_failure=" + recovery_failure + '}';
    }
}
