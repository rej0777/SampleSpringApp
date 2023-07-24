package recipeapp.service;

import java.util.Set;

import recipeapp.model.Recipe;

public interface RecipeService {

	Set<Recipe> getRecipes();

	Recipe findById(Long l);
}
