package pet_clinic_data.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import pet_clinic_data.model.BaseEntity;

@Service
public abstract class AbstractMapServive<T extends BaseEntity, ID extends Long> {

	protected Map<Long, T> map =  new HashMap<>(); //ID
	
	Set<T> findAll(){
		return new HashSet<>(map.values());
	}
	
	T findById(ID id) {
		return map.get(id);
	}

	T save ( T object) {
		if(object != null) {
			if(object.getId()==null) {
				object.setId(getNextId());
			}
			map.put(object.getId(), object);
		}else {
			throw new RuntimeException("niemoże być null");
		}		
	return	object;
	}
	
	void deleteById(ID id) {
		map.remove(id);
	}
	
	void delete (T object) {
		map.entrySet().removeIf(entry -> entry.getValue().equals(object));
	}

	private Long getNextId() {
		Long nextId = null;
			try {
				nextId = Collections.max(map.keySet()) +1;
			} catch (Exception e) {
				nextId =1L;
				// TODO: handle exception
			}	
		return nextId;
	}
}
