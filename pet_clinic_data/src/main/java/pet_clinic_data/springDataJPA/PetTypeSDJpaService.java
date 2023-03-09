package pet_clinic_data.springDataJPA;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import pet_clinic_data.model.Owner;
import pet_clinic_data.model.PetType;
import pet_clinic_data.repository.PetTypeRepository;
import pet_clinic_data.services.PetTypeService;

@Service
@Profile({"SpringDataJpa"})
public class PetTypeSDJpaService implements PetTypeService  {
	
	private final PetTypeRepository petTypeRepository;

	public PetTypeSDJpaService(PetTypeRepository petTypeRepository) {
		this.petTypeRepository = petTypeRepository;
	}

	@Override
	public Set<PetType> findAll() {
		Set<PetType> petTypes = new HashSet<>();
		petTypeRepository.findAll().forEach(petTypes::add);
		return petTypes;
	}

	@Override
	public PetType findById(Long id) {
		return petTypeRepository.findById(id).orElse(null);
	}

	@Override
	public PetType save(PetType object) {
		return petTypeRepository.save(object);
	}

	@Override
	public void delete(PetType object) {
		petTypeRepository.delete(object);	
	}

	@Override
	public void deleteById(Long id) {
		petTypeRepository.deleteById(id);		
	}
	
	
	
	

}
