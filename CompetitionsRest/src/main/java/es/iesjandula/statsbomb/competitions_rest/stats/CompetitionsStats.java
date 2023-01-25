package es.iesjandula.statsbomb.competitions_rest.stats;

import es.iesjandula.statsbomb.common.exception.StatsBombException;
import es.iesjandula.statsbomb.common.utils.JsonUtils;
import es.iesjandula.statsbomb.competitions_rest.stats.gender.GenderFilter;
import es.iesjandula.statsbomb.competitions_rest.stats.order.OrderFilter;
import es.iesjandula.statsbomb.competitions_rest.stats.utils.CompetitionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Neil Hdez
 *
 * In this class we create the filter and statistics for Json Competitions.
 */
@Service
public class CompetitionsStats
{
    /* Attribute - Logger */
    private final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private CompetitionUtils competitionUtils;


    /**
     * This method return All Competitions
     *
     * @return String in format Json Pretty with competitions
     * This filter it's different because it doesn't need a filter.
     * @throws StatsBombException
     */
    public String getCompetitions() throws StatsBombException
    {
        OrderFilter orderFilter = new OrderFilter();
        JsonUtils jsonUtils = new JsonUtils();
        return jsonUtils.writeObjectToJsonAsStringPretty(competitionUtils.getListCompetitions());
    }

    /**
     * This method sorts the competitions in ascending alphabetical order by name.
     *
     * @return String in format Json Pretty with competitions order by name
     * @throws StatsBombException
     */
    public String getCompetitionsAlphabeticalOrder() throws StatsBombException
    {
        OrderFilter orderFilter = new OrderFilter();
        return orderFilter.getCompetitionsAlphabeticalOrder(competitionUtils.getListCompetitions());
    }


    /**
     * This method show all competitions of female.
     *
     * @return String in format Json Pretty with competitions of female.
     * @throws StatsBombException
     */
    public String getCompetitionsFemale() throws StatsBombException
    {
        GenderFilter genderFilter = new GenderFilter();
        return genderFilter.getCompetitionsFemale(competitionUtils.getListCompetitions());
    }

    /**
     * This method show all competitions of male.
     *
     * @return String in format Json Pretty with competitions of male.
     * @throws StatsBombException
     */
    public String getCompetitionsMale() throws StatsBombException
    {
        GenderFilter genderFilter = new GenderFilter();
        return genderFilter.getCompetitionsMale(competitionUtils.getListCompetitions());
    }

}
