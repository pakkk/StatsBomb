package es.iesjandula.statsbomb.models.open_event.foul_commited;

import es.iesjandula.statsbomb.models.open_event.Card;

/**
 * @author Neil Hdez
 * @version 1.0.0
 * @since 01/12/2022
 */
public class FoulCommited
{
    private Boolean advantage;
    private Card card;

    FoulCommited()
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

    public Boolean getAdvantage()
    {
        return advantage;
    }

    public void setAdvantage(Boolean advantage)
    {
        this.advantage = advantage;
    }
}
