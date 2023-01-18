package es.iesjandula.statsbomb.matches_stats.manager_filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.iesjandula.statsbomb.common.exception.StatsBombException;
import es.iesjandula.statsbomb.common.load_json.Json;
import es.iesjandula.statsbomb.common.load_json.JsonLoaderImpl;
import es.iesjandula.statsbomb.common.utils.Constants;
import es.iesjandula.statsbomb.common.utils.JsonUtils;
import es.iesjandula.statsbomb.models.matches.Match;

/**
 * @author Jesus Garcia Puerto
 */
public class ManagerScoreFilter
{
	// Attribute - List of Result
	private List<Result> resultsList;
	
	private Logger LOGGER = LogManager.getLogger();
	
	public ManagerScoreFilter()
	{
		this.resultsList = new ArrayList<Result>();
	}
	
	public List<Match> getListMatches(int competitionId, int seasonId) throws StatsBombException
	{
		JsonLoaderImpl jsonLoader = new JsonLoaderImpl();
		String jsonMatches = jsonLoader.loadMatches(competitionId, seasonId);
		ObjectMapper mapper = Json.mapper();
		List<Match> matchesList = new ArrayList<>();

		try
		{
			matchesList = mapper.readValue(jsonMatches, new TypeReference<List<Match>>(){});
		}
		catch (IOException ioException)
		{
			LOGGER.error(Constants.E_PARSING_JSON_TO_OBJECT, ioException);
			throw new StatsBombException("E_PARSING_JSON_TO_OBJECT", Constants.E_PARSING_JSON_TO_OBJECT, ioException);
		}

		return matchesList;
	}

	/**
	 * Method - fill the list of results
	 * @throws StatsBombException 
	 */
	public String getManagerScoreFilter(int competitionId, int seasonId) throws StatsBombException
	{
		List<Match> matchesList= this.getListMatches(competitionId, seasonId);
		List<String> managerList = new ArrayList<String>();
		// tour the list of matches
		for (Match matches : matchesList)
		{
			if (matches.getHome_team() != null)
			{
				// check if the matches has managers
				if (matches.getHome_team().getManagers() != null && matches.getHome_team().getManagers().size() > 0)
				{
					// save the return of saveWin
					int won = saveWin(matches.getHome_team().getManagers().get(0).getName(), matchesList);
					// save the return of saveLost
					int lost = saveLost(matches.getHome_team().getManagers().get(0).getName(), matchesList);
					// save the return of saveTied
					int tied = saveTied(matches.getHome_team().getManagers().get(0).getName(), matchesList);
	
					// instance of ResultMatch with won, lost, tied
					ResultMatches resultMatch = new ResultMatches(won, lost, tied);
	
					// instance of Result with name Manager and resultMatch
					Result result = new Result(matches.getHome_team().getManagers().get(0).getName(), resultMatch);
	
					if (!managerList.contains(matches.getHome_team().getManagers().get(0).getName()))
					{
						this.resultsList.add(result);
						managerList.add(matches.getHome_team().getManagers().get(0).getName());
					}
				}
			}
		}
		
		// Convert List to Json Format
        JsonUtils jsonUtils = new JsonUtils();
        
        String scoreString = jsonUtils.writeObjectToJsonAsStringPretty(this.resultsList);
        
        return scoreString;
	}

	/**
	 * @param managers, name of manager
	 * @return number of won
	 */
	private int saveWin(String managers, List<Match> matchesList)
	{
		int won = 0;

		for (Match matches : matchesList)
		{
			if (matches.getHome_team().getManagers() != null && matches.getHome_team().getManagers().size() > 0)
			{
				if (matches.getHome_team().getManagers().get(0).getName().equals(managers))
				{
					if (matches.getHome_score() > matches.getAway_score())
					{
						won++;
					}
				}
			}

			if (matches.getAway_team().getManagers() != null && matches.getHome_team().getManagers().size() > 0)
			{
				if (matches.getAway_team().getManagers().get(0).getName().equals(managers))
				{
					if (matches.getHome_score() < matches.getAway_score())
					{
						won++;
					}
				}
			}
		}

		return won;
	}

	/**
	 * @param managers, name of manager
	 * @return number of lost
	 */
	private int saveLost(String managers, List<Match> matchesList)
	{
		int lost = 0;

		for (Match matches : matchesList)
		{
			if (matches.getHome_team().getManagers() != null && matches.getHome_team().getManagers().size() > 0)
			{
				if (matches.getHome_team().getManagers().get(0).getName().equals(managers))
				{
					if (matches.getHome_score() < matches.getAway_score())
					{
						lost++;
					}
				}
			}

			if (matches.getAway_team().getManagers() != null && matches.getHome_team().getManagers().size() > 0)
			{
				if (matches.getAway_team().getManagers().get(0).getName().equals(managers))
				{
					if (matches.getHome_score() > matches.getAway_score())
					{
						lost++;
					}
				}
			}
		}

		return lost;
	}

	/**
	 * @param managers, name of manager
	 * @return number of tied
	 */
	private int saveTied(String managers, List<Match> matchesList)
	{
		int tied = 0;

		for (Match matches : matchesList)
		{
			if (matches.getHome_team().getManagers() != null && matches.getHome_team().getManagers().size() > 0)
			{
				if (matches.getHome_team().getManagers().get(0).getName().equals(managers))
				{
					if (matches.getHome_score() == matches.getAway_score())
					{
						tied++;
					}
				}
			}

			if (matches.getAway_team().getManagers() != null && matches.getHome_team().getManagers().size() > 0)
			{
				if (matches.getAway_team().getManagers().get(0).getName().equals(managers))
				{
					if (matches.getHome_score() == matches.getAway_score())
					{
						tied++;
					}
				}
			}
		}

		return tied;
	}
}
