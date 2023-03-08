package es.iesjandula.statsbomb.competitions_rest.rest;


import es.iesjandula.statsbomb.common.exception.StatsBombException;
import es.iesjandula.statsbomb.common.utils.JsonUtils;
import es.iesjandula.statsbomb.competitions_rest.stats.CompetitionsStats;
import es.iesjandula.statsbomb.competitions_rest.stats.utils.CompetitionUtils;
import es.iesjandula.statsbomb.models.competition.Competition;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * ------------------------------------------------
 *
 * @author API Rest Generator
 * ------------------------------------------------
 */
@RequestMapping(value = "/competitions", produces = {"application/json"}) // 8081
@RestController //
public class RestHandlerCompetition
{

    /**
     * Logger
     */
    private final Logger LOGGER = LogManager.getLogger();

    // New Instance of CompetitionStats
    @Autowired
    private CompetitionsStats competitionsStats ;

    /**
     * This endPoint return all the competitions
     *
     * @return Json of competitions in order ascending
     */
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ResponseEntity<?> getCompetitions()
    {

        JsonUtils jsonUtils;

        try
        {
            jsonUtils = new JsonUtils();

            List<Competition> competitionList = this.competitionsStats.getCompetitionsOfDataBase();

            String resultJson = jsonUtils.writeObjectToJsonAsStringPretty(competitionList);

            return ResponseEntity.ok().body(resultJson);
        }
        catch (StatsBombException statsBombException)
        {
            return ResponseEntity.status(500).body(statsBombException.getBodyExceptionMessage());
        }
        catch (Exception exception)
        {
            StatsBombException statsBombException = new StatsBombException(exception);
            LOGGER.error(statsBombException.getBodyExceptionMessage(), exception);
            return ResponseEntity.status(590).body(statsBombException.getBodyExceptionMessage());
        }
    }

    /**
     * This endPoint return all the competitions in order ascending by competition_name
     *
     * @return Json of competitions in order ascending
     */
    @RequestMapping(method = RequestMethod.GET, value = "/alphabeticalOrder")
    public ResponseEntity<?> getCompetitionsAlphabeticalOrder()
    {

        try
        {
            String resultJson = this.competitionsStats.getCompetitionsAlphabeticalOrder();
            return ResponseEntity.ok().body(resultJson);
        }
        catch (StatsBombException statsBombException)
        {
            return ResponseEntity.status(500).body(statsBombException.getBodyExceptionMessage());
        }
        catch (Exception exception)
        {
            StatsBombException statsBombException = new StatsBombException(exception);
            LOGGER.error(statsBombException.getBodyExceptionMessage(), exception);
            return ResponseEntity.status(590).body(statsBombException.getBodyExceptionMessage());
        }
    }

    /**
     * This endpoint returns competitions that are played by women.
     *
     * @return Json of competitions played by women
     */
    @RequestMapping(method = RequestMethod.GET, value = "/gender/female")
    public ResponseEntity<?> getCompetitionsFemale()
    {
        try
        {
            String resultJson = this.competitionsStats.getCompetitionsFemale();

            return ResponseEntity.ok().body(resultJson);
        }
        catch (StatsBombException statsBombException)
        {
            return ResponseEntity.status(500).body(statsBombException.getBodyExceptionMessage());
        }
        catch (Exception exception)
        {
            StatsBombException statsBombException = new StatsBombException(exception);
            LOGGER.error(statsBombException.getBodyExceptionMessage(), exception);
            return ResponseEntity.status(590).body(statsBombException.getBodyExceptionMessage());
        }
    }

    /**
     * This endpoint returns competitions that are played by men.
     *
     * @return Json of competitions played by women
     */
    @RequestMapping(method = RequestMethod.GET, value = "/gender/male")
    public ResponseEntity<?> getCompetitionsMale()
    {

        try
        {
            String resultJson = this.competitionsStats.getCompetitionsMale();
            return ResponseEntity.ok().body(resultJson);
        }
        catch (StatsBombException statsBombException)
        {
            return ResponseEntity.status(500).body(statsBombException.getBodyExceptionMessage());
        }
        catch (Exception exception)
        {
            StatsBombException statsBombException = new StatsBombException(exception);
            LOGGER.error(statsBombException.getBodyExceptionMessage(), exception);
            return ResponseEntity.status(590).body(statsBombException.getBodyExceptionMessage());
        }
    }
    
    /**
     * This endpoint returns all competitions id
     * 
     * @return Json of competitions id
     */
    @RequestMapping(method=RequestMethod.GET, value="/id")
    public ResponseEntity<?> getCompetitionsId() 
    {
        try 
        {
            String resultJson = this.competitionsStats.getCompetitionsId();
            return ResponseEntity.ok().body(resultJson);    
        } 
        catch (StatsBombException statsBombException) 
        {
            return ResponseEntity.status(500).body(statsBombException.getBodyExceptionMessage());
        }
        catch (Exception exception)
        {
            StatsBombException statsBombException = new StatsBombException(exception);
            LOGGER.error(statsBombException.getBodyExceptionMessage(), exception);
            return ResponseEntity.status(590).body(statsBombException.getBodyExceptionMessage());
        }
    }

    /**
     * This endpoint returns all competitions season and name
     *
     * @return Json of competitions season and name
     */
    @RequestMapping(method=RequestMethod.GET, value="/web")
    public ResponseEntity<?> getCompetitionsSeasonName()
    {
        try
        {
            String resultJson = this.competitionsStats.getCompetitionsNameAndSeasonName();
            return ResponseEntity.ok().body(resultJson);
        }
        catch (StatsBombException statsBombException)
        {
            return ResponseEntity.status(500).body(statsBombException.getBodyExceptionMessage());
        }
        catch (Exception exception)
        {
            StatsBombException statsBombException = new StatsBombException(exception);
            LOGGER.error(statsBombException.getBodyExceptionMessage(), exception);
            return ResponseEntity.status(590).body(statsBombException.getBodyExceptionMessage());
        }
    }

}