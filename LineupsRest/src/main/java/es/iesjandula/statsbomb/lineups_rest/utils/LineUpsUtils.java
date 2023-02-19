package es.iesjandula.statsbomb.lineups_rest.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import es.iesjandula.statsbomb.common.dtos.CompetitionsDto;
import es.iesjandula.statsbomb.common.exception.StatsBombException;
import es.iesjandula.statsbomb.common.load_json.IJsonLoader;
import es.iesjandula.statsbomb.common.load_json.Json;
import es.iesjandula.statsbomb.common.load_json.JsonLoaderImpl;
import es.iesjandula.statsbomb.common.utils.Constants;
import es.iesjandula.statsbomb.models.lineups.Lineups;
import es.iesjandula.statsbomb.models.matches.Match;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LineUpsUtils
{

    private final Logger LOGGER = LogManager.getLogger();
    @Autowired
    private ILineUpsRepository lineUpsRepository;

    @Autowired
    private Environment environment;

    public List<Lineups> getListLineUps(int matchId) throws StatsBombException
    {

        JsonLoaderImpl jsonLoader = new JsonLoaderImpl();
        String jsonLineups = jsonLoader.loadLineups(matchId);
        ObjectMapper mapper = Json.mapper();
        List<Lineups> lineupsList = new ArrayList<>();

        try
        {
            lineupsList = mapper.readValue(jsonLineups, new TypeReference<List<Lineups>>(){});
        }
        catch (JsonProcessingException jsonProcessingException)
        {
            LOGGER.error(Constants.E_PARSING_JSON_TO_OBJECT, jsonProcessingException);
            throw new StatsBombException(Constants.E_PARSING_JSON_TO_OBJECT, "Error a la hora de parsear el Json", jsonProcessingException);
        }

        return lineupsList;
    }

    public void insertLineUpsInDataBase() throws StatsBombException, JsonProcessingException {
        List<CompetitionsDto> competitionList = this.getListCompetition();

        for (CompetitionsDto competitionsDto : competitionList)
        {
            if(competitionsDto.getMatch_available_360() != null)
            {
                List<Match> matchList = this.getListMatch(competitionsDto.getCompetition_id(), competitionsDto.getSeason_id());

                for (Match match : matchList)
                {
                    this.lineUpsRepository.saveAllAndFlush((this.getListLineUps(match.getMatch_id())));
                }
            }
        }
    }

    public List<Match> getListMatch(int competitionId, int seasonId) throws StatsBombException, JsonProcessingException
    {
        IJsonLoader jsonLoader = new JsonLoaderImpl();

        ObjectMapper mapper = Json.mapper();

        return mapper.readValue(jsonLoader.loadMatches(competitionId, seasonId), new TypeReference<List<Match>>(){});
    }

    public List<CompetitionsDto> getListCompetition() throws StatsBombException, JsonProcessingException
    {
        String competitionsUrl = this.environment.getProperty("statsbomb.competitionsUrl") ;
        IJsonLoader jsonLoader = new JsonLoaderImpl();
        String competitionsUrlEndpoint = competitionsUrl + "/competitions" + "/id";

        ObjectMapper mapper = Json.mapper();
        return mapper.readValue(jsonLoader.loadCompetitionsByRest(competitionsUrlEndpoint), new TypeReference<List<CompetitionsDto>>(){});
    }
}
