package aplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

import pet_clinic_web.ComonUtil1;
import pet_clinic_web.ThymeleafConfiguration;


@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages={"pet_clinic_web" , "pet_clinic_data", "recipe-app"})
@Import({ ThymeleafConfiguration.class})
public class Aplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ComonUtil1.getAPPName());
		SpringApplication.run(Aplication.class, args);
	}

}
