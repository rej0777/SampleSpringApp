package recipeapp.service;

/*

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import recipeapp.model.Recipe;
import recipeapp.repositories.RecipeRepository;
*/


	public class RecipeServiceImplTest {
/*		
				
				
	    RecipeServiceImpl recipeService;

	    @Mock
	    RecipeRepository recipeRepository;

	//    @Mock RecipeToRecipeCommand recipeToRecipeCommand;

	//    @Mock   RecipeCommandToRecipe recipeCommandToRecipe;

	    @Before
	    public void setUp() throws Exception {
	        MockitoAnnotations.initMocks(this);

	        recipeService = new RecipeServiceImpl(recipeRepository);//, recipeCommandToRecipe, recipeToRecipeCommand
	    }

	    @Test
	    public void getRecipeByIdTest() throws Exception {
	        Recipe recipe = new Recipe();
	        recipe.setId(1L);
	        Optional<Recipe> recipeOptional = Optional.of(recipe);

	        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

	        Recipe recipeReturned = recipeService.findById(1L);

	        assertNotNull("Null recipe returned", recipeReturned);
	        verify(recipeRepository, times(1)).findById(anyLong());
	        verify(recipeRepository, never()).findAll();
	    }

	    @Test
	    public void getRecipesTest() throws Exception {

	        Recipe recipe = new Recipe();
	        HashSet<Recipe> receipesData = new HashSet<Recipe>();
	        receipesData.add(recipe);

	        when(recipeService.getRecipes()).thenReturn(receipesData);

	        Set<Recipe> recipes = recipeService.getRecipes();

	        assertEquals(recipes.size(), 1);
	        verify(recipeRepository, times(1)).findAll();
	        verify(recipeRepository, never()).findById(anyLong());
	    }
*/
	}
