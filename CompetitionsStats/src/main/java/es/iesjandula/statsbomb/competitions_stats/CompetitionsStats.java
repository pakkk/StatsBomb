package es.iesjandula.statsbomb.competitions_stats;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.iesjandula.statsbomb.common.exception.StatsBombException;
import es.iesjandula.statsbomb.common.load_json.Json;
import es.iesjandula.statsbomb.common.load_json.JsonLoaderImpl;
import es.iesjandula.statsbomb.common.utils.Constants;
import es.iesjandula.statsbomb.competitions_stats.gender.GenderFilter;
import es.iesjandula.statsbomb.competitions_stats.order.OrderFilter;
import es.iesjandula.statsbomb.models.competition.Competition;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Neil Hdez
 *
 * In this class we create the filter and statistics for Json Competitions.
 */
public class CompetitionsStats
{
    /* Attribute - Logger */
    private final Logger LOGGER = LogManager.getLogger();

    /**
     * Return list with all competitions in json StatsBomb
     *
     * @return List of Competitions
     * @throws StatsBombException
     */
    private List<Competition> getListCompetitions() throws StatsBombException
    {

        JsonLoaderImpl jsonLoader = new JsonLoaderImpl();
        String jsonCompetitions = jsonLoader.loadCompetitions();
        ObjectMapper mapper = Json.mapper();
        List<Competition> competitionList = new ArrayList<>();

        try
        {
            competitionList = mapper.readValue(jsonCompetitions, new TypeReference<List<Competition>>(){});
        }
        catch (IOException ioException)
        {
            LOGGER.error(Constants.E_PARSING_JSON_TO_OBJECT, ioException);
            throw new StatsBombException(Constants.E_PARSING_JSON_TO_OBJECT, "Error a la hora de parsear el Json" ,ioException);
        }

        return competitionList;
    }


    /**
     * This method sorts the competitions in ascending alphabetical order by name.
     *
     * @return String in format Json Pretty with competitions order by name
     * @throws StatsBombException
     */
    public String getCompetitionsAlphabeticalOrder() throws StatsBombException
    {
        OrderFilter orderFilter = new OrderFilter();
        return orderFilter.getCompetitionsAlphabeticalOrder(getListCompetitions());
    }


    /**
     * This method show all competitions of female.
     *
     * @return String in format Json Pretty with competitions of female.
     * @throws StatsBombException
     */
    public String getCompetitionsFemale() throws StatsBombException
    {
        GenderFilter genderFilter = new GenderFilter();
        return genderFilter.getCompetitionsFemale(getListCompetitions());
    }

    /**
     * This method show all competitions of male.
     *
     * @return String in format Json Pretty with competitions of male.
     * @throws StatsBombException
     */
    public String getCompetitionsMale() throws StatsBombException
    {
        GenderFilter genderFilter = new GenderFilter();
        return genderFilter.getCompetitionsMale(getListCompetitions());
    }

}
