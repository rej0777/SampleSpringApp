package recipeapp.repositories;

import org.springframework.data.repository.CrudRepository;

import recipeapp.model.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

	
}
