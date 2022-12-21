package es.iesjandula.statsbomb.models.event.foul_commited;

import es.iesjandula.statsbomb.models.event.Card;

/**
 * @author Neil Hdez
 * @author Jesus Guerrero
 *
 * Any infringement that is penalised as foul play by a referee.
 * Offside are not tagged as a foul committed
 */
public class FoulCommited
{
    /**
     * Attribute -
     * Added when the referee calls
     * advantage and allows play to
     * continue
     */
    private Boolean advantage;
    /**
     * Recorded only when a card is
     * awarded. Class Card
     */
    private Card card;

    /**
     * Default Constructor
     */
    FoulCommited()
    {

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
}
