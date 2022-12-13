package es.iesjandula.statsbomb.competitions_stats;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import es.iesjandula.statsbomb.common.load_json.Json;
import es.iesjandula.statsbomb.common.load_json.JsonLoaderImpl;
import es.iesjandula.statsbomb.models.competition.Competition;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Neil Hdez
 *
 * In this class we create the filter and statistics for Json Competitions.
 */
public class CompetitionsStats
{

    /**
     * This method sorts the competitions in ascending alphabetical order by name.
     * @return String in format Json Pretty with competitions order by name
     */
    public String getCompetitionsAlphabeticalOrder() {

        JsonLoaderImpl jsonLoader = new JsonLoaderImpl();
        String jsonCompetitions = jsonLoader.loadCompetitions();
        ObjectMapper mapper = Json.mapper();
        String jsonCompetitionsAlphabeticalOrder = "";

        List<Competition> competitionList = new ArrayList<>();

        try
        {
            competitionList = mapper.readValue(jsonCompetitions, new TypeReference<List<Competition>>(){});

            Collections.sort(competitionList, Comparator.comparing(Competition::getCompetition_name));

            jsonCompetitionsAlphabeticalOrder = Json.mapper().writerWithDefaultPrettyPrinter().writeValueAsString(competitionList);

        } catch (IOException ioException)
        {
            ioException.printStackTrace();
        }

        return jsonCompetitionsAlphabeticalOrder;
    }

}
