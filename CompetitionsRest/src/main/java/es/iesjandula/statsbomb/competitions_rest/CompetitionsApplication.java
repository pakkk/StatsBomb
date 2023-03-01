package es.iesjandula.statsbomb.competitions_rest;

import es.iesjandula.statsbomb.competitions_rest.stats.utils.CompetitionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * This class starts the application
 */
@SpringBootApplication
@EntityScan(basePackages = {"es.iesjandula.statsbomb.models.competition"})
@Configuration
@EnableDiscoveryClient
public class CompetitionsApplication implements CommandLineRunner
{
    @Autowired
    private Environment environment;

    @Value("${statsbomb.loadDatabase}")
    private boolean loadDatabase;

    @Autowired
    private CompetitionUtils competitionUtils;

    /**
     * Main method
     *
     * @param args with the input arguments
     */
    public static void main(String[] args)
    {
        SpringApplication.run(CompetitionsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception
    {
        if (loadDatabase)
        {
            this.competitionUtils.insertCompetitionsInDataBase();
        }
    }
}
