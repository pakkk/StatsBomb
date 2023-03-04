package es.iesjandula.statsbomb.threesixty_rest.stats.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import es.iesjandula.statsbomb.common.dtos.CompetitionsDto;
import es.iesjandula.statsbomb.common.exception.StatsBombException;
import es.iesjandula.statsbomb.common.load_json.IJsonLoader;
import es.iesjandula.statsbomb.common.load_json.Json;
import es.iesjandula.statsbomb.common.load_json.JsonLoaderImpl;
import es.iesjandula.statsbomb.common.utils.Constants;
import es.iesjandula.statsbomb.models.competition.Competition;
import es.iesjandula.statsbomb.models.matches.Match;
import es.iesjandula.statsbomb.models.three_sixty.FreezeFrame;
import es.iesjandula.statsbomb.models.three_sixty.ThreeSixty;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Joaquin Moreno
 */
@Service
public class ThreeSixtyUtils
{
    /** Attribute - Logger */
    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private Environment environment;

    @Autowired
    private IThreeSixtyRepository iThreeSixtyRepository;

    @Autowired
    private IFreezeFrameRepository iFreezeFrameRepository;



    /**
     * Return list with all three sixties corresponding the match id in JSON StatsBomb
     * @param matchId
     * @return List of three sixty data
     * @throws StatsBombException
     */
    public List<ThreeSixty> getListThreeSixty(int matchId) throws StatsBombException
    {
        JsonLoaderImpl jsonLoader = new JsonLoaderImpl();
        String jsonThreeSixty = jsonLoader.loadThreeSixty(matchId);
        ObjectMapper mapper = Json.mapper();
        List<ThreeSixty> threeSixtyList = new ArrayList<>();

        try
        {
            threeSixtyList = mapper.readValue(jsonThreeSixty, new TypeReference<List<ThreeSixty>>(){});
        }
        catch (JsonProcessingException jsonProcessingException)
        {
            LOGGER.error(Constants.E_PARSING_JSON_TO_OBJECT, jsonProcessingException);
            throw new StatsBombException(Constants.E_PARSING_JSON_TO_OBJECT, "Error when parsing the Json", jsonProcessingException);
        }

        return threeSixtyList;
    }

    public void insertThreeSixtyUtilsInDataBase() throws StatsBombException, JsonProcessingException {
        List<CompetitionsDto> competitionList = this.getListCompetition();
        for (CompetitionsDto competitionsDto : competitionList)
        {
            if(competitionsDto.getMatch_available_360() != null)
            {
                List<Match> matchList = this.getListMatch(competitionsDto.getCompetition_id(), competitionsDto.getSeason_id());

                LOGGER.warn(competitionsDto.getCompetition_id() + " <- CompetitionsId");

                for (Match match : matchList)
                {

                    LOGGER.warn(match.getMatch_id() + " <- MatchId");

                    List<ThreeSixty> threeSixtyList = this.getListThreeSixty(match.getMatch_id());

                    for (ThreeSixty threeSixtyItem : threeSixtyList)
                    {

                        LOGGER.warn(threeSixtyItem.getEvent_uuid() + " <- threeSixty UUID");
                        List<FreezeFrame> freezeFrameList = threeSixtyItem.getFreeze_frame();

                        for (FreezeFrame freezeFrameItem : freezeFrameList)
                        {
                            LOGGER.warn(freezeFrameItem.getActor() + " <- Actor");
                            iFreezeFrameRepository.saveAndFlush(freezeFrameItem);
                        }

                        iThreeSixtyRepository.saveAndFlush(threeSixtyItem);
                    }


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
