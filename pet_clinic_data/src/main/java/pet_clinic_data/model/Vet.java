package pet_clinic_data.model;

import java.time.LocalDate;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

public class Vet extends Person {


	private static final long serialVersionUID = 3370486946859843028L;
	
	@Getter @Setter
	private Set <Speciality> specialities;

}
