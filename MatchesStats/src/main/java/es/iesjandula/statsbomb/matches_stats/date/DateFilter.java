package es.iesjandula.statsbomb.matches_stats.date;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.iesjandula.statsbomb.common.exception.StatsBombException;
import es.iesjandula.statsbomb.common.utils.JsonUtils;
import es.iesjandula.statsbomb.common.utils.DateUtils;
import es.iesjandula.statsbomb.models.matches.Match;

/**
 * @author Aljarilla11
 */
public class DateFilter
{
    /**
     * This method obtains a list of the matches that was played after a date.
     * @param listOfMatch List Of Matches
     * @return A list of matches by date
     * @throws StatsBombException
     */

    public String getListMatchesByDate(List<Match> listOfMatch,String dateStart) throws StatsBombException
    {
        DateUtils dateUtils = new DateUtils();
        String jsonListMatchesByDate = "";


        Map<String,String> mapMatches = new HashMap<>();

        Date fechaEmpezarDate = dateUtils.convertStringToDateFormatddMMyyyy(dateStart);


        for(int i=0;i<listOfMatch.size();i++)
        {

            if (listOfMatch.get(i).getMatch_date() != null )
            {
                Date matchDate = dateUtils.convertStringToDateFormatddMMyyyyWithHyphen(listOfMatch.get(i).getMatch_date());
                if (matchDate.after(fechaEmpezarDate))
                {
                    mapMatches.put(listOfMatch.get(i).getMatch_date(),listOfMatch.get(i).getHome_team().getHome_team_name()+" vs "+listOfMatch.get(i).getAway_team().getAway_team_name());
                }
            }
        }

        JsonUtils jsonUtils = new JsonUtils();

        jsonListMatchesByDate = jsonUtils.writeObjectToJsonAsStringPretty(mapMatches);

        return jsonListMatchesByDate;
    }
}
