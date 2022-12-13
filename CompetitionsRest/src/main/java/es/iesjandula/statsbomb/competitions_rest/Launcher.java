package es.iesjandula.statsbomb.competitions_rest;

import es.iesjandula.statsbomb.competitions_rest.rest.RestHandlerCompetition;
import org.springframework.boot.SpringApplication ;
import org.springframework.boot.autoconfigure.SpringBootApplication ;
import org.springframework.context.annotation.ComponentScan ;
import org.springframework.context.annotation.Configuration ;

/**
 * This class starts the application
 */
@SpringBootApplication
@Configuration
@ComponentScan(basePackageClasses = {RestHandlerCompetition.class})
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
