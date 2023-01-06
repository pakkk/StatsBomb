package es.iesjandula.statsbomb.events_stats.duel;

import es.iesjandula.statsbomb.common.exception.StatsBombException;
import es.iesjandula.statsbomb.common.utils.JsonUtils;
import es.iesjandula.statsbomb.models.event.Event;
import es.iesjandula.statsbomb.models.event.Team;

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

        List<Team> listTeam = new ArrayList<Team>();

        for (Event event : eventList)
        {
            listTeam.add(event.getTeam());
        }

        teamName1 = listTeam.get(0).getName();
        teamName2 = listTeam.get(1).getName();

        takeDuelsFromMap(eventList, teamName1, teamName2, mapDuelsTeam1, listDuels);

        takeDuelsFromMap(eventList, teamName2, teamName2, mapDuelsTeam2, listDuels);


        // Convert the duel list to a json
        JsonUtils jsonUtils = new JsonUtils();

        jsonDuels = jsonUtils.writeObjectToJsonAsStringPretty(listDuels);

        return jsonDuels;

    }

    /**
     * method in charge of taking from the map the player who wins the most duels
     * @param eventList listEvents
     * @param teamName1 name of the team1
     * @param teamName2 name of the team2
     * @param mapDuelsTeam map of duels
     * @param listDuels list of final duels
     */
    private void takeDuelsFromMap(List<Event> eventList, String teamName1, String teamName2, Map<String, Integer> mapDuelsTeam, List<DuelResult> listDuels)
    {
        for (Event event : eventList) {

            if (event.getTeam().getName().equals(teamName1) && event.getType().getName().equals("Duel") && event.getDuel().getOutcome().getName().equals("Won")) {

                if (!mapDuelsTeam.containsKey(event.getPlayer().getName())) {

                    mapDuelsTeam.put(event.getPlayer().getName(), 1);

                } else {

                    mapDuelsTeam.put(event.getPlayer().getName(), mapDuelsTeam.get(event.getPlayer().getName()) + 1);

                }

            } else if (event.getTeam().getName().equals(teamName2) && event.getType().getName().equals("Duel") && event.getDuel().getOutcome().getName().equals("Success In Play")) {

                if (!mapDuelsTeam.containsKey(event.getPlayer().getName())) {

                    mapDuelsTeam.put(event.getPlayer().getName(), 1);

                } else {

                    mapDuelsTeam.put(event.getPlayer().getName(), mapDuelsTeam.get(event.getPlayer().getName()) + 1);

                }

            }

        }

        DuelResult duelResultTeam1 = new DuelResult();

        duelResultTeam1.setEquipo(teamName1);
        duelResultTeam1.setNombre(getMayor(mapDuelsTeam).getKey());
        duelResultTeam1.setDuelos_ganados(getMayor(mapDuelsTeam).getValue());

        listDuels.add(duelResultTeam1);
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
