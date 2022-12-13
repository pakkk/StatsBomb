package es.iesjandula.statsbomb.competitions_rest.rest;

import es.iesjandula.statsbomb.competitions_stats.CompetitionsStats;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * ------------------------------------------------
 * @author API Rest Generator
 * ------------------------------------------------
 */
@RequestMapping(value = "/", produces = {"application/json"})
@RestController //
public class RestHandlerCompetition
{

    private CompetitionsStats competitionsStats = this.getCompetitionsStats(); // Clase Estadisticas Competitions

    @RequestMapping(method = RequestMethod.GET, value = "/competitions/order"	)
    public ResponseEntity<?> getCompetitionsAlphabeticalOrder()
    {
        int status = 0;

        String resultJson = this.competitionsStats.getCompetitionsalphabeticalOrder();
        status = 200;

        return ResponseEntity.status(200).body(resultJson);

    }

    @Bean
    public CompetitionsStats getCompetitionsStats()
    {
        return new CompetitionsStats() ;
    }
}
