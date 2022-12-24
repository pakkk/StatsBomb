package es.iesjandula.statsbomb.matches_stats;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import es.iesjandula.statsbomb.common.exception.StatsBombException;
import es.iesjandula.statsbomb.common.load_json.Json;
import es.iesjandula.statsbomb.common.load_json.JsonLoaderImpl;
import es.iesjandula.statsbomb.common.utils.Constants;
import es.iesjandula.statsbomb.matches_stats.possession.PossessionFilter;
import es.iesjandula.statsbomb.models.event.Event;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class MatchesStats
{

    /* Attribute - Logger */
    private final Logger LOGGER = LogManager.getLogger();

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

    public String getListOfPossessionOfMatch(int matchId) throws StatsBombException
    {
        PossessionFilter possessionFilter = new PossessionFilter();
        return possessionFilter.getListPosesion(getEventsOfMatch(matchId));
    }

}
