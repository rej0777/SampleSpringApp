package pet_clinic_data.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import pet_clinic_data.model.Owner;
import pet_clinic_data.model.Pet;
import pet_clinic_data.model.Vet;
import pet_clinic_data.services.CrudService;
import pet_clinic_data.services.PetService;

@Service
public class PetServiceMap extends AbstractMapServive<Pet, Long> implements PetService {

	@Override
	public
	Set<Pet> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}
	
	@Override
	public Pet findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public Pet save(Pet object) {
		// TODO Auto-generated method stub
		return super.save( object);
	}

	@Override
	public void daelte(Pet object) {
		super.delete(object);
		
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
		
	}

	

}
