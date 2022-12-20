package es.iesjandula.statsbomb.events_stats.playergoalkeeper;

import es.iesjandula.statsbomb.common.exception.StatsBombException;
import es.iesjandula.statsbomb.common.utils.JsonUtils;
import es.iesjandula.statsbomb.models.open_event.Event;


import java.util.ArrayList;
import java.util.List;
/**
 * @author Joaquin Moreno
 */
public class PlayerGoalkeeperFilter
{
    /**
     * This method show all competitions of female.
     *
     * @return String in format Json Pretty with competitions of female.
     */
    public String getPlayerGoalkeeper(List<Event> competitionList) throws StatsBombException
    {
        // Result
        String jsonPlayerGoalkeeper = "";

        List<Event> eventListGoalkeeper = new ArrayList<>();

        // Filter Competitions, search competitions of female
        for (Event event : competitionList)
        {
            if (event.getGoalkeeper().toString().equalsIgnoreCase("hola"))
            {
                eventListGoalkeeper.add(event);
            }
        }

        // Convert List to Json Format
        JsonUtils jsonUtils = new JsonUtils();

        jsonPlayerGoalkeeper = jsonUtils.writeObjectToJsonAsStringPretty(eventListGoalkeeper);

        return jsonPlayerGoalkeeper;

    }
}
