package pet_clinic_data.model;

import lombok.Getter;
import lombok.Setter;

public class PetType extends BaseEntity {

	private static final long serialVersionUID = 4974194515701171948L;
	
	@Getter @Setter 
	private String name;
}
