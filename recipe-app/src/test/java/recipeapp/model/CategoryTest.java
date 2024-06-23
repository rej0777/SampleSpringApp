package recipeapp.model;

import static org.junit.jupiter.api.Assertions.*;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;

class CategoryTest {
	
	Category category;
//Category category = new Category();

@Before(value = "")
	public void setUp() {
		
	}
	
	@Test
	void testGetId() {
		Long idValiue = 4L;
		category.setId(idValiue);
		assertEquals(idValiue, category.getId());
		//fail("Not yet implemented");
	}

	@Test
	void testGetDescription() {
		
		//fail("Not yet implemented");
	}

	@Test
	void testGetRecipes() {
		//fail("Not yet implemented");
	}

}
