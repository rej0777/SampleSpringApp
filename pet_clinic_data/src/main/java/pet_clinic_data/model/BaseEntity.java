package pet_clinic_data.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class BaseEntity implements Serializable {

	private static final long serialVersionUID = -2084088182714536332L;
	
	@Getter @Setter 
	private Long id;

}
