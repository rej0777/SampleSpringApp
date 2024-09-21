package spring6andTesting.restJPA.mappers;

import org.mapstruct.Mapper;
import org.springframework.context.annotation.Configuration;

import spring6andTesting.restJPA.entities.Beer;
import spring6andTesting.restJPA.model.BeerDTO;


@Mapper(componentModel = "spring")
public interface BeerMapper {

	Beer beerDtoToBeer(BeerDTO dto);
	BeerDTO beerToBeerDto(Beer beer);
}
