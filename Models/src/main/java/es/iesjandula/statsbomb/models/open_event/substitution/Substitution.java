package es.iesjandula.statsbomb.models.open_event.substitution;

import es.iesjandula.statsbomb.models.open_event.OutCome;

/**
 * @author Neil Hdez
 * @version 1.0.0
 * @since 01/12/2022
 */
public class Substitution
{

    private OutCome outCome;
    private Replacement replacement;
    private OutCome outcome;

    Substitution()
    {

    }

    public OutCome getOutcome()
    {
        return outcome;
    }

    public void setOutcome(OutCome outcome)
    {
        this.outcome = outcome;
    }

    public OutCome getOutCome()
    {
        return outCome;
    }

    public void setOutCome(OutCome outCome)
    {
        this.outCome = outCome;
    }

    public Replacement getReplacement()
    {
        return replacement;
    }

    public void setReplacement(Replacement replacement)
    {
        this.replacement = replacement;
    }
}
