package com.microservice.contacts.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
@SuppressWarnings("unused")
public class DBConfiguration {
	
	private String driverClassName;
	private String url;
	private String username;
	private String password;
	
	@Profile("prod")
	@Bean
	public String devDatabaseConnection() {
		System.out.println("database connection for dev - Mysql");
		System.out.println(driverClassName);
		System.out.println(url);
		return "DB connection for dev - Mysql";
	}
	
	@Profile("dev")
	@Bean
	public String testDatabaseConnection() {
		System.out.println("database connection to RDS-test - low cost Instance");
		System.out.println(driverClassName);
		System.out.println(url);
		return "database connection to RDS-test - low cost Instance";
	}

	
}

