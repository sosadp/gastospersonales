package com.djsm.gastospersonales;

import com.djsm.gastospersonales.configuration.JpaConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Arrays;


@Import(JpaConfiguration.class)
@SpringBootApplication(scanBasePackages = {"com.djsm.gastospersonales"})
public class GastospersonalesApplication {

	public static void main(String[] args) {
		SpringApplication.run(GastospersonalesApplication.class, args);


	}


}
