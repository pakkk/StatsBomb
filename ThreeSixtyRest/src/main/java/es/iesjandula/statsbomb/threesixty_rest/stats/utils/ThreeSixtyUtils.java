package es.iesjandula.statsbomb.threesixty_rest.stats.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import es.iesjandula.statsbomb.common.exception.StatsBombException;
import es.iesjandula.statsbomb.common.load_json.Json;
import es.iesjandula.statsbomb.common.load_json.JsonLoaderImpl;
import es.iesjandula.statsbomb.common.utils.Constants;
import es.iesjandula.statsbomb.models.three_sixty.ThreeSixty;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
}
