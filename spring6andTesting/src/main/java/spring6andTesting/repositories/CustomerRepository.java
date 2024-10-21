package spring6andTesting.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import spring6andTesting.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {

}
