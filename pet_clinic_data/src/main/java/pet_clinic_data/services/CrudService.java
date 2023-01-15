package pet_clinic_data.services;

import java.util.Set;

public interface CrudService<T , ID> {

	Set<T> findAll();
	
	T findById(ID id);
	
	T save(T Object);
	
	void daelte(T object);
	
	void deleteById(ID id);
}
