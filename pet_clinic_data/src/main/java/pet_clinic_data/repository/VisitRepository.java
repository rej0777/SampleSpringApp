package pet_clinic_data.repository;

import org.springframework.data.repository.CrudRepository;

import pet_clinic_data.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {

}
