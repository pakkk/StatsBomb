package es.iesjandula.statsbomb.competitions_stats;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import es.iesjandula.statsbomb.common.load_json.Json;
import es.iesjandula.statsbomb.common.load_json.JsonLoaderImpl;
import es.iesjandula.statsbomb.competitions_stats.gender.GenderFilter;
import es.iesjandula.statsbomb.competitions_stats.order.OrderFilter;
import es.iesjandula.statsbomb.models.competition.Competition;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Neil Hdez
 *
 * In this class we create the filter and statistics for Json Competitions.
 */
public class CompetitionsStats
{

    /**
     * Return list with all competitions in json StatsBomb
     *
     * @return List of Competitions
     */
    protected List<Competition> getListCompetitions()
    {

        JsonLoaderImpl jsonLoader = new JsonLoaderImpl();
        String jsonCompetitions = jsonLoader.loadCompetitions();
        ObjectMapper mapper = Json.mapper();
        List<Competition> competitionList = new ArrayList<>();

        try
        {
            competitionList = mapper.readValue(jsonCompetitions, new TypeReference<List<Competition>>(){});
        }
        catch (IOException ioException)
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
        OrderFilter orderFilter = new OrderFilter();
        return orderFilter.getCompetitionsAlphabeticalOrder(getListCompetitions());
    }


    /**
     * This method show all competitions of female.
     *
     * @return String in format Json Pretty with competitions of female.
     */
    public String getCompetitionsFemale()
    {
        GenderFilter genderFilter = new GenderFilter();
        return genderFilter.getCompetitionsFemale(getListCompetitions());
    }

    /**
     * This method show all competitions of male.
     *
     * @return String in format Json Pretty with competitions of male.
     */
    public String getCompetitionsMale()
    {
        GenderFilter genderFilter = new GenderFilter();
        return genderFilter.getCompetitionsMale(getListCompetitions());
    }

}
