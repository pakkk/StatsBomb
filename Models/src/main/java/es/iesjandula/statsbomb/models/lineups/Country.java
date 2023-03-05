package es.iesjandula.statsbomb.models.lineups;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 *
 * @author Manuel Martin Murillo
 * @author Alejandro Aljarilla
 *
 */
@Entity
@Table(name = "country")
public class Country
{
	/**
	 * Attribute The id of the country
	 */

	@Id
	@Column(length = 10)
	private Integer id;

//	@OneToMany
//	@JoinColumn(name = "player_id")
//	private List<Lineup> lineups;
	/**
	 * Attribute The name of the country
	 */
	@Column(length = 20)
	private String name;

	/**
	 * Default constructor
	 */
	public Country()
	{

	}

	/**
	 *
	 * @return the id of the country
	 */
	public Integer getId()
	{
		return id;
	}

	/**
	 *
	 * @param id, with the id of the country
	 */
	public void setId(Integer id)
	{
		this.id = id;
	}

	/**
	 *
	 * @return the name of the country
	 */
	public String getName()
	{
		return name;
	}

	/**
	 *
	 * @param name, with the name of the country
	 */
	public void setName(String name)
	{
		this.name = name;
	}

//	public List<Lineup> getLineups()
//	{
//		return lineups;
//	}
//
//	public void setLineups(List<Lineup> lineups)
//	{
//		this.lineups = lineups;
//	}
//
//	@Override
//	public String toString()
//	{
//		return "Country [id=" + id + ", lineups=" + lineups + ", name=" + name + "]";
//	}
}
