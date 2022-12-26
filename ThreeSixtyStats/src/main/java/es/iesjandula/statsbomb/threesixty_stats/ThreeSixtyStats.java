package es.iesjandula.statsbomb.threesixty_stats;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.iesjandula.statsbomb.common.exception.StatsBombException;
import es.iesjandula.statsbomb.common.load_json.Json;
import es.iesjandula.statsbomb.common.load_json.JsonLoaderImpl;
import es.iesjandula.statsbomb.common.utils.Constants;
import es.iesjandula.statsbomb.models.three_sixty.ThreeSixty;
import es.iesjandula.statsbomb.threesixty_stats.sort.SortFilter;
import es.iesjandula.statsbomb.threesixty_stats.teammate.TeammateFilter;

/**
 * In this class we create the list for the Json Three Sixty
 * 
 * @author Manuel Canio Gil
 * @version 1.0.0
 * @since 21-12-2022
 */
public class ThreeSixtyStats 
{
    /** Attribute - Logger */
    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * Return list with all three sixties corresponding the match id in JSON StatsBomb
     * @param matchId
     * @return List of three sixty data
     * @throws StatsBombException
     */
    private List<ThreeSixty> getListThreeSixty(int matchId) throws StatsBombException 
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
    /**
     * This method return a list order of the three sixties by the match id
     * @param matchId
     * @return A String with the list of the three sixties ordered
     * @throws StatsBombException
     */
    public String getThreeSixtyListOrder(int matchId) throws StatsBombException
    {
        SortFilter sortFilter = new SortFilter();
        return sortFilter.getThreeSixtySorted(getListThreeSixty(matchId));
    }
    /**
     * This method return a list of the number of the teammates corresponding of the event_uuid
     * @param matchId
     * @return A String with the list of the number of the teammates
     * @throws StatsBombException
     */
    public String getTeammatesOfThreeSixty(int matchId) throws StatsBombException
    {
        TeammateFilter teammateFilter = new TeammateFilter();
        return teammateFilter.getTeammateThreeSixty(getListThreeSixty(matchId));
    }
}
