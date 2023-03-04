package pet_clinic_data.services;
 

import java.util.List;

import pet_clinic_data.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);
 }
