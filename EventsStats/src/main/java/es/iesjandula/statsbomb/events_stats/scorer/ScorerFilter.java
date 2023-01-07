package es.iesjandula.statsbomb.events_stats.scorer;

import es.iesjandula.statsbomb.common.exception.StatsBombException;
import es.iesjandula.statsbomb.common.utils.JsonUtils;
import es.iesjandula.statsbomb.models.event.Event;

import java.util.ArrayList;
import java.util.List;

/**
 * @author David Armijo
 */
public class ScorerFilter
{
    public String getScorers(List<Event> eventList) throws StatsBombException {

        // result of the scorers
        String jsonScorers = "";

        List<ScorerResult> scorerResultList = new ArrayList<>();

        for(Event event : eventList){
            if(event.getShot() != null){
                if(event.getShot().getOutcome().getName().equalsIgnoreCase("goal")){
                    scorerResultList.add(new ScorerResult( event.getTeam().getName(),
                            event.getPlayer().getName(), event.getMinute(), event.getSecond()));

                }
            }
        }

        // Convert the duel list to a json
        JsonUtils jsonUtils = new JsonUtils();

        jsonScorers = jsonUtils.writeObjectToJsonAsStringPretty(jsonScorers);

        return jsonScorers;

    }
}
