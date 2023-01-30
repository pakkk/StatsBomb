package es.iesjandula.statsbomb.models.event;

import jakarta.persistence.*;

/**
 * @author Neil Hdez
 * @author Nacho Belda
 * @author Manuel Canio Gil
 */
@Entity
@Table(name = "duel")
public class Duel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Attributes -
     * Counterpass -> Pressing actions within 5
     * seconds of an open play
     * turnover.
     * Type -> Id / Name for the attribute
     * value of the type of duel
     * Outcome -> Id / Name for the attribute
     * option specifying the outcome
     * of the duel.
     */
    @Column(name = "counterpress")
    private Boolean counterpress;
    @OneToOne(mappedBy = "duel")
    private Type type;
    @OneToOne(mappedBy = "duel")
    private OutCome outcome;

    /**
     * Empty constructor
     */
    public Duel ()
    {

    }

    /**
     * @return the information about the counterpress
     */
    public Boolean getCounterpress()
    {
        return this.counterpress;
    }

    /**
     * @param counterpress with the information about the counterpress
     */
    public void setCounterpress(Boolean counterpress)
    {
        this.counterpress = counterpress;
    }

    /**
     * @return the information about the type
     */
    public Type getType()
    {
        return this.type;
    }

    /**
     * @param type with the information about the type
     */
    public void setType(Type type)
    {
        this.type = type;
    }

    /**
     * @return the information about the Outcome
     */
    public OutCome getOutcome()
    {
        return this.outcome;
    }

    /**
     * @param outcome with the information about the outcome
     */
    public void setOutcome(OutCome outcome)
    {
        this.outcome = outcome;
    }

    /**
     * @return an instance of the class Duel as String
     */
    @Override
    public String toString()
    {
        return "Duel{" +
                "counterpress=" + counterpress +
                ", type=" + type +
                ", outcome=" + outcome +
                '}';
    }
}
