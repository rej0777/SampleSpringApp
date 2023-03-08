package recipeapp.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import recipeapp.model.Recipe;
import recipeapp.repositories.RecipeRepository;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService{

	private final RecipeRepository recipeRepository;

	public RecipeServiceImpl(RecipeRepository recipeRepository) {
		//super();
		this.recipeRepository = recipeRepository;
	}

	@Override
	public Set<Recipe> getRecipe() {
		log.debug("funkcja web getRecipe");
		Set<Recipe>recipeSet=new HashSet<>();
		recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);		
		return recipeSet;
	}
	
	

}
