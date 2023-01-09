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


        Map<String,ResultGoalkeeper>mapGoalkeeperPass = new HashMap<>();

        // Filter
        for (Event event : eventList)
        {
            if(event.getPosition() != null && event.getPass() != null)
            {
                if (event.getPosition().getName().equals("Goalkeeper") && event.getPass().getBody_part().getName().equals("Right Foot"))
                {
                    if (!mapGoalkeeperPass.containsKey(event.getPlayer().getName()))
                    {
                        ResultGoalkeeper goalkeeper = new ResultGoalkeeper();
                        goalkeeper.setNombre(event.getPlayer().getName());
                        goalkeeper.setEquipo(event.getTeam().getName());
                        goalkeeper.setPases(1);
                        mapGoalkeeperPass.put(event.getPlayer().getName(), goalkeeper);
                    } else
                    {
                        mapGoalkeeperPass.get(event.getPlayer().getName()).setPases(mapGoalkeeperPass.get(event.getPlayer().getName()).getPases()+1);
                    }
                } else if (event.getPosition().getName().equals("Goalkeeper") && event.getPass().getBody_part().getName().equals("Left Foot"))
                {
                    if (!mapGoalkeeperPass.containsKey(event.getPlayer().getName()))
                    {
                        ResultGoalkeeper goalkeeper = new ResultGoalkeeper();
                        goalkeeper.setNombre(event.getPlayer().getName());
                        goalkeeper.setEquipo(event.getTeam().getName());
                        goalkeeper.setPases(1);
                        mapGoalkeeperPass.put(event.getPlayer().getName(), goalkeeper);
                    } else
                    {
                        mapGoalkeeperPass.get(event.getPlayer().getName()).setPases(mapGoalkeeperPass.get(event.getPlayer().getName()).getPases()+1);
                    }
                }
            }
        }

        int maxPassGoalkeeper = 0;
        String goalkeeper = "";
        String teamGoalkeeper = "";

        for(Map.Entry<String,ResultGoalkeeper> recipient : mapGoalkeeperPass.entrySet())
        {

            if(recipient.getValue().getPases() > maxPassGoalkeeper)
            {
                maxPassGoalkeeper = recipient.getValue().getPases();
                goalkeeper=recipient.getKey();
                teamGoalkeeper = recipient.getValue().getEquipo();
            }
        }

        ResultGoalkeeper resultGoalkeeper = new ResultGoalkeeper();

        resultGoalkeeper.setNombre(goalkeeper);
        resultGoalkeeper.setPases(maxPassGoalkeeper);
        resultGoalkeeper.setEquipo(teamGoalkeeper);

        // Convert List to Json Format
        JsonUtils jsonUtils = new JsonUtils();

        jsonPlayerGoalkeeper = jsonUtils.writeObjectToJsonAsStringPretty(resultGoalkeeper);

        return jsonPlayerGoalkeeper;

    }
    

    


}
