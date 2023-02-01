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
    @OneToOne
    @JoinColumn(name = "id",referencedColumnName = "id")
    private OutCome outcome;
    @OneToOne
    private Event event;

    public OutCome getOutcome()
    {
        return this.outcome;
    }

    public void setOutcome(OutCome outcome)
    {
        this.outcome = outcome;
    }
}
