package pet_clinic_data.springDataJPA;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import pet_clinic_data.model.Owner;
import pet_clinic_data.model.Speciality;
import pet_clinic_data.repository.SpecialtyRepository;
import pet_clinic_data.services.SpecialtyService;

@Service
@Profile({"SpringDataJpa"})
public class SpecjalitySDJpaService implements SpecialtyService {

	private final SpecialtyRepository specialtyRepository;
	
	
	public SpecjalitySDJpaService(SpecialtyRepository specialtyRepository) {
		super();
		this.specialtyRepository = specialtyRepository;
	}

	@Override
	public Set<Speciality> findAll() {
		Set<Speciality> specialityes = new HashSet<>();
		specialtyRepository.findAll().forEach(specialityes::add);
		return specialityes;
	}

	@Override
	public Speciality findById(Long id) {
		return specialtyRepository.findById(id).orElse(null);
	}

	@Override
	public Speciality save(Speciality object) {
		return specialtyRepository.save(object);
	}

	@Override
	public void delete(Speciality object) {
		specialtyRepository.delete(object);		
	}

	@Override
	public void deleteById(Long id) {
		specialtyRepository.deleteById(id);	
	}

}
