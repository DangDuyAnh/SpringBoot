package com.example.dataconnect;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class DataConnectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DataConnectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}
}
