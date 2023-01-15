package pet_clinic_data.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import pet_clinic_data.model.Owner;
import pet_clinic_data.services.OwnerService;

@Service
public class OwnerServiceMap extends AbstractMapServive<Owner, Long> implements OwnerService {

	@Override
	public Set<Owner> findAll() {
		return super.findAll();
	}

	@Override
	public Owner findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Owner save(Owner object) {
		// TODO Auto-generated method stub
		return super.save( object);
	}

	@Override
	public void daelte(Owner object) {
		super.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public Owner findByLastName(String lastName) {
		return null;
	}

}
