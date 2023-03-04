package pet_clinic_data.repository;

import org.springframework.data.repository.CrudRepository;

import pet_clinic_data.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}
