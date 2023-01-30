package es.iesjandula.statsbomb.models.event;

import jakarta.persistence.*;

@Entity
@Table(name = "fifty_fifty")
public class FiftyFifty
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
