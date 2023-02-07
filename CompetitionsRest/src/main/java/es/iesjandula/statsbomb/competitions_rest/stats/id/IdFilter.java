package es.iesjandula.statsbomb.competitions_rest.stats.id;

import java.util.ArrayList;
import java.util.List;

import es.iesjandula.statsbomb.common.dtos.CompetitionsDto;
import es.iesjandula.statsbomb.common.exception.StatsBombException;
import es.iesjandula.statsbomb.common.utils.JsonUtils;
import es.iesjandula.statsbomb.models.competition.Competition;

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

        List<CompetitionsDto> competitionsDtoList = new ArrayList<>();

        // Filter competitions, search competitions id and seasons id
        for (Competition competition : competitionList)
        {
            CompetitionsDto competitionsDto = new CompetitionsDto();

            competitionsDto.setCompetition_id(competition.getCompetition_id());
            competitionsDto.setSeason_id(competition.getSeason_id());
            competitionsDto.setMatch_available_360(competition.getMatch_available_360());
            competitionsDto.setMatch_available(competition.getMatch_available());

            // Add result to the list
            competitionsDtoList.add(competitionsDto);
        }

        JsonUtils jsonUtils = new JsonUtils();

        // Convert the List to Json Format
        jsonCompetitionsId = jsonUtils.writeObjectToJsonAsStringPretty(competitionsDtoList);

        return jsonCompetitionsId;
    }
}
