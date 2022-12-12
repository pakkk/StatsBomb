package es.iesjandula.statsbomb.models.open_event;

public class Dribble
{

    private Boolean overrun;
    private Boolean nutmeg;
    private OutCome outcome;
    private Boolean not_touch;

    public Dribble()
    {

    }

    public Boolean getOverrun()
    {
        return this.overrun;
    }

    public void setOverrun(Boolean overrun)
    {
        this.overrun = overrun;
    }

    public Boolean getNutmeg()
    {
        return this.nutmeg;
    }

    public void setNutmeg(Boolean nutmeg)
    {
        this.nutmeg = nutmeg;
    }

    public OutCome getOutcome()
    {
        return this.outcome;
    }

    public void setOutcome(OutCome outcome)
    {
        this.outcome = outcome;
    }

    public Boolean getNot_touch()
    {
        return this.not_touch;
    }

    public void setNot_touch(Boolean not_touch)
    {
        this.not_touch = not_touch;
    }

    @Override
    public String toString()
    {
        return "Dribble{" + "overrun=" + overrun + ", nutmeg=" + nutmeg + ", outcome=" + outcome + ", not_touch=" + not_touch + '}';
    }
}
