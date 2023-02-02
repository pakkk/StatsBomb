package es.iesjandula.statsbomb.competitions_rest.stats.web_filter;

import es.iesjandula.statsbomb.common.exception.StatsBombException;
import es.iesjandula.statsbomb.common.utils.JsonUtils;
import es.iesjandula.statsbomb.competitions_rest.stats.models_result.CompetitionsWeb;
import es.iesjandula.statsbomb.models.competition.Competition;
import es.iesjandula.statsbomb.models.competition.CompetitionId;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Neil Hdez
 * @version 1.0.0
 * @since 02/02/2023
 */
public class WebFilter
{

    /**
     * This method return name and season name of all competitions
     * @return String in format Json Pretty with name and season of all competitions
     * @throws StatsBombException Exception to the writeObjectToJsonAsStringPretty
     */
    public String getCompetitionsNameAndSeasonName(List<Competition> competitionList) throws StatsBombException
    {

        String jsonCompetitionsNameAndSeasonName = "";

        List<CompetitionsWeb> competitionsWebList = new ArrayList<>();

        for (Competition competition:competitionList)
        {
            competitionsWebList.add(new CompetitionsWeb(new CompetitionId(competition.getCompetition_id(), competition.getSeason_id()), competition.getCompetition_name(), competition.getSeason_name()));
        }

        JsonUtils jsonUtils = new JsonUtils();

        jsonCompetitionsNameAndSeasonName = jsonUtils.writeObjectToJsonAsStringPretty(competitionsWebList);

        return jsonCompetitionsNameAndSeasonName;

    }
}
