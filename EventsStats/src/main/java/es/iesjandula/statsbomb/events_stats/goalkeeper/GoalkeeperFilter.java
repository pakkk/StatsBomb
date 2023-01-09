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


        Map<String,Integer>mapGoalkeeperPass = new HashMap<>();

        // Filter
        for (Event event : eventList)
        {
            if(event.getPosition() != null && event.getPass() != null)
            {
                if (event.getPosition().getName().equals("Goalkeeper") && event.getPass().getBody_part().getName().equals("Right Foot"))
                {
                    if (!mapGoalkeeperPass.containsKey(event.getPlayer().getName()))
                    {
                        mapGoalkeeperPass.put(event.getPlayer().getName(), 1);
                    } else
                    {
                        mapGoalkeeperPass.put(event.getPlayer().getName(), mapGoalkeeperPass.get(event.getPlayer().getName()) + 1);
                    }
                } else if (event.getPosition().getName().equals("Goalkeeper") && event.getPass().getBody_part().getName().equals("Left Foot"))
                {
                    if (!mapGoalkeeperPass.containsKey(event.getPlayer().getName()))
                    {
                        mapGoalkeeperPass.put(event.getPlayer().getName(), 1);
                    } else
                    {
                        mapGoalkeeperPass.put(event.getPlayer().getName(), mapGoalkeeperPass.get(event.getPlayer().getName()) + 1);
                    }
                }
            }
        }

        int maxPassGoalkeeper = 0;
        String goalkeeper = "";

        for(Map.Entry<String,Integer> recipient : mapGoalkeeperPass.entrySet())
        {

            if(recipient.getValue() > maxPassGoalkeeper)
            {
                maxPassGoalkeeper = recipient.getValue();
                goalkeeper=recipient.getKey();
            }
        }

        ResultGoalkeeper resultGoalkeeper = new ResultGoalkeeper();

        resultGoalkeeper.setNombre(goalkeeper);
        resultGoalkeeper.setPases(maxPassGoalkeeper);

        //Search the team of the playergoalkeeper

        String teamGoalkeeper = "";

        for (Event event : eventList)
        {
            if(event.getPlayer()!=null && event.getPlayer().getName()!=null){

                if(event.getPlayer().getName().equals(goalkeeper))
                {
                    resultGoalkeeper.setEquipo(event.getTeam().getName());

                }
            }

        }

        // Convert List to Json Format
        JsonUtils jsonUtils = new JsonUtils();

        jsonPlayerGoalkeeper = jsonUtils.writeObjectToJsonAsStringPretty(resultGoalkeeper);

        return jsonPlayerGoalkeeper;

    }
    

    


}
