package pet_clinic_data.map;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import pet_clinic_data.model.PetType;
import pet_clinic_data.services.PetTypeService;

import java.util.HashSet;
import java.util.Set;



@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {

    @Override
    public HashSet<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }

    @Override
    public PetType save(PetType object) {
        return super.save(object);
    }

    @Override
    public void delete(PetType object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
