package pet_clinic_data.repository;

import org.springframework.data.repository.CrudRepository;

import pet_clinic_data.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {

}
