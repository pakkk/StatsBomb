package es.iesjandula.statsbomb.matches_rest.stats.manager_filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import es.iesjandula.statsbomb.common.load_json.IJsonLoader;
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
import es.iesjandula.statsbomb.models.matches.Manager;
import es.iesjandula.statsbomb.models.matches.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Jesus Garcia Puerto
 */
@Service
public class ManagerNationalityFilter
{

	@Autowired
	private MatchesUtils matchesUtils;

	private Logger LOGGER = LogManager.getLogger();


	/**
     * Method - filter the managers whose nationality is to the country
     *
     * @return String in format JSON Pretty with the managers whose nationality is different to the country
     */
	public String managersWithDifferentNationalityThatCountry(int competitionId, int seasonId) throws StatsBombException, JsonProcessingException
	{

		List<Match> matchesList = this.matchesUtils.getMatchesByDataBase(competitionId, seasonId);
		List<String> nameManagersList = new ArrayList<String>();
		List<Manager> managersList = new ArrayList<Manager>();
		
		for (Match match : matchesList)
		{
			// filter the home managers
			if (match.getHome_team() != null)
			{
				if (match.getHome_team().getManagers() != null)
				{
					for (Manager manager : match.getHome_team().getManagers())
					{
						// check the nationality of manager and it of country
						if (!manager.getCountry().getName().equals(match.getHome_team().getCountry().getName()))
						{
							if (!nameManagersList.contains(manager.getName()))
							{
								managersList.add(manager);
								nameManagersList.add(manager.getName());
							}
						}
					}
				}
			}

			// filter the away managers
			if (match.getAway_team() != null)
			{
				if (match.getAway_team().getManagers() != null)
				{
					for (Manager manager : match.getAway_team().getManagers())
					{
						// check the nationality of manager and it of country
						if (!manager.getCountry().getName().equals(match.getAway_team().getCountry().getName()))
						{
							if (!nameManagersList.contains(manager.getName()))
							{
								managersList.add(manager);
								nameManagersList.add(manager.getName());
							}
						}
					}
				}
			}
		}
		
		// Convert List to JSON Format
        JsonUtils jsonUtils = new JsonUtils();

        String jsonManagerDifferentNacionality = jsonUtils.writeObjectToJsonAsStringPretty(managersList);

        return jsonManagerDifferentNacionality;
	}
}
