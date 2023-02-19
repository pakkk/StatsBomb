package es.iesjandula.statsbomb.webportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EntityScan("es.iesjandula.statsbomb.webportal.models.modelsSecurity")
@EnableDiscoveryClient
public class WebPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebPortalApplication.class, args);
	}

}
