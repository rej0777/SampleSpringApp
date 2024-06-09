package spring6andTesting.restJPA.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import spring6andTesting.restJPA.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {

}
