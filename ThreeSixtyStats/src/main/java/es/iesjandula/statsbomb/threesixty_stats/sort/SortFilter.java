package es.iesjandula.statsbomb.threesixty_stats.sort;

import java.util.Comparator;
import java.util.List;

import es.iesjandula.statsbomb.common.exception.StatsBombException;
import es.iesjandula.statsbomb.common.utils.JsonUtils;
import es.iesjandula.statsbomb.models.three_sixty.ThreeSixty;

/**
 * @author Manuel Canio Gil
 */
public class SortFilter 
{
    /**
     * This method sorts the list of three sixty data order by the event_uuid
     * @param threeSixtyList
     * @return String in format Json Pretty with the list of three sixties order by the event_uuid
     * @throws StatsBombException to the writeObjectToJsonAsStringPretty
     */
    public String getThreeSixtySorted(List<ThreeSixty> threeSixtyList) throws StatsBombException
    {
        //Result
        String jsonThreeSixtyOrder = "";
        //Order the list
        threeSixtyList.sort(Comparator.comparing(ThreeSixty::getEvent_uuid));
        //Convert the list to the Json Format
        JsonUtils jsonUtils = new JsonUtils();
        //Write the result in the Pretty Format
        jsonThreeSixtyOrder = jsonUtils.writeObjectToJsonAsStringPretty(threeSixtyList);

        return jsonThreeSixtyOrder;
    }
}
