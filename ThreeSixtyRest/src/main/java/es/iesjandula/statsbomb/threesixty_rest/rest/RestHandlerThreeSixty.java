package es.iesjandula.statsbomb.threesixty_rest.rest;

import es.iesjandula.statsbomb.threesixty_stats.ThreeSixtyStats;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * ------------------------------------------------
 * 
 * @author API Rest Generator
 * ------------------------------------------------
 */
@RequestMapping(value = "/", produces = {"application/json"})
@RestController
public class RestHandlerThreeSixty 
{
    //New Instance of the Three Sixty
    private final ThreeSixtyStats threesixty_stats = this.getThreeSixtyStats();

    @Bean
    public ThreeSixtyStats getThreeSixtyStats()
    {
        return new ThreeSixtyStats();
    }
}
