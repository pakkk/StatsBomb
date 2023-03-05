package es.iesjandula.statsbomb.threesixty_rest.stats;



import es.iesjandula.statsbomb.threesixty_rest.stats.sort.SortFilter;
import es.iesjandula.statsbomb.threesixty_rest.stats.teammate.TeammateFilter;
import es.iesjandula.statsbomb.threesixty_rest.stats.utils.ThreeSixtyUtils;

import es.iesjandula.statsbomb.common.exception.StatsBombException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * In this class we create the list for the Json Three Sixty
 * 
 * @author Manuel Canio Gil
 * @version 1.0.0
 * @since 21-12-2022
 */
@Service
public class ThreeSixtyStats 
{
    @Autowired
    private ThreeSixtyUtils threeSixtyUtils;

    /**
     * This method return a list order of the three sixties by the match id
     * @param matchId
     * @return A String with the list of the three sixties ordered
     * @throws StatsBombException
     */
    public String getThreeSixtyListOrder(int matchId) throws StatsBombException
    {
        SortFilter sortFilter = new SortFilter();
        return sortFilter.getThreeSixtySorted(threeSixtyUtils.getListThreeSixtyByDataBase(matchId));
    }
    /**
     * This method return a list of the number of the teammates corresponding of the event_uuid
     * @param matchId
     * @return A String with the list of the number of the teammates
     * @throws StatsBombException
     */
    public String getTeammatesOfThreeSixty(int matchId) throws StatsBombException
    {
        TeammateFilter teammateFilter = new TeammateFilter();
        return teammateFilter.getTeammateThreeSixty(threeSixtyUtils.getListThreeSixtyByDataBase(matchId));
    }
}
