package com.example.customerRM;

import com.example.customerRM.model.Routes;
import com.example.customerRM.repo.CustomerRepo;
import com.example.customerRM.repo.RouteRepo;
import com.example.customerRM.repo.SalesRepRepo;
import org.springframework.web.filter.CorsFilter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;


@SpringBootApplication
public class CustomerRmApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerRmApplication.class, args);
	}

	@Bean
	 CommandLineRunner run (CustomerRepo customerRepo, SalesRepRepo salesRepRepo, RouteRepo routeRepo){
		return args-> {
//			routeRepo.save(new Routes(null, "Route1", "Westlands", "Ruaka", "Kennedy"));
//			customerRepo.save(new Customer(null, "Kens butchery", "Sam", "0773682738", Male, 43.657, 34.6475, Chama.NO, Storage, SmallEnterprise, "Local Suppliers", "Chicken, Fish", 75, YES, PROSPECT));
//			salesRepRepo.save(new SalesRep(null, "Kennedy", Male, "0732903678"));
//			salesRepRepo.save(new SalesRep(null, "Adrian", Male, "0776983202"));
		};
	}

	@Bean
	public CorsFilter corsFilter(){
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:3000", "http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Jwt-Token", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Jwt-Token", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials", "Filename"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}

}
