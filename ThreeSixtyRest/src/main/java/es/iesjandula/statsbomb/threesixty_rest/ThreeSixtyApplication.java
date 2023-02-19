package es.iesjandula.statsbomb.threesixty_rest;

import es.iesjandula.statsbomb.threesixty_rest.stats.utils.ThreeSixtyUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
@SpringBootApplication(scanBasePackages = {"es.iesjandula"})
@EntityScan(basePackages = {"es.iesjandula.statsbomb.models.three_sixty"})
@Configuration
@EnableDiscoveryClient
public class ThreeSixtyApplication implements CommandLineRunner
{

    @Autowired
    private Environment environment ;

    @Autowired
    private ThreeSixtyUtils threeSixtyUtils;

    /**
     * Main method
     * @param args with arguments
     */
    public static void main(String[] args)
    {
        SpringApplication.run(ThreeSixtyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception
    {

        String loadDatabase = this.environment.getProperty("statsbomb.loadDatabase") ;

        if (loadDatabase != null && Boolean.parseBoolean(loadDatabase))
        {
            this.threeSixtyUtils.insertThreeSixtyUtilsInDataBase();
        }
    }
}
