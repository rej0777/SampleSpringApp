package recipeapp.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import recipeapp.model.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

	Optional<UnitOfMeasure> findByDescription(String description);
}
