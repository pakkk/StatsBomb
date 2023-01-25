package es.iesjandula.statsbomb.matches_rest.stats.manager_filters;

/**
 * @author Jesus Garcia Puerto
 */
public class Result
{
	// name of the manager
	private String name;
	// instance of ResultMatches
	private ResultMatches matches;

	/**
	 * Constructor
	 * 
	 * @param name, name of the manager
	 * @param matches, instance of ResultMatches
	 */
	public Result(String name, ResultMatches matches)
	{
		this.name = name;
		this.matches = matches;
	}

	/**
	 * @return name of the manager
	 */
	public String getName()
	{
		return this.name;
	}

	/**
	 * @param name, name of the manager
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * @return instance of ResultMatches
	 */
	public ResultMatches getMatches()
	{
		return this.matches;
	}

	/**
	 * @param matches, instance of ResultMatches
	 */
	public void setMatches(ResultMatches matches)
	{
		this.matches = matches;
	}
}
