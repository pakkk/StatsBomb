package es.iesjandula.statsbomb.events_rest;

import es.iesjandula.statsbomb.events_rest.rest.RestHandlerEvents;
import es.iesjandula.statsbomb.events_rest.stats.utils.EventUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication ;
import org.springframework.boot.autoconfigure.SpringBootApplication ;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan ;
import org.springframework.context.annotation.Configuration ;
import org.springframework.core.env.Environment;

/**
 * This class starts the application
 */
@SpringBootApplication(scanBasePackages = {"es.iesjandula"})
@EntityScan(basePackages = {"es.iesjandula.statsbomb.models.events"})
@Configuration
public class Launcher implements CommandLineRunner
{

    @Autowired
    private EventUtils eventUtils;

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
    public void run(String... args) throws Exception {

        String loadDatabase = this.environment.getProperty("statsbomb.loadDatabase") ;
        if (loadDatabase != null && Boolean.parseBoolean(loadDatabase))
        {
            this.eventUtils.insertEventsInDataBase();
        }

    }
}
