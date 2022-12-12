package es.iesjandula.statsbomb.models.open_event;

/**
 * @author Neil Hdez
 * @version 1.0.0
 * @since 30/11/2022
 */
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
