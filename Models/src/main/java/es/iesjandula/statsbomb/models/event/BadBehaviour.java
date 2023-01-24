package es.iesjandula.statsbomb.models.event;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

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

    private Card card;

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
