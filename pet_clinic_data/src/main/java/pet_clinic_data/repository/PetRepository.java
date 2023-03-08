package pet_clinic_data.repository;

import org.springframework.data.repository.CrudRepository;

import pet_clinic_data.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
