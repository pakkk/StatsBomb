package es.iesjandula.statsbomb.threesixty_stats.teammate;

import java.util.ArrayList;
import java.util.List;

import es.iesjandula.statsbomb.common.exception.StatsBombException;
import es.iesjandula.statsbomb.common.utils.JsonUtils;
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

        //Filter
        List<ResultTeammate> listOfResultTeammates = new ArrayList<ResultTeammate>() ;
        

        for(ThreeSixty threeSixty : threeSixtyList)
        {
            ResultTeammate resultTeammate = new ResultTeammate(threeSixty.getEvent_uuid());
            int teamMate = 0 ;
            int noTeamMate = 0 ;

            if(threeSixty.getFreeze_frame() != null)
            {
                for(int i = 0; i < threeSixty.getFreeze_frame().size(); i++)
                {
                    if(threeSixty.getFreeze_frame().get(i).getTeammate() != null)
                    {
                        if (threeSixty.getFreeze_frame().get(i).getTeammate())
                        {
                            teamMate ++ ;
                        }
                        else
                        {
                            noTeamMate ++ ;
                        }
                    }
                }
            }

            resultTeammate.setTeam_mate(teamMate) ;
            resultTeammate.setNo_team_mate(noTeamMate) ;

            listOfResultTeammates.add(resultTeammate) ;
        }

        JsonUtils jsonUtils = new JsonUtils();
        //Convert the List to the Json Pretty
        jsonTeammateThreeSixty = jsonUtils.writeObjectToJsonAsStringPretty(listOfResultTeammates);

        return jsonTeammateThreeSixty;
    }
}
