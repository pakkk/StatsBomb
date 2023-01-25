package es.iesjandula.statsbomb.matches_rest;

import es.iesjandula.statsbomb.matches_rest.stats.utils.MatchesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;


/**
 * This class starts the application
 */
@SpringBootApplication(scanBasePackages = {"es.iesjandula"})
@EntityScan(basePackages = {"es.iesjandula.statsbomb.models.matches"})
@Configuration
public class Launcher implements CommandLineRunner
{

    @Autowired
    private MatchesUtils matchesUtils;

    @Autowired
    private Environment environment;

    /**
     * Main method
     * @param args with the input arguments
     */
    public static void main(String[] args)
    {
        SpringApplication.run(Launcher.class, args) ;
    }

    @Override
    public void run(String... args) throws Exception
    {
        String loadDatabase = this.environment.getProperty("statsbomb.loadDatabase") ;
        if (loadDatabase != null && Boolean.parseBoolean(loadDatabase))
        {
            this.matchesUtils.insertMatchesInDataBase();
        }
    }
}
