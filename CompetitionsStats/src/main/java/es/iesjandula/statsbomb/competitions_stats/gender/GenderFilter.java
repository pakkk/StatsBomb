package es.iesjandula.statsbomb.competitions_stats.gender;

import es.iesjandula.statsbomb.common.exception.StatsBombException;
import es.iesjandula.statsbomb.common.utils.JsonUtils;
import es.iesjandula.statsbomb.models.competition.Competition;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Neil Hdez
 * @version 1.0.0
 * @since 13/12/2022
 */
public class GenderFilter
{

    /**
     * This method show all competitions of female.
     *
     * @return String in format Json Pretty with competitions of female.
     */
    public String getCompetitionsFemale(List<Competition> competitionList) throws StatsBombException
    {
        // Result
        String jsonCompetitionsFemale = "";

        List<Competition> competitionListFemale = new ArrayList<>();

        // Filter Competitions, search competitions of female
        for (Competition competition : competitionList)
        {
            if (competition.getCompetition_gender().equalsIgnoreCase("female"))
            {
                competitionListFemale.add(competition);
            }
        }

        // Convert List to Json Format
        JsonUtils jsonUtils = new JsonUtils();

        jsonCompetitionsFemale = jsonUtils.writeObjectToJsonAsStringPretty(competitionListFemale);

        return jsonCompetitionsFemale;

    }

    /**
     * This method show all competitions of male.
     *
     * @return String in format Json Pretty with competitions of male.
     */
    public String getCompetitionsMale(List<Competition> competitionList) throws StatsBombException
    {
        // Result
        String jsonCompetitionsMale = "";

        List<Competition> competitionListMale = new ArrayList<>();

        // Filter Competitions, search competitions of female
        for (Competition competition : competitionList)
        {
            if (competition.getCompetition_gender().equalsIgnoreCase("male"))
            {
                competitionListMale.add(competition);
            }
        }

        // Convert List to Json Format
        JsonUtils jsonUtils = new JsonUtils();

        jsonCompetitionsMale = jsonUtils.writeObjectToJsonAsStringPretty(competitionListMale);

        return jsonCompetitionsMale;

    }

}
