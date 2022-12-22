package es.iesjandula.statsbomb.events_stats.goalkeeper;

import es.iesjandula.statsbomb.common.exception.StatsBombException;
import es.iesjandula.statsbomb.common.utils.JsonUtils;
import es.iesjandula.statsbomb.models.event.Event;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Joaquin Moreno
 */
public class GoalkeeperFilter
{
    /**
     * This method show the goalkeeper with more passes.
     *
     * @return String in format Json Pretty with
     */
    public String getPlayerGoalkeeper(List<Event> eventList) throws StatsBombException
    {
        // Result
        String jsonPlayerGoalkeeper = "";


        Map<Event,Integer>mapGoalkeeperPass = new HashMap<>();

        // Filter
        for (Event event : eventList)
        {
            if (event.getPosition().getName().equals("Goalkeeper") && event.getPass().getBody_part().getName().equals("Right Foot"))
            {
                if(!mapGoalkeeperPass.containsKey(event))
                {
                    mapGoalkeeperPass.put(event,1);
                }
                else
                {
                    mapGoalkeeperPass.put(event,mapGoalkeeperPass.get(event) + 1);
                }
            }
            else if(event.getPosition().getName().equals("Goalkeeper") && event.getPass().getBody_part().getName().equals("Left Foot"))
            {
                if(!mapGoalkeeperPass.containsKey(event))
                {
                    mapGoalkeeperPass.put(event,1);
                }
                else
                {
                    mapGoalkeeperPass.put(event,mapGoalkeeperPass.get(event)+ 1);
                }
            }
        }

        int maxPassGoalkeeper = 0;
        Event goalkeeper = new Event();
        for(Map.Entry<Event,Integer> recipient : mapGoalkeeperPass.entrySet())
        {

            if(recipient.getValue() > maxPassGoalkeeper)
            {
                maxPassGoalkeeper = recipient.getValue();
                goalkeeper=recipient.getKey();
            }
        }

        ResultGoalkeeper resultGoalkeeper = new ResultGoalkeeper();

        resultGoalkeeper.setNombre(goalkeeper.getPlayer().getName());
        resultGoalkeeper.setEquipo(goalkeeper.getTeam().getName());
        resultGoalkeeper.setPases(maxPassGoalkeeper);


        // Convert List to Json Format
        JsonUtils jsonUtils = new JsonUtils();

        jsonPlayerGoalkeeper = jsonUtils.writeObjectToJsonAsStringPretty(resultGoalkeeper);

        return jsonPlayerGoalkeeper;

    }
    

    


}
