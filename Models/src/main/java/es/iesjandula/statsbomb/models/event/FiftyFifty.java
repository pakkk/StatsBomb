package es.iesjandula.statsbomb.models.event;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "fifty_fifty")
public class FiftyFifty
{

    /* Attribute - The outcome of the 50/50 */
    @OneToOne(mappedBy = "fifty_fifty")
    private OutCome outcome;

    public OutCome getOutcome()
    {
        return this.outcome;
    }

    public void setOutcome(OutCome outcome)
    {
        this.outcome = outcome;
    }
}
