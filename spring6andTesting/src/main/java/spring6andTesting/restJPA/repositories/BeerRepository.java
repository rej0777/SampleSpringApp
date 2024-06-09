package spring6andTesting.restJPA.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import spring6andTesting.restJPA.entities.Beer;

public interface BeerRepository extends JpaRepository<Beer, UUID> {

}
