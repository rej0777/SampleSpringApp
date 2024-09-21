package spring6andTesting.restJPA.mappers;

import org.mapstruct.Mapper;
import org.springframework.context.annotation.Configuration;

import spring6andTesting.restJPA.entities.Customer;
import spring6andTesting.restJPA.model.CustomerDTO;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

	Customer customerDtoToCustomer(CustomerDTO dto);
	CustomerDTO customerToCustomerDto(Customer customer);
}
