package es.iesjandula.statsbomb.competitions_rest.stats.order;

import es.iesjandula.statsbomb.common.exception.StatsBombException;
import es.iesjandula.statsbomb.common.utils.JsonUtils;
import es.iesjandula.statsbomb.models.competition.Competition;

import java.util.Comparator;
import java.util.List;



/**
 * @author Neil Hdez
 */
public class OrderFilter
{
    /**
     * This method sorts the competitions in ascending alphabetical order by name.
     *
     * @return String in format Json Pretty with competitions order by name
     * @throws StatsBombException Exception to the writeObjectToJsonAsStringPretty
     */
    public String getCompetitionsAlphabeticalOrder(List<Competition> competitionList) throws StatsBombException
    {
        // Result
        String jsonCompetitionsAlphabeticalOrder = "";

        // Order the list
        competitionList.sort(Comparator.comparing(Competition::getCompetition_name));

        // Convert List to Json Format
        JsonUtils jsonUtils = new JsonUtils();
        // Write Result in Pretty Format
        jsonCompetitionsAlphabeticalOrder = jsonUtils.writeObjectToJsonAsStringPretty(competitionList);

        return jsonCompetitionsAlphabeticalOrder;
    }

}

