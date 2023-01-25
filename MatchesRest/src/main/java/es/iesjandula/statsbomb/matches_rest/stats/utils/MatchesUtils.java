package es.iesjandula.statsbomb.matches_rest.stats.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import es.iesjandula.statsbomb.common.exception.StatsBombException;
import es.iesjandula.statsbomb.common.load_json.IJsonLoader;
import es.iesjandula.statsbomb.common.load_json.Json;
import es.iesjandula.statsbomb.common.load_json.JsonLoaderImpl;
import es.iesjandula.statsbomb.common.utils.Constants;

import es.iesjandula.statsbomb.models.competition.Competition;
import es.iesjandula.statsbomb.models.matches.Match;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Joaquin Moreno
 */
@Service
public class MatchesUtils
{
    /* Attribute - Logger */
    private final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private IMatchesRepository matchesRepository;

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
        List<Match> matchesList;

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

    public void insertMatchesInDataBase() throws StatsBombException, JsonProcessingException
    {

        List<Competition> competitionList = getCompetition();

        for (Competition competition : competitionList)
        {
            this.matchesRepository.saveAllAndFlush(this.getMatches(competition.getCompetition_id(), competition.getSeason_id()));
        }

    }

    public List<Competition> getCompetition() throws StatsBombException, JsonProcessingException
    {
        IJsonLoader jsonLoader = new JsonLoaderImpl();

        ObjectMapper mapper = Json.mapper();

        return mapper.readValue(jsonLoader.loadCompetitions(), new TypeReference<List<Competition>>(){});
    }
}
