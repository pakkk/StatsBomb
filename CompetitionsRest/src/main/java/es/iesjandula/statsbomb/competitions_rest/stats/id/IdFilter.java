package es.iesjandula.statsbomb.competitions_rest.stats.id;

import java.util.ArrayList;
import java.util.List;

import es.iesjandula.statsbomb.common.exception.StatsBombException;
import es.iesjandula.statsbomb.common.utils.JsonUtils;
import es.iesjandula.statsbomb.models.competition.Competition;
import es.iesjandula.statsbomb.models.competition.CompetitionId;

public class IdFilter 
{
    public String getCompetitionsId(List<Competition> competitionList) throws StatsBombException
    {
        String jsonCompetitionsId = "";

        List<CompetitionId> competitionIdList = new ArrayList<>();

        for (Competition competition : competitionList)
        {
            CompetitionId competitionId = new CompetitionId();
            if(competition.getCompetition_id() != null && competition.getSeason_id() != null)
            {
                competitionId.setCompetition_id(competition.getCompetition_id());
                competitionId.setSeason_id(competition.getSeason_id());
            }
            competitionIdList.add(competitionId);
        }

        JsonUtils jsonUtils = new JsonUtils();

        jsonCompetitionsId = jsonUtils.writeObjectToJsonAsStringPretty(competitionIdList);

        return jsonCompetitionsId;
    }   
}
