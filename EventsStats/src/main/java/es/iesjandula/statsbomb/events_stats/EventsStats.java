package es.iesjandula.statsbomb.events_stats;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import es.iesjandula.statsbomb.common.exception.StatsBombException;
import es.iesjandula.statsbomb.common.load_json.Json;
import es.iesjandula.statsbomb.common.load_json.JsonLoaderImpl;
import es.iesjandula.statsbomb.common.utils.Constants;
import es.iesjandula.statsbomb.events_stats.duel.DuelFilter;
import es.iesjandula.statsbomb.events_stats.duel.DuelResult;
import es.iesjandula.statsbomb.events_stats.goalkeeper.GoalkeeperFilter;
import es.iesjandula.statsbomb.models.event.Event;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Joaquin Moreno
 *
 * In this class we create the filter and statistics for Json Events.
 */
public class EventsStats
{
    private final Logger LOGGER = LogManager.getLogger();

    /**
     * Return list with all events in json StatsBomb
     *
     * @return List of Events
     * @throws StatsBombException
     */
    private List<Event> getListEvents(int matchId) throws StatsBombException
    {

        JsonLoaderImpl jsonLoader = new JsonLoaderImpl();
        String jsonEvents = jsonLoader.loadEvents(matchId);
        ObjectMapper mapper = Json.mapper();
        List<Event> eventsList = new ArrayList<>();

        try
        {
            eventsList = mapper.readValue(jsonEvents, new TypeReference<List<Event>>(){});
        }
        catch (JsonProcessingException jsonProcessingException)
        {
            LOGGER.error(Constants.E_PARSING_JSON_TO_OBJECT, jsonProcessingException);
            throw new StatsBombException(Constants.E_PARSING_JSON_TO_OBJECT, "Error a la hora de parsear el Json", jsonProcessingException);
        }

        return eventsList;
    }

    /**
     * This method show the goalkeeper who uses his feet the most .
     *
     * @return String in format Json Pretty with the goalkeeper who uses his feet the most.
     * @throws StatsBombException
     */
    public String getPlayerGoalkeeper(int matchId) throws StatsBombException
    {
        GoalkeeperFilter goalkeeperFilter = new GoalkeeperFilter();
        return goalkeeperFilter.getPlayerGoalkeeper(getListEvents(matchId));
    }

    /**
     * Metod that show the players that won more duels
     *
     * @return String in json format that contains the players that won more duels
     * @throws StatsBombException
     */
    public String getPlayerDuels(int matchId) throws StatsBombException
    {
        DuelFilter duelFilter = new DuelFilter();
        return duelFilter.getPlayersDuels(getListEvents(matchId));
    }

}
