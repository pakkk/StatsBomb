package es.iesjandula.statsbomb.matches_rest.stats;

import es.iesjandula.statsbomb.common.exception.StatsBombException;
import es.iesjandula.statsbomb.matches_rest.stats.date.DateFilter;
import es.iesjandula.statsbomb.matches_rest.stats.utils.MatchesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author Neil Hdez
 * @author Aljarilla11
 * @author Joaquin Moreno
 */
@Service
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
        return dateFilter.getListMatchesByDate(matchesUtils.getMatches(competitionId,seasonId), dateStart);
    }
    


}
