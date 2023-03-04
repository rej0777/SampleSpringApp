package pet_clinic_data.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import pet_clinic_data.model.Owner;

public interface Ownerepository extends CrudRepository<Owner, Long> {

	Owner findByLastName(String lastName);
	List<Owner> findAllByLastNameLike(String lastName);
}
