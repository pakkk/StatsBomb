package es.iesjandula.statsbomb.matches_stats.manager_filters;

/**
 * @author Jesus Garcia Puerto
 */
public class ResultMatches
{
	// save the number of the match won
	private int won;
	// save the number of the match lost
	private int lost;
	// save the number of the match tied
	private int tied;

	/**
	 * Constructor
	 * 
	 * @param won,  number of the match won
	 * @param lost, number of the match lost
	 * @param tied, number of the match tied
	 */
	public ResultMatches(int won, int lost, int tied)
	{
		this.won = won;
		this.lost = lost;
		this.tied = tied;
	}

	/**
	 * @return the number of match won
	 */
	public int getWon()
	{
		return this.won;
	}

	/**
	 * @param won, number of the match won
	 */
	public void setWon(int won)
	{
		this.won = won;
	}

	/**
	 * @return the number of match lost
	 */
	public int getLost()
	{
		return this.lost;
	}

	/**
	 * @param lost, number of the match lost
	 */
	public void setLost(int lost)
	{
		this.lost = lost;
	}

	/**
	 * @return the number of match tied
	 */
	public int getTied()
	{
		return this.tied;
	}

	/**
	 * @param tied, number of the match tied
	 */
	public void setTied(int tied)
	{
		this.tied = tied;
	}
}
