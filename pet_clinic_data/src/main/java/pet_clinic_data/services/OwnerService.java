package pet_clinic_data.services;
 

import java.util.Set;

import pet_clinic_data.model.Owner;

public interface OwnerService extends CrudService<Owner , Long>  {

	Owner findByLastName(String lastName);
//	Owner findById(Long id);
//	Owner save(Owner owner);
//  Set<Owner> findAll();

}
