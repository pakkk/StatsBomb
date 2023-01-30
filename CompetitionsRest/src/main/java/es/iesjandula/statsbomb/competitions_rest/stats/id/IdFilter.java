package es.iesjandula.statsbomb.competitions_rest.stats.id;

import java.util.ArrayList;
import java.util.List;

import es.iesjandula.statsbomb.common.exception.StatsBombException;
import es.iesjandula.statsbomb.common.utils.JsonUtils;
import es.iesjandula.statsbomb.models.competition.Competition;
import es.iesjandula.statsbomb.models.competition.CompetitionId;

/**
 * @author Manuel Canio Gil
 * @version 1.0.0
 * @since 30/01/2023
 */
public class IdFilter 
{
    /**
     * This method shows all competitions id
     * 
     * @param competitionList
     * @return String in format Json Pretty with competitions id
     * @throws StatsBombException
     */
    public String getCompetitionsId(List<Competition> competitionList) throws StatsBombException
    {
        // Result
        String jsonCompetitionsId = "";

        List<CompetitionId> competitionIdList = new ArrayList<>();

        // Filter competitions, search competitions id and seasons id
        for (Competition competition : competitionList)
        {
            CompetitionId competitionId = new CompetitionId();
            if(competition.getCompetition_id() != null && competition.getSeason_id() != null)
            {
                competitionId.setCompetition_id(competition.getCompetition_id());
                competitionId.setSeason_id(competition.getSeason_id());
            }
            // Add result to the list
            competitionIdList.add(competitionId);
        }

        JsonUtils jsonUtils = new JsonUtils();
        
        // Convert the List to Json Format
        jsonCompetitionsId = jsonUtils.writeObjectToJsonAsStringPretty(competitionIdList);

        return jsonCompetitionsId;
    }   
}
