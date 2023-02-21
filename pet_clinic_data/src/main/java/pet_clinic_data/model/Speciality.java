package pet_clinic_data.model;


import lombok.Getter;
import lombok.Setter;

public class Speciality extends BaseEntity{


	private static final long serialVersionUID = 4050969228432400831L;

	@Getter @Setter
	private String description;
	
	
}
