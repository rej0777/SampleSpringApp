package pet_clinic_data.model;

import lombok.Getter;
import lombok.Setter;

public class Person extends BaseEntity {

	private static final long serialVersionUID = 8936135812178428061L;

	@Getter @Setter 
	private String firstName;
	
	@Getter @Setter 
	private String lastName;
	
	@Getter @Setter 
	private String address;
	
	@Getter @Setter
	private String city;
	
	@Getter @Setter
	private String telephone;
}
