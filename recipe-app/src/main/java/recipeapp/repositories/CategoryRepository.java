package recipeapp.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import recipeapp.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	
	Optional<Category>findByDescription(String description);

}
