package es.iesjandula.statsbomb.events_rest.stats.duel;

import es.iesjandula.statsbomb.common.exception.StatsBombException;
import es.iesjandula.statsbomb.common.utils.JsonUtils;
import es.iesjandula.statsbomb.models.event.Event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuelFilter
{

    /**
     * Method in charge of obtaining the highest duelists of each team in the match
     * @param eventList json event
     * @return the players who have won the most duels
     * @throws StatsBombException an statsBombException
     */
    public String getPlayersDuels(List<Event> eventList) throws StatsBombException
    {

        // result of the duels
        String jsonDuels = "";

        String teamName1;
        String teamName2;

        Map<String, Integer> mapDuelsTeam1 = new HashMap<String, Integer>();
        Map<String, Integer> mapDuelsTeam2 = new HashMap<String, Integer>();
        List<DuelResult> listDuels = new ArrayList<DuelResult>();

        teamName1 = eventList.get(0).getTeam().getName();
        teamName2 = eventList.get(1).getTeam().getName();

        TakeDuels(eventList, teamName1, mapDuelsTeam1, listDuels);

        TakeDuels(eventList, teamName2, mapDuelsTeam2, listDuels);

        // Convert the duel list to a json
        JsonUtils jsonUtils = new JsonUtils();

        jsonDuels = jsonUtils.writeObjectToJsonAsStringPretty(listDuels);

        return jsonDuels;

    }

    /**
     * method in charge of taking from the map the player who wins the most duels
     *
     * @param eventList listEvents
     * @param teamName name of the team
     * @param mapDuelsTeam map of duels
     * @param listDuels list of final duels
     */
    private void TakeDuels(List<Event> eventList, String teamName, Map<String, Integer> mapDuelsTeam, List<DuelResult> listDuels) {
        for(int i = 0; i < eventList.size(); i++)
        {

            if(eventList.get(i).getDuel() != null && eventList.get(i).getDuel().getOutcome() != null && eventList.get(i).getDuel().getOutcome().getName() != null &&
                    eventList.get(i).getTeam().getName().equals(teamName) && eventList.get(i).getType().getName().equals("Duel") && eventList.get(i).getDuel().getOutcome().getName().equals("Won"))
            {

                if(!mapDuelsTeam.containsKey(eventList.get(i).getPlayer().getName()))
                {

                    mapDuelsTeam.put(eventList.get(i).getPlayer().getName(), 1);

                }
                else
                {

                    mapDuelsTeam.put(eventList.get(i).getPlayer().getName(), mapDuelsTeam.get(eventList.get(i).getPlayer().getName()) + 1);

                }

            }
            else if(eventList.get(i).getDuel() != null && eventList.get(i).getDuel().getOutcome() != null && eventList.get(i).getDuel().getOutcome().getName() != null &&
                    eventList.get(i).getTeam().getName().equals(teamName) && eventList.get(i).getType().getName().equals("Duel") && eventList.get(i).getDuel().getOutcome().getName().equals("Success In Play"))
            {

                if(!mapDuelsTeam.containsKey(eventList.get(i).getPlayer().getName()))
                {

                    mapDuelsTeam.put(eventList.get(i).getPlayer().getName(), 1);

                }
                else
                {

                    mapDuelsTeam.put(eventList.get(i).getPlayer().getName(), mapDuelsTeam.get(eventList.get(i).getPlayer().getName()) + 1);

                }

            }

        }

        DuelResult duelResultTeam = new DuelResult();

        duelResultTeam.setEquipo(teamName);
        duelResultTeam.setNombre(getMayor(mapDuelsTeam).getKey());
        duelResultTeam.setDuelos_ganados(getMayor(mapDuelsTeam).getValue());

        listDuels.add(duelResultTeam);
    }

    /**
     * Method to which a map is passed and is in charge of obtaining
     * the key and the greater value of a map that is passed to it by parameters
     * @param map map
     * @return returns the largest entry of a map
     */
    public static Map.Entry<String, Integer> getMayor(Map<String, Integer> map)
    {
        Map.Entry<String, Integer> maxEntry = null;
        Integer max = 0;

        for(Map.Entry<String, Integer> entry : map.entrySet())
        {
            Integer value = entry.getValue();
            if(value > max)
            {
                max = value;
                maxEntry = entry;
            }
        }
        return maxEntry;
    }

}
