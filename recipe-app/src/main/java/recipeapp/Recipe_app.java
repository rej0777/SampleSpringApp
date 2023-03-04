package recipeapp;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.data.repository.RepositoryDefinition;



@EntityScan("recipeapp.model")
@SpringBootApplication(scanBasePackages={"recipeapp.controllers","recipeapp.repositories", "recipeapp.bootstrap","recipeapp.service"})

public class Recipe_app {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	SpringApplication.run(Recipe_app.class, args);
		

		 ApplicationContext ctx = SpringApplication.run(Recipe_app.class, args);
        
	        System.out.println("Inspecting the beans");
	           
	        String[] beans = ctx.getBeanDefinitionNames();
	        Arrays.sort(beans);
	        for (String name : beans) {
	            System.out.println("Bean Name " +name);
	        }
	}

}
