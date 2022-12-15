package es.iesjandula.statsbomb.models.open_event;

/**
 * @author Neil Hdez
 * @author Jesus Guerrero
 *
 * The card thatt was obtained by a player
 * during the match
 */
public class Card
{
    /**
     * Attribute -
     * id of the Card
     */
    private int id; // id
    /**
     * Attribute -
     * name of the option specifying the card.
     * (yellow Card, second yellow, red Card)
     */
    private String name;

    /**
     * Default Constructor
     */
    Card()
    {

    }

    /**
     * @return the id of a Card
     */
    public int getId()
    {
        return id;
    }

    /**
     * @param id of a card
     */
    public void setId(int id)
    {
        this.id = id;
    }

    /**
     * @return the name of the option specifying card
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name of the option specifying card
     */
    public void setName(String name)
    {
        this.name = name;
    }

}
