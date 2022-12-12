package es.iesjandula.statsbomb.models.open_event;

/**
 * @author Neil Hdez
 * @version 1.0.0
 * @since 30/11/2022
 */
public class Duel
{
    private Boolean counterpress;
    private Type type;
    private OutCome outcome;

    public Duel ()
    {

    }

    public Boolean getCounterpress()
    {
        return this.counterpress;
    }

    public void setCounterpress(Boolean counterpress)
    {
        this.counterpress = counterpress;
    }

    public Type getType()
    {
        return this.type;
    }

    public void setType(Type type)
    {
        this.type = type;
    }

    public OutCome getOutcome()
    {
        return this.outcome;
    }

    public void setOutcome(OutCome outcome)
    {
        this.outcome = outcome;
    }

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
