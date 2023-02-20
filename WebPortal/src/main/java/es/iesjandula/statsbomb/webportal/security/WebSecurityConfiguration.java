package es.iesjandula.statsbomb.webportal.security;

import es.iesjandula.statsbomb.webportal.security.users.MyUserDetalisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration
{

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private MyUserDetalisService userDetailsService;


    @Bean
    public DaoAuthenticationProvider authenticationProvider()
    {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(bCryptPasswordEncoder);
        return authProvider;
    }


    @Bean
    public SecurityFilterChain filterChain(final HttpSecurity http) throws Exception
    {
        http
                .csrf().disable()

                .authorizeHttpRequests()
                .requestMatchers("/resources/**", "/audio/**", "/bootstrap-5.3.0-alpha1-dist/**", "/css/**", "/img/**", "/js/**", "/video/**").permitAll()
                .requestMatchers("/login").permitAll()
                .requestMatchers("/register").permitAll()
                .requestMatchers("/", "/index").permitAll()

                // AQUI DEBEN DE IR LA SEGURIDAD
                .requestMatchers("/who_we_are", "/what_we_do", "/statistics", "/about_us", "/lista_endpoint").hasAnyAuthority("USER", "ADMIN")
                // Y BORRAR ESTA LINEA QUE DA PERIMSOS A TODOS

                .and().formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/", true)
                .usernameParameter("user_name")
                .passwordParameter("password")
                .and().logout().logoutSuccessUrl("/login");
        return http.build();
    }



}
