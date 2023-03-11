package es.iesjandula.statsbomb.matches_rest.stats.manager_filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import es.iesjandula.statsbomb.common.load_json.IJsonLoader;
import es.iesjandula.statsbomb.matches_rest.stats.matches_result_filters.MatchesFilter;
import es.iesjandula.statsbomb.matches_rest.stats.utils.MatchesUtils;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Jesus Garcia Puerto
 */
@Service
public class ManagerScoreFilter
{

	@Autowired
	private MatchesUtils matchesUtils;

	// Attribute - List of Result
	private List<Result> resultsList;
	
	private Logger LOGGER = LogManager.getLogger();
	
	public ManagerScoreFilter()
	{
		this.resultsList = new ArrayList<Result>();
	}


	/**
	 * Method - fill the list of results
	 * @throws StatsBombException 
	 */
	public String getManagerScoreFilter(int competitionId, int seasonId) throws StatsBombException, JsonProcessingException
	{
		resultsList.clear();

		List<Match> matchesList;
		List<String> managerList = new ArrayList<String>();

		matchesList = this.matchesUtils.getMatchesByDataBase(competitionId, seasonId);

		// tour the list of matches
		for (Match matches : matchesList)
		{
			if (matches.getHome_team() != null)
			{
				// check if the matches has managers
				if (matches.getHome_team().getManagers() != null)
				{
					if (matches.getHome_team().getManagers().size() > 0)
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

			if (matches.getAway_team() != null)
			{
				// check if the matches has managers
				if (matches.getAway_team().getManagers() != null)
				{
					if (matches.getAway_team().getManagers().size() > 0)
					{
						// save the return of saveWin
						int won = saveWin(matches.getAway_team().getManagers().get(0).getName(), matchesList);
						// save the return of saveLost
						int lost = saveLost(matches.getAway_team().getManagers().get(0).getName(), matchesList);
						// save the return of saveTied
						int tied = saveTied(matches.getAway_team().getManagers().get(0).getName(), matchesList);

						// instance of ResultMatch with won, lost, tied
						ResultMatches resultMatch = new ResultMatches(won, lost, tied);

						// instance of Result with name Manager and resultMatch
						Result result = new Result(matches.getAway_team().getManagers().get(0).getName(), resultMatch);

						if (!managerList.contains(matches.getAway_team().getManagers().get(0).getName()))
						{
							this.resultsList.add(result);
							managerList.add(matches.getAway_team().getManagers().get(0).getName());
						}
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
			if (matches.getHome_team().getManagers() != null)
			{
				if (matches.getHome_team().getManagers().size() > 0)
				{
					if (matches.getHome_team().getManagers().get(0).getName().equals(managers))
					{
						if (matches.getHome_score() > matches.getAway_score())
						{
							won++;
						}
					}
				}
			}

			if (matches.getAway_team().getManagers() != null)
			{
				if (matches.getAway_team().getManagers().size() > 0)
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
			if (matches.getHome_team().getManagers() != null)
			{
				if (matches.getHome_team().getManagers().size() > 0)
				{
					if (matches.getHome_team().getManagers().get(0).getName().equals(managers))
					{
						if (matches.getHome_score() < matches.getAway_score())
						{
							lost++;
						}
					}
				}
			}

			if (matches.getAway_team().getManagers() != null)
			{
				if (matches.getAway_team().getManagers().size() > 0)
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
			if (matches.getHome_team().getManagers() != null)
			{
				if (matches.getHome_team().getManagers().size() > 0)
				{
					if (matches.getHome_team().getManagers().get(0).getName().equals(managers))
					{
						if (matches.getHome_score() == matches.getAway_score())
						{
							tied++;
						}
					}
				}
			}

			if (matches.getAway_team().getManagers() != null)
			{
				if (matches.getAway_team().getManagers().size() > 0)
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
		}

		return tied;
	}
}
