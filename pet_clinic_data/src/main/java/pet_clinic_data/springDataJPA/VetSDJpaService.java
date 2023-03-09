package pet_clinic_data.springDataJPA;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import pet_clinic_data.model.Owner;
import pet_clinic_data.model.Vet;
import pet_clinic_data.repository.VetRepository;
import pet_clinic_data.services.VetService;

@Service
@Profile({"SpringDataJpa"})
public class VetSDJpaService implements VetService {

	public final VetRepository vetRepository;
	
	
	
	public VetSDJpaService(VetRepository vetRepository) {
	//	super();
		this.vetRepository = vetRepository;
	}

	@Override
	public Set<Vet> findAll() {
		Set<Vet> vets = new HashSet<>();
		vetRepository.findAll().forEach(vets::add);
		return vets;
	}

	@Override
	public Vet findById(Long id) {
		return	vetRepository.findById(id).orElse(null);
	}

	@Override
	public Vet save(Vet object) {		
		return vetRepository.save(object);
	}

	@Override
	public void delete(Vet object) {
		vetRepository.delete(object);		
	}

	@Override
	public void deleteById(Long id) {
		vetRepository.deleteById(id);	
	}

	
	
}
