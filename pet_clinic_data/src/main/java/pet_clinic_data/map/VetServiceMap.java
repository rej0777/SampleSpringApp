package pet_clinic_data.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import pet_clinic_data.model.Vet;
import pet_clinic_data.services.VetService;



@Service
public class VetServiceMap extends AbstractMapServive<Vet, Long> implements VetService{

	@Override
	public
	Set<Vet> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}
	
	@Override
	public Vet findById(Long id) {
		
		return super.findById(id);
	}

	@Override
	public Vet save(Vet Object) {
		// TODO Auto-generated method stub
		return super.save( Object);
	}

	@Override
	public void daelte(Vet object) {
		super.delete(object);
		
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
		
	}

	
}
