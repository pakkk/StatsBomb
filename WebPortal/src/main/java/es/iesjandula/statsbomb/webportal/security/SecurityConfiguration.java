package es.iesjandula.statsbomb.webportal.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Neil Hdez
 * @version 1.0.0
 * @since 17/02/2023
 */
@Configuration
public class SecurityConfiguration
{

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
