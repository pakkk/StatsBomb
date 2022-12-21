package es.iesjandula.statsbomb.threesixty_rest;

import es.iesjandula.statsbomb.threesixty_rest.rest.RestHandlerThreeSixty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * This class starts the application
 */
@SpringBootApplication
@Configuration
@ComponentScan(basePackageClasses = {RestHandlerThreeSixty.class})
public class Launcher 
{
    /**
     * Main method
     * @param args with arguments
     */
    public static void main(String[] args) 
    {
        SpringApplication.run(Launcher.class, args);    
    }    
}
