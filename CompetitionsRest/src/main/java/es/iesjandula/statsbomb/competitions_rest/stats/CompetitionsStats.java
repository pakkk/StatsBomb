package es.iesjandula.statsbomb.competitions_rest.stats;

import es.iesjandula.statsbomb.common.exception.StatsBombException;
import es.iesjandula.statsbomb.common.utils.JsonUtils;
import es.iesjandula.statsbomb.competitions_rest.stats.gender.GenderFilter;
import es.iesjandula.statsbomb.competitions_rest.stats.id.IdFilter;
import es.iesjandula.statsbomb.competitions_rest.stats.order.OrderFilter;
import es.iesjandula.statsbomb.competitions_rest.stats.utils.CompetitionUtils;
import es.iesjandula.statsbomb.competitions_rest.stats.utils.ICompetitionRepository;
import es.iesjandula.statsbomb.competitions_rest.stats.web_filter.WebFilter;
import es.iesjandula.statsbomb.models.competition.Competition;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Neil Hdez
 * @author Manuel Canio Gil
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

    @Autowired
    private ICompetitionRepository iCompetitionRepository;


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

    public Competition getCompetitionsOfDataBaseById(int competitionId) throws StatsBombException
    {
        return iCompetitionRepository.findByCompetition_id(competitionId);
    }

    public List<Competition> getCompetitionsOfDataBase() throws StatsBombException
    {
        return iCompetitionRepository.findAll();
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
        return orderFilter.getCompetitionsAlphabeticalOrder(getCompetitionsOfDataBase());
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
        return genderFilter.getCompetitionsFemale(getCompetitionsOfDataBase());
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
        return genderFilter.getCompetitionsMale(getCompetitionsOfDataBase());
    }
    
    /**
     * This method show all competitions id
     * 
     * @return String in format Json Pretty with competitions id.
     * @throws StatsBombException
     */
    public String getCompetitionsId() throws StatsBombException
    {
        IdFilter idFilter = new IdFilter();
        return idFilter.getCompetitionsId(getCompetitionsOfDataBase());
    }

    /**
     * This method show all competitions name and season name
     *
     * @return String in format Json Pretty with competitions id.
     * @throws StatsBombException
     */
    public String getCompetitionsNameAndSeasonName() throws StatsBombException
    {
        WebFilter webFilter = new WebFilter();
        return webFilter.getCompetitionsNameAndSeasonName(getCompetitionsOfDataBase());
    }
}
