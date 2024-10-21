package spring6andTesting.mappers;

import org.mapstruct.Mapper;

import spring6andTesting.entities.Beer;
import spring6andTesting.model.BeerDTO;


@Mapper(componentModel = "spring")
public interface BeerMapper {

	Beer beerDtoToBeer(BeerDTO dto);
	BeerDTO beerToBeerDto(Beer beer);
}
