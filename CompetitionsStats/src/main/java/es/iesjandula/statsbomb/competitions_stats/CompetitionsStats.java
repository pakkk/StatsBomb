package es.iesjandula.statsbomb.competitions_stats;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import es.iesjandula.statsbomb.common.load_json.Json;
import es.iesjandula.statsbomb.common.load_json.JsonLoaderImpl;
import es.iesjandula.statsbomb.models.competition.Competition;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Neil Hdez
 * <p>
 * In this class we create the filter and statistics for Json Competitions.
 */
public class CompetitionsStats
{

    /**
     * Return list with all competitions in json StatsBomb
     *
     * @return List of Competitions
     */
    private List<Competition> getListCompetitions()
    {

        JsonLoaderImpl jsonLoader = new JsonLoaderImpl();
        String jsonCompetitions = jsonLoader.loadCompetitions();
        ObjectMapper mapper = Json.mapper();
        List<Competition> competitionList = new ArrayList<>();

        try
        {
            competitionList = mapper.readValue(jsonCompetitions, new TypeReference<List<Competition>>()
            {
            });

        } catch (IOException ioException)
        {
            ioException.printStackTrace();
        }

        return competitionList;

    }

    /**
     * This method sorts the competitions in ascending alphabetical order by name.
     *
     * @return String in format Json Pretty with competitions order by name
     */
    public String getCompetitionsAlphabeticalOrder()
    {
        // List of competitions from Statsbomb
        List<Competition> competitionList = this.getListCompetitions();
        // Result
        String jsonCompetitionsAlphabeticalOrder = "";

        // Order the list
        competitionList.sort(Comparator.comparing(Competition::getCompetition_name));

        try
        {
            // Write Result in Pretty Format
            jsonCompetitionsAlphabeticalOrder = Json.mapper().writerWithDefaultPrettyPrinter().writeValueAsString(competitionList);
        } catch (JsonProcessingException jsonProcessingException)
        {
            jsonProcessingException.printStackTrace();
        }

        return jsonCompetitionsAlphabeticalOrder;
    }

    /**
     * This method show all competitions of female.
     *
     * @return String in format Json Pretty with competitions of female.
     */
    public String getCompetitionsFemale()
    {
        List<Competition> competitionList = this.getListCompetitions();
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

        try
        {
            // Write Result Pretty Format
            jsonCompetitionsFemale = Json.mapper().writerWithDefaultPrettyPrinter().writeValueAsString(competitionListFemale);
        } catch (JsonProcessingException jsonProcessingException)
        {
            jsonProcessingException.printStackTrace();
        }

        return jsonCompetitionsFemale;

    }


}
