package spring6andTesting.mappers;

import org.mapstruct.Mapper;
import org.springframework.context.annotation.Configuration;

import spring6andTesting.entities.Customer;
import spring6andTesting.model.CustomerDTO;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

	Customer customerDtoToCustomer(CustomerDTO dto);
	CustomerDTO customerToCustomerDto(Customer customer);
}
