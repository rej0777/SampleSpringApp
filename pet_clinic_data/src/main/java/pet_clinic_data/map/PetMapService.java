package pet_clinic_data.map;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import pet_clinic_data.model.Pet;
import pet_clinic_data.services.PetService;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jt on 7/21/18.
 */
@Service
@Profile({"default", "map"})
public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {
    @Override
    public HashSet<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
