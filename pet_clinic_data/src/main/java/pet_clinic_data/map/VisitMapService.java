package pet_clinic_data.map;



import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import pet_clinic_data.model.Visit;
import pet_clinic_data.services.VisitService;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jt on 8/7/18.
 */
@Service
@Profile({"default", "map"})
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

    @Override
    public HashSet<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Visit save(Visit visit) {

        if(visit.getPet() == null || visit.getPet().getOwner() == null || visit.getPet().getId() == null
            || visit.getPet().getOwner().getId() == null){
            throw new RuntimeException("Invalid Visit");
        }

        return super.save(visit);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
