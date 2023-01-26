package es.iesjandula.statsbomb.competitions_rest;

import es.iesjandula.statsbomb.competitions_rest.stats.utils.CompetitionUtils;
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
@SpringBootApplication // Esta anotación es para los Autowired, para que encuentre las clases
@EntityScan(basePackages = {"es.iesjandula.statsbomb.models.competition"}) // Esta es para que encuentre los @Entity
@Configuration
public class Launcher implements CommandLineRunner
{
    @Autowired
    private Environment environment;

    @Autowired
    private CompetitionUtils competitionUtils;

    /**
     * Main method
     *
     * @param args with the input arguments
     */
    public static void main(String[] args)
    {
        SpringApplication.run(Launcher.class, args);
    }

    @Override
    public void run(String... args) throws Exception
    {
        String loadDatabase = this.environment.getProperty("statsbomb.loadDatabase");

        if (loadDatabase != null && Boolean.parseBoolean(loadDatabase))
        {
            this.competitionUtils.insertCompetitionsInDataBase();
        }
    }
}
