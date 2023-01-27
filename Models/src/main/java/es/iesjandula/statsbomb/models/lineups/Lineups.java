package es.iesjandula.statsbomb.models.lineups;

import es.iesjandula.statsbomb.models.event.Position;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.util.List;
@Entity
@Table(name = "lineups")
public class Lineups
{
    /**
     * Attribute
     * The unique identifier for this player
     */
    @Id
    @Column(length = 10)
    private Integer player_id;
    /**
     * Attribute
     * The name of the player
     */
    @Column(length = 25)
    private String player_name;
    /**
     * Attribute
     * The nickname of the player on the team
     */
    @Column(length = 25)
    private String player_nickname;
    /**
     * Attribute
     * The number on the player’s shirt for this match
     */
    @Column(length = 4)
    private Integer jersey_number;
    /**
     * Attribute
     * The player’s nationality, a country object with ID and name attributes.
     */
    @OneToOne(mappedBy = "lineups")
    private Country country;
    /**
     * Attribute
     * An array of cards that the player has received
     */
    @OneToMany
    private List <Cards> cards;
    /**
     * Attribute
     * An array of positions that the player had during the match
     */
    @OneToMany
    private List<Position> positions;
    /**
     * Default constructor
     */
    public Lineups()
    {
        super();
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

    public List <Cards>  getCards()
    {
        return cards;
    }

    /**
     *
     * @param cards, with the array of cards of the player
     */

    public void setCards(List <Cards>  cards)
    {
        this.cards = cards;
    }

    /**
     *
     * @return the array of positions
     */

    public List<Position> getPositions()
    {
        return positions;
    }

    /**
     *
     * @param positions, with the array of positions
     */

    public void setPositions(List<Position>  positions)
    {
        this.positions = positions;
    }

	@Override
	public String toString()
	{
		return "Lineups [player_id=" + player_id + ", player_name=" + player_name + ", player_nickname="
				+ player_nickname + ", jersey_number=" + jersey_number + ", country=" + country + ", cards=" + cards
				+ ", positions=" + positions + "]";
	}

	

   

}
