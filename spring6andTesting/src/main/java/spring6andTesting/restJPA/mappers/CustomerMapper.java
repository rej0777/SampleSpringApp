package spring6andTesting.restJPA.mappers;

import org.mapstruct.Mapper;

import spring6andTesting.restJPA.entities.Customer;
import spring6andTesting.restJPA.model.CustomerDTO;

@Mapper
public interface CustomerMapper {

	Customer  customerDtoToCustomer(CustomerDTO dto);
	CustomerDTO CustomerToCustomerDto(Customer customer);
}
