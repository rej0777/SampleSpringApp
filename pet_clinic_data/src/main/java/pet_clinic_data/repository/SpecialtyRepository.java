package pet_clinic_data.repository;

import org.springframework.data.repository.CrudRepository;

import pet_clinic_data.model.Speciality;

public interface SpecialtyRepository extends CrudRepository<Speciality, Long> {

}
