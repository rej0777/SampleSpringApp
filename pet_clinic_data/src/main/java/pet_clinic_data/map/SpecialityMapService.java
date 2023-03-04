package pet_clinic_data.map;



import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import pet_clinic_data.model.Speciality;
import pet_clinic_data.services.SpecialtyService;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jt on 7/31/18.
 */
@Service
//@Profile({"default", "map"})
public class SpecialityMapService extends AbstractMapService<Speciality, Long> implements SpecialtyService {

    @Override
    public HashSet<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Speciality save(Speciality object) {
        return super.save(object);
    }

    @Override
    public void delete(Speciality object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
