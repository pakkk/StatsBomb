package es.iesjandula.statsbomb.models.event;

import jakarta.persistence.*;

/**
 * @author Neil Hdez
 * @author Manuel Canio Gil
 * @version 1.0.0
 * @since 24/12/2022
 */
@Entity
@Table(name = "bad_behaviour")
public class BadBehaviour
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "id",referencedColumnName = "id")
    private Card card;
    @OneToOne(mappedBy = "bad_behaviour")
    private Event event;

    public BadBehaviour()
    {

    }

    public Card getCard()
    {
        return card;
    }

    public void setCard(Card card)
    {
        this.card = card;
    }
}
