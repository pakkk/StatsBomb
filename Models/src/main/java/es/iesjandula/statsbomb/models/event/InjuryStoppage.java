package es.iesjandula.statsbomb.models.event;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * @author Neil Hdez
 * @author Nacho Belda
 * @author Manuel Canio Gil
 * @author Alejandro Aljarilla
 * This class almacenates the InjuriesStoppage
 */
@Entity
@Table(name = "injury_stoppage")
public class InjuryStoppage
{
    /**
     * Attributes -
     * Added if the ball was in the
     * injured player’s team’s
     * possession before the
     * stoppage began.
     */
    @Column(name = "in_chain")
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
