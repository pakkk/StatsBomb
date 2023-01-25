package es.iesjandula.statsbomb.matches_rest;

import es.iesjandula.statsbomb.matches_rest.rest.RestHandlerMatches;
import org.springframework.boot.SpringApplication ;
import org.springframework.boot.autoconfigure.SpringBootApplication ;
import org.springframework.context.annotation.ComponentScan ;
import org.springframework.context.annotation.Configuration ;

/**
 * This class starts the application
 */
@SpringBootApplication
@Configuration
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
