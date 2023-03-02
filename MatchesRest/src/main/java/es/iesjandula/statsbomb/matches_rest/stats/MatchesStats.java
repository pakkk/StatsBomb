package es.iesjandula.statsbomb.matches_rest.stats;

import es.iesjandula.statsbomb.matches_rest.stats.id_filter.MatchesIdFilter;
import es.iesjandula.statsbomb.models.matches.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import es.iesjandula.statsbomb.common.exception.StatsBombException;
import es.iesjandula.statsbomb.matches_rest.stats.date.DateFilter;
import es.iesjandula.statsbomb.matches_rest.stats.matches_result_filters.MatchesFilter;
import es.iesjandula.statsbomb.matches_rest.stats.utils.MatchesUtils;

import java.util.List;


/**
 * @author Neil Hdez
 * @author Aljarilla11
 * @author Joaquin Moreno
 * @author Manuel Martin
 */
@Service
@Component
public class MatchesStats
{
    @Autowired
    private MatchesUtils matchesUtils;

    /**
     * Call of Filter
     * @param competitionId Competition
     * @param seasonId Season
     * @return a list of Matches
     * @throws StatsBombException
     */
    public String getListOfMatchesByDate(int competitionId,int seasonId,String dateStart) throws StatsBombException
    {
        DateFilter dateFilter = new DateFilter();
        List<Match> matchList = matchesUtils.getMatchesByDataBase(competitionId,seasonId);
        return dateFilter.getListMatchesByDate(matchList, dateStart);
    }
    
    public String getResultsMatches(int competitionId,int seasonId) throws StatsBombException
    {
    	MatchesFilter matchesFilter = new MatchesFilter();
        List<Match> matchList = matchesUtils.getMatchesByDataBase(competitionId,seasonId);
        return matchesFilter.getResultsMatches(matchList);
    }

    public String getMatchesId(int competitionId,int seasonId) throws StatsBombException
    {
        MatchesIdFilter matchesIdFilter = new MatchesIdFilter();
        List<Match> matchList = matchesUtils.getMatchesByDataBase(competitionId,seasonId);
        return matchesIdFilter.getMatchesId(matchList);

    }
}
