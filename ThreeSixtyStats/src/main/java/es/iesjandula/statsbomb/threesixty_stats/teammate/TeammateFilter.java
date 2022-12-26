package es.iesjandula.statsbomb.threesixty_stats.teammate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.iesjandula.statsbomb.common.exception.StatsBombException;
import es.iesjandula.statsbomb.common.utils.JsonUtils;
import es.iesjandula.statsbomb.models.event.shot.FreezeFrame;
import es.iesjandula.statsbomb.models.three_sixty.ThreeSixty;
import es.iesjandula.statsbomb.threesixty_stats.teammate.result.ResultTeammate;

/**
 * @author Manuel Canio Gil
 */
public class TeammateFilter 
{
    /**
     * This method show the number of the teammates of the event_uuid
     * @param threeSixtyList
     * @return String in format Json Pretty with the number of the teammates
     * @throws StatsBombException
     */
    public String getTeammateThreeSixty(List<ThreeSixty> threeSixtyList) throws StatsBombException
    {
        //Result
        String jsonTeammateThreeSixty = "";

        Map<ThreeSixty, Integer> mapTeammateFilter = new HashMap<>();
        List<FreezeFrame> freezeFrameList = new ArrayList<>();

        //Filter
        for(ThreeSixty threeSixty : threeSixtyList)
        {
            if(threeSixty.getFreeze_frame() != null)
            {
                for(FreezeFrame freezeFrame : freezeFrameList)
                {
                    if(freezeFrame.getTeammate().equals(true))
                    {
                        if(!mapTeammateFilter.containsKey(threeSixty))
                        {
                            mapTeammateFilter.put(threeSixty, 1);
                        }
                        else
                        {
                            mapTeammateFilter.put(threeSixty, mapTeammateFilter.get(threeSixty) + 1);
                        }
                    }
                }
            }
        }

        int numTeammates = 0;
        ThreeSixty teammates = new ThreeSixty();
        for(Map.Entry<ThreeSixty,Integer> recipient : mapTeammateFilter.entrySet())
        {
            if(recipient.getValue() > numTeammates)
            {
                numTeammates = recipient.getValue();
            }
        }
        //Write the result of the teammates
        ResultTeammate resultTeammate = new ResultTeammate();
        resultTeammate.setEvent_uuid(teammates.getEvent_uuid());
        resultTeammate.setTeammates(numTeammates);

        JsonUtils jsonUtils = new JsonUtils();
        //Convert the List to the Json Pretty
        jsonTeammateThreeSixty = jsonUtils.writeObjectToJsonAsStringPretty(resultTeammate);

        return jsonTeammateThreeSixty;
    }
}
