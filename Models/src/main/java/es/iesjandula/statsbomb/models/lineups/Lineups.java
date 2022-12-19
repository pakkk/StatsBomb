package es.iesjandula.statsbomb.models.lineups;

import es.iesjandula.statsbomb.models.open_event.Position;

import java.util.Arrays;

public class Lineups
{
    /**
     * Attribute
     * The unique identifier for this player
     */
    private Integer player_id;
    /**
     * Attribute
     * The name of the player
     */
    private String player_name;
    /**
     * Attribute
     * The nickname of the player on the team
     */
    private String player_nickname;
    /**
     * Attribute
     * The number on the player’s shirt for this match
     */
    private Integer jersey_number;
    /**
     * Attribute
     * The player’s nationality, a country object with ID and name attributes.
     */
    private Country country;
    /**
     * Attribute
     * An array of cards that the player has received
     */
    private Cards [] cards;
    /**
     * Attribute
     * An array of positions that the player had during the match
     */
    private Position[] positions;
    /**
     * Default constructor
     */
    public Lineups()
    {
        super();
        this.player_id = player_id;
        this.player_name = player_name;
        this.player_nickname = player_nickname;
        this.jersey_number = jersey_number;
        this.country = country;
        this.cards = cards;
        this.positions = positions;
    }

    /**
     *
     * @return The unique identifier for this player
     */

    public Integer getPlayer_id()
    {
        return player_id;
    }

    /**
     *
     * @param player_id, with the unique identifier for this player
     */

    public void setPlayer_id(Integer player_id)
    {
        this.player_id = player_id;
    }

    /**
     *
     * @return the name of the player
     */
    public String getPlayer_name()
    {
        return player_name;
    }

    /**
     *
     * @param player_name, with the name of the player
     */

    public void setPlayer_name(String player_name)
    {
        this.player_name = player_name;
    }

    /**
     *
     * @return the nick name of the player
     */

    public String getPlayer_nickname()
    {
        return player_nickname;
    }

    /**
     *
     * @param player_nickname, with the nick name of the player
     */

    public void setPlayer_nickname(String player_nickname)
    {
        this.player_nickname = player_nickname;
    }

    /**
     *
     * @return the number of the player jersey
     */

    public Integer getJersey_number()
    {
        return jersey_number;
    }

    /**
     *
     * @param jersey_number, with the number of the player jersey
     */

    public void setJersey_number(Integer jersey_number)
    {
        this.jersey_number = jersey_number;
    }

    /**
     *
     * @return the country of the player
     */

    public Country getCountry()
    {
        return country;
    }

    /**
     *
     * @param country, with the country of the player
     */

    public void setCountry(Country country)
    {
        this.country = country;
    }

    /**
     *
     * @return the array of cards of the player
     */

    public Cards[] getCards()
    {
        return cards;
    }

    /**
     *
     * @param cards, with the array of cards of the player
     */

    public void setCards(Cards[] cards)
    {
        this.cards = cards;
    }

    /**
     *
     * @return the array of positions
     */

    public Position[] getPositions()
    {
        return positions;
    }

    /**
     *
     * @param positions, with the array of positions
     */

    public void setPositions(Position[] positions)
    {
        this.positions = positions;
    }

    @Override
    public String toString()
    {
        return "Lineups [player_id=" + player_id + ", player_name=" + player_name + ", player_nickname="
                + player_nickname + ", jersey_number=" + jersey_number + ", country=" + country + ", cards="
                + Arrays.toString(cards) + ", positions=" + Arrays.toString(positions) + "]";
    }

}
