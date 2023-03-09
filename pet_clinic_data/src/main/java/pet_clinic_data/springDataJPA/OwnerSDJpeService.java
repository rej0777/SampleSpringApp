package pet_clinic_data.springDataJPA;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import pet_clinic_data.model.Owner;
import pet_clinic_data.repository.Ownerepository;
import pet_clinic_data.repository.PetRepository;
import pet_clinic_data.repository.PetTypeRepository;
import pet_clinic_data.services.OwnerService;

@Service
@Profile({"SpringDataJpa"})
public class OwnerSDJpeService implements OwnerService {

	private final Ownerepository ownerepository;
	private final PetRepository petRepository;
	private final PetTypeRepository petTypeRepository;
	
	
	
	public OwnerSDJpeService(Ownerepository ownerepository, PetRepository petRepository,
			PetTypeRepository petTypeRepository) {
		super();
		this.ownerepository = ownerepository;
		this.petRepository = petRepository;
		this.petTypeRepository = petTypeRepository;
	}

	@Override
	public Set<Owner> findAll() {
		Set<Owner> owners = new HashSet<>();
		ownerepository.findAll().forEach(owners::add);
		return owners;
	}

	@Override
	public Owner findById(Long id) {

	//	Optional<Owner> optionalOwner = ownerepository.findById(id);

	return	ownerepository.findById(id).orElse(null);
	//	if (optionalOwner.isPresent()) {
	//		return optionalOwner.get();
	//	} else {
	//		return null;
	//	}
	}

	@Override
	public Owner save(Owner object) {
		return ownerepository.save(object);
	}

	@Override
	public void delete(Owner object) {
		ownerepository.delete(object);
		
	}

	@Override
	public void deleteById(Long id) {
		ownerepository.deleteById(id);		
	}

	@Override
	public Owner findByLastName(String lastName) {
		return ownerepository.findByLastName(lastName);
	}

	@Override
	public List<Owner> findAllByLastNameLike(String lastName) {
		return ownerepository.findAllByLastNameLike(lastName);
	}

}
