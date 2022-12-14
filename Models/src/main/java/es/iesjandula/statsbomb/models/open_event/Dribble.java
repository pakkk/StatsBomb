package es.iesjandula.statsbomb.models.open_event;

/**
 * @author Neil Hdez
 * @author Nacho Belda
 *
 */
public class Dribble
{
    /**
     * Attributes -
     * Overrun -> Added when a dribble goes
     * past the original defender into
     * the possession of another
     * player.
     * Nutmeg -> Added when the dribble went
     * through an opposing players
     * legs.
     * Outcome -> Id / Name for the attribute
     * option specifying the outcome
     * of the dribble.
     * No Touch -> If the player attempted to do
     * the dribble by passing the ball
     * past the opponent instead of
     * receiving it.
     *
     */
    private Boolean overrun;
    private Boolean nutmeg;
    private OutCome outcome;
    private Boolean not_touch;

    /**
     * Empty constructor
     */
    public Dribble()
    {

    }

    /**
     * @return the information about the overrun
     */
    public Boolean getOverrun()
    {
        return this.overrun;
    }

    /**
     * @param overrun with the information about the overrun
     */
    public void setOverrun(Boolean overrun)
    {
        this.overrun = overrun;
    }

    /**
     * @return the information about the nutmeg
     */
    public Boolean getNutmeg()
    {
        return this.nutmeg;
    }

    /**
     * @param nutmeg the information about the nutmeg
     */
    public void setNutmeg(Boolean nutmeg)
    {
        this.nutmeg = nutmeg;
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
     * @return the information about the not_touch
     */
    public Boolean getNot_touch()
    {
        return this.not_touch;
    }

    /**
     * @param not_touch with the information about the not_touch
     */
    public void setNot_touch(Boolean not_touch)
    {
        this.not_touch = not_touch;
    }

    /**
     * @return an instance of the class Dribble as String
     */
    @Override
    public String toString()
    {
        return "Dribble{" + "overrun=" + overrun + ", nutmeg=" + nutmeg + ", outcome=" + outcome + ", not_touch=" + not_touch + '}';
    }
}
