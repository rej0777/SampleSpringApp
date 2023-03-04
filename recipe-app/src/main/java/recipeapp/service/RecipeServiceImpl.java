package recipeapp.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import recipeapp.model.Recipe;
import recipeapp.repositories.RecipeRepository;

@Service
public class RecipeServiceImpl implements RecipeService{

	private final RecipeRepository recipeRepository;

	public RecipeServiceImpl(RecipeRepository recipeRepository) {
		//super();
		this.recipeRepository = recipeRepository;
	}

	@Override
	public Set<Recipe> getRecipe() {
		Set<Recipe>recipeSet=new HashSet<>();
		recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
		return recipeSet;
	}
	
	

}
