package es.iesjandula.statsbomb.events_rest;

import es.iesjandula.statsbomb.events_rest.rest.RestHandlerEvents;
import org.springframework.boot.SpringApplication ;
import org.springframework.boot.autoconfigure.SpringBootApplication ;
import org.springframework.context.annotation.ComponentScan ;
import org.springframework.context.annotation.Configuration ;

/**
 * This class starts the application
 */
@SpringBootApplication
@Configuration
@ComponentScan(basePackageClasses = {RestHandlerEvents.class})
public class Launcher
{

    /**
     * Main method
     * @param args with the input arguments
     */
    public static void main(String[] args)
    {
        SpringApplication.run(Launcher.class, args) ;
    }
}
