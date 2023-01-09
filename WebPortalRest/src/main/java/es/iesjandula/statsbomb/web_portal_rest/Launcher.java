package es.iesjandula.statsbomb.web_portal_rest;

import org.springframework.boot.SpringApplication ;
import org.springframework.boot.autoconfigure.SpringBootApplication ;

/**
 * This class starts the application
 */
@SpringBootApplication
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
