package es.iesjandula.statsbomb.models.open_event;

public class InjuryStoppage
{

    private Boolean in_chain;

    public InjuryStoppage()
    {

    }

    public Boolean getIn_chain()
    {
        return this.in_chain;
    }

    public void setIn_chain(Boolean in_chain)
    {
        this.in_chain = in_chain;
    }

    @Override
    public String toString()
    {
        return "InjuryStoppage{" +
                "in_chain=" + in_chain +
                '}';
    }
}
