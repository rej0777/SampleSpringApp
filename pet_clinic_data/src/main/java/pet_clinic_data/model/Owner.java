package pet_clinic_data.model;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;

public class Owner extends Person {

	private static final long serialVersionUID = -5541879307382933184L;
	
	@Getter @Setter 
	private Set<Pet> pets;

}
