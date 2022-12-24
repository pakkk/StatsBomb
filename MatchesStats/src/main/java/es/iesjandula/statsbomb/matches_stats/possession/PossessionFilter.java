package es.iesjandula.statsbomb.matches_stats.possession;

import es.iesjandula.statsbomb.common.exception.StatsBombException;
import es.iesjandula.statsbomb.common.utils.JsonUtils;
import es.iesjandula.statsbomb.models.event.Event;
import es.iesjandula.statsbomb.models.results.ResultListPosesionFilter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Neil Hdez
 */
public class PossessionFilter
{

    /* Attribute - Logger */
    private final Logger LOGGER = LogManager.getLogger();

    public String getListPosesion(List<Event> eventListOfMatch) throws StatsBombException
    {
        /* Reult of Posesion */
        String jsonListPosesionOfMatch = "";

        Map<Integer, ResultListPosesionFilter> mapPossesion = new HashMap<>(); // Storage of possesión and Result


        for (Event event : eventListOfMatch)
        {
            if (!mapPossesion.containsKey(event.getPossession())) // If not exist int map, we storage the new data
            {
                mapPossesion.put(event.getPossession(), new ResultListPosesionFilter()); // We create the result
                mapPossesion.get(event.getPossession()).getActions().add(event.getType().getName()); // we add the action
                mapPossesion.get(event.getPossession()).setTeam(event.getTeam().getName()); // We add the name of the team
                mapPossesion.get(event.getPossession()).setPosession(event.getPossession()); // We add the number possesion

            } else // Is exist only we add the new action
            {
                mapPossesion.get(event.getPossession()).getActions().add(event.getType().getName());
            }
        }

        JsonUtils jsonUtils = new JsonUtils();

        jsonListPosesionOfMatch = jsonUtils.writeObjectToJsonAsStringPretty(mapPossesion);

        return jsonListPosesionOfMatch;
    }

}
