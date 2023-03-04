package recipeapp.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import recipeapp.model.Category;
import recipeapp.model.UnitOfMeasure;
import recipeapp.repositories.CategoryRepository;
import recipeapp.repositories.UnitOfMeasureRepository;
import recipeapp.service.RecipeService;

//@NoArgsConstructor
//@AllArgsConstructor
@Controller
@RequestMapping("/recipe")
public class IndexController {


private final RecipeService recipeService;
		
	public IndexController(RecipeService recipeService) {
	//super();
	this.recipeService = recipeService;
}



	//@RequestMapping({ "/recipe"})
	@GetMapping()
	public String getIndexPage(Model model) {
		System.out.println("##getRECIPE");
		model.addAttribute("recipes",  recipeService.getRecipe());
	
		return"recipe";
		
	}
}
