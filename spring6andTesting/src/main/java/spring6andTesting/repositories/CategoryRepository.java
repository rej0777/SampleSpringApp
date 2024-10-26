package spring6andTesting.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import spring6andTesting.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, UUID> {

}
