package com.djsm.gastospersonales;

import com.djsm.gastospersonales.configuration.JpaConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;



import java.util.Arrays;


@Import(JpaConfiguration.class)
@SpringBootApplication(scanBasePackages = {"com.djsm.gastospersonales"})
public class GastospersonalesApplication {

	public static void main(String[] args) {
		SpringApplication.run(GastospersonalesApplication.class, args);


	}


}
