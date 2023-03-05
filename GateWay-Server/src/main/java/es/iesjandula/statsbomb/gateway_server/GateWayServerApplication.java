package es.iesjandula.statsbomb.gateway_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GateWayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GateWayServerApplication.class, args);
	}

}
