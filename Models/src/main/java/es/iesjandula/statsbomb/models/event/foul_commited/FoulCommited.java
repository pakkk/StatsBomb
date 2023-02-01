package es.iesjandula.statsbomb.models.event.foul_commited;

import es.iesjandula.statsbomb.models.event.Card;
import es.iesjandula.statsbomb.models.event.Event;
import es.iesjandula.statsbomb.models.event.Type;
import jakarta.persistence.*;

/**
 * @author Neil Hdez
 * @author Jesus Guerrero
 * @author Manuel Canio Gil
 *
 * Any infringement that is penalised as foul play by a referee.
 * Offside are not tagged as a foul committed
 */
@Entity
@Table(name = "foul_commited")
public class FoulCommited
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Attribute -
     * Added when the referee calls
     * advantage and allows play to
     * continue
     */
    @Column(name = "advantage")
    private Boolean advantage;
    /**
     * Recorded only when a card is
     * awarded. Class Card
     */
    @OneToOne
    @JoinColumn(name = "id",referencedColumnName = "id")
    private Card card;

    /* Attribute - If the Foul is offensive */
    @Column(name = "offensive")
    private Boolean offensive;

    /* Attribute - Type of FoulCommited */
    @OneToOne
    @JoinColumn(name = "id",referencedColumnName = "id")
    private Type type;

    /* Attribute - If the Foul is Penalty */
    @Column(name = "penalty")
    private Boolean penalty;

    @OneToOne(mappedBy = "foul_commited")
    private Event event;


    /**
     * Default Constructor
     */
    public FoulCommited()
    {

    }

    /**
     * @return if Foul is Offensive
     */
    public Boolean getOffensive()
    {
        return offensive;
    }

    /**
     * @param offensive Information about of FoulCommited if is Offensive
     */
    public void setOffensive(Boolean offensive)
    {
        this.offensive = offensive;
    }

    /**
     * @return an instance of Card
     */
    public Card getCard()
    {
        return card;
    }

    /**
     * @param card instance
     */
    public void setCard(Card card)
    {
        this.card = card;
    }

    /**
     * @return referee calls advantage
     * and allows play to continue
     */
    public Boolean getAdvantage()
    {
        return advantage;
    }

    /**
     * @param advantage that allows play to continue
     */
    public void setAdvantage(Boolean advantage)
    {
        this.advantage = advantage;
    }

    /**
     * @return the type of FoulCommited
     */
    public Type getType()
    {
        return this.type;
    }

    /**
     * @param type of FoulCommited
     */
    public void setType(Type type)
    {
        this.type = type;
    }

    /* @return if the Foul is Penalty */
    public Boolean isPenalty()
    {
        return this.penalty;
    }

    /* @param penalty if the Foul is Penalty */
    public void setPenalty(Boolean penalty)
    {
        this.penalty = penalty;
    }
}
