package es.iesjandula.statsbomb.models.open_event;

/**
 * @author Neil Hdez
 * @author Nacho Belda
 * This class almacenates the InjuriesStoppage
 */
public class InjuryStoppage
{
    /**
     * Attributes -
     * in_chain -> Will indicate if is in_chain
     */
    private Boolean in_chain;

    /**
     * Empty constructor
     */
    public InjuryStoppage()
    {

    }

    /**
     * @return with the information about in_chain
     */
    public Boolean getIn_chain()
    {
        return this.in_chain;
    }

    /**
     * @param in_chain with the information about in_chain
     */
    public void setIn_chain(Boolean in_chain)
    {
        this.in_chain = in_chain;
    }

    /**
     * @return an instance of the class InjuryStoppage as String
     */
    @Override
    public String toString()
    {
        return "InjuryStoppage{" +
                "in_chain=" + in_chain +
                '}';
    }
}
