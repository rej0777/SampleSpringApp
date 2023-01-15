package pet_clinic_data.model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

public class Pet extends BaseEntity {
	
	private static final long serialVersionUID = 3954015615994461175L;

	
	@Getter @Setter 
	private PetType petType;
	
	@Getter @Setter 
	private Owner owner;
	
	@Getter @Setter 
	private LocalDate birthDate;
	

}
