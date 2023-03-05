package es.iesjandula.statsbomb.threesixty_rest.rest;

import es.iesjandula.statsbomb.common.exception.StatsBombException;
import es.iesjandula.statsbomb.threesixty_rest.stats.ThreeSixtyStats;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ------------------------------------------------
 * 
 * @author API Rest Generator
 * ------------------------------------------------
 */
@RequestMapping(value = "/threeSixty", produces = {"application/json"})
@RestController
public class RestHandlerThreeSixty 
{

    /**
     * Logger
     */
    private final Logger LOGGER = LogManager.getLogger();

    //New Instance of the Three Sixty
    @Autowired
    private ThreeSixtyStats threesixty_stats;

    /**
     * This endpoint return the list of the three sixties in order by the event_uuid
     * 
     * @return Json of three sixties in order
     */
    @RequestMapping(method = RequestMethod.GET, value = "/order")
    public ResponseEntity<?> getThreeSixtyListOrder(@RequestParam(value = "matchId", required = true) final Integer matchId)
    {
        try 
        {
            String resultJson = this.threesixty_stats.getThreeSixtyListOrder(matchId);
            return ResponseEntity.ok().body(resultJson);
        } 
        catch (StatsBombException statsBombException) 
        {
            return ResponseEntity.status(500).body(statsBombException.getBodyExceptionMessage());
        }
        catch (Exception exception)
        {
            StatsBombException statsBombException = new StatsBombException();
            LOGGER.error(statsBombException.getBodyExceptionMessage(), exception);
            return ResponseEntity.status(590).body(statsBombException.getBodyExceptionMessage());
        }
    }
    /**
     * This endpoint return the list of the number of the teammates corresponding the event_uuid
     * 
     * @return Json of the number of the teammates with the event_uuid
     */
    @RequestMapping(method = RequestMethod.GET, value = "/teammates")
    public ResponseEntity<?> getTeammatesOfThreeSixty(@RequestParam(value = "matchId", required = true) final Integer matchId)
    {
        try 
        {
            String resultJson = this.threesixty_stats.getTeammatesOfThreeSixty(matchId);
            return ResponseEntity.ok().body(resultJson);
        } 
        catch (StatsBombException statsBombException) 
        {
            return ResponseEntity.status(500).body(statsBombException.getBodyExceptionMessage());
        }
        catch (Exception exception)
        {
            StatsBombException statsBombException = new StatsBombException();
            LOGGER.error(statsBombException.getBodyExceptionMessage(), exception);
            return ResponseEntity.status(590).body(statsBombException.getBodyExceptionMessage());
        }
    }


}
