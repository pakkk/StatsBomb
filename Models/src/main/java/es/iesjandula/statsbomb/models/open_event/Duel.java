package es.iesjandula.statsbomb.models.open_event;

/**
 * @author Neil Hdez
 * @author Nacho Belda
 */
public class Duel
{
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
    private Boolean counterpress;
    private Type type;
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
