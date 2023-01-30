package es.iesjandula.statsbomb.events_rest.stats.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import es.iesjandula.statsbomb.common.exception.StatsBombException;
import es.iesjandula.statsbomb.common.load_json.IJsonLoader;
import es.iesjandula.statsbomb.common.load_json.Json;
import es.iesjandula.statsbomb.common.load_json.JsonLoaderImpl;
import es.iesjandula.statsbomb.common.utils.Constants;
import es.iesjandula.statsbomb.models.competition.Competition;
import es.iesjandula.statsbomb.models.event.Event;
import es.iesjandula.statsbomb.models.matches.Match;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventUtils
{

    /* Attribute - Logger */
    private final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private IEventRepository iEventRepository;

    public List<Event> getEvents(int matchId) throws StatsBombException
    {
        JsonLoaderImpl jsonLoader = new JsonLoaderImpl();
        String jsonEvents = jsonLoader.loadEvents(matchId);
        ObjectMapper mapper = Json.mapper();
        List<Event> eventsList;

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

    public void insertEventsInDataBase() throws StatsBombException, JsonProcessingException
    {
        List<Competition> competitionList = this.getCompetition();

        for (Competition competition : competitionList)
        {
            List<Match> macthesList = this.getMatch(competition.getCompetition_id(), competition.getSeason_id());

            for (Match match : macthesList)
            {
                this.iEventRepository.saveAllAndFlush(this.getEvents(match.getMatch_id()));
            }
        }

    }

    public List<Match> getMatch(int competitionId, int seasonId) throws StatsBombException, JsonProcessingException
    {
        IJsonLoader jsonLoader = new JsonLoaderImpl();

        ObjectMapper mapper = Json.mapper();

        return mapper.readValue(jsonLoader.loadMatches(competitionId, seasonId), new TypeReference<List<Match>>(){});
    }

    public List<Competition> getCompetition() throws StatsBombException, JsonProcessingException
    {
        IJsonLoader jsonLoader = new JsonLoaderImpl();

        ObjectMapper mapper = Json.mapper();

        return mapper.readValue(jsonLoader.loadCompetitions(), new TypeReference<List<Competition>>(){});
    }

}
