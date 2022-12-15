package es.iesjandula.statsbomb.competitions_stats.order;

import com.fasterxml.jackson.core.JsonProcessingException;

import es.iesjandula.statsbomb.common.exception.StatsBombException;
import es.iesjandula.statsbomb.common.load_json.Json;
import es.iesjandula.statsbomb.models.competition.Competition;

import java.util.Comparator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Neil Hdez
 * @version 1.0.0
 * @since 13/12/2022
 */
public class OrderFilter
{
	private final Logger LOGGER = LogManager.getLogger();

    /**
     * This method sorts the competitions in ascending alphabetical order by name.
     *
     * @return String in format Json Pretty with competitions order by name
     * @throws StatsBombException 
     */
    public String getCompetitionsAlphabeticalOrder(List<Competition> competitionList) throws StatsBombException
    {
        // Result
        String jsonCompetitionsAlphabeticalOrder = "";

        // Order the list
        competitionList.sort(Comparator.comparing(Competition::getCompetition_name));

        try
        {
            // Write Result in Pretty Format
            jsonCompetitionsAlphabeticalOrder = Json.mapper().writerWithDefaultPrettyPrinter().writeValueAsString(competitionList);
        } catch (JsonProcessingException jsonProcessingException)
        {
        	String error = "Error to processing the JSON";
        	LOGGER.error(error, jsonProcessingException);
            throw new StatsBombException(error, jsonProcessingException);
        }

        return jsonCompetitionsAlphabeticalOrder;
    }

}
