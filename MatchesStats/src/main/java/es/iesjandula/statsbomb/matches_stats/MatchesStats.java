package es.iesjandula.statsbomb.matches_stats;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import es.iesjandula.statsbomb.common.exception.StatsBombException;
import es.iesjandula.statsbomb.common.load_json.Json;
import es.iesjandula.statsbomb.common.load_json.JsonLoaderImpl;
import es.iesjandula.statsbomb.common.utils.Constants;
import es.iesjandula.statsbomb.matches_stats.date.DateFilter;
import es.iesjandula.statsbomb.matches_stats.possession.PossessionFilter;
import es.iesjandula.statsbomb.models.event.Event;
import es.iesjandula.statsbomb.models.matches.Match;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Neil Hdez
 * @author Aljarilla11
 */
public class MatchesStats
{

    /* Attribute - Logger */
    private final Logger LOGGER = LogManager.getLogger();

    /**
     * Search all Events of a Match
     * @param matchId Identifier unique of Match
     * @return all Events of match
     * @throws StatsBombException
     */
    public List<Event> getEventsOfMatch(int matchId) throws StatsBombException
    {

        JsonLoaderImpl jsonLoader = new JsonLoaderImpl();
        String jsonEventsOfMatch = jsonLoader.loadEvents(matchId);
        ObjectMapper mapper = Json.mapper();
        List<Event> eventList = new ArrayList<>();

        try
        {
            eventList = mapper.readValue(jsonEventsOfMatch, new TypeReference<List<Event>>(){});
        }
        catch (JsonProcessingException jsonProcessingException)
        {
            LOGGER.error(Constants.E_PARSING_JSON_TO_OBJECT, jsonProcessingException);
            throw new StatsBombException(Constants.E_PARSING_JSON_TO_OBJECT, "Error a la hora de parsear el Json", jsonProcessingException);
        }

        return eventList;
    }

    /**
     * Search all Matches of a Competition and Season
     * @param competitionId Identifier unique of Competition
     * @param seasonId Identifier unique of Season
     * @return all Matches of competition and season
     * @throws StatsBombException
     */
    public List<Match> getMatches(int competitionId, int seasonId) throws StatsBombException
    {

        JsonLoaderImpl jsonLoader = new JsonLoaderImpl();
        String jsonMatches = jsonLoader.loadMatches(competitionId, seasonId);
        ObjectMapper mapper = Json.mapper();
        List<Match> matchesList = new ArrayList<>();

        try
        {
            matchesList = mapper.readValue(jsonMatches, new TypeReference<List<Match>>(){});
        }
        catch (JsonProcessingException jsonProcessingException)
        {
            LOGGER.error(Constants.E_PARSING_JSON_TO_OBJECT, jsonProcessingException);
            throw new StatsBombException(Constants.E_PARSING_JSON_TO_OBJECT, "Error a la hora de parsear el Json", jsonProcessingException);
        }

        return matchesList;
    }

    /**
     * Call of Filter
     * @param matchId Match
     * @return a list of Possessions
     * @throws StatsBombException
     */
    public String getListOfPossessionOfMatch(int matchId) throws StatsBombException
    {
        PossessionFilter possessionFilter = new PossessionFilter();
        return possessionFilter.getListPosesion(getEventsOfMatch(matchId));
    }

    /**
     * Call of Filter
     * @param competitionId Competition
     * @param seasonId Season
     * @return a list of Matches
     * @throws StatsBombException
     */
    public String getListOfMatchesByDate(int competitionId,int seasonId,String dateStart) throws StatsBombException
    {
        DateFilter dateFilter = new DateFilter();
        return dateFilter.getListMatchesByDate(getMatches(competitionId,seasonId), dateStart);
    }

    /**
     * Call of Filter
     * @param matchId Match
     * @return the porcentage of possesions
     * @throws StatsBombException
     */
    public String getPorcentageOfPossesions(int matchId) throws StatsBombException
    {
        PossessionFilter possessionFilter = new PossessionFilter();
        return possessionFilter.getPorcentageOfPossesion(getEventsOfMatch(matchId));
    }


}
