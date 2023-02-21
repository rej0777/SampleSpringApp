package pet_clinic_data.model;

import java.time.LocalDate;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

public class Visit extends BaseEntity {

	private static final long serialVersionUID = 2465548486907209615L;

	@Getter @Setter
	private LocalDate  date;
	
	@Getter @Setter
	private String descripton;
	
	@Getter @Setter
	private Pet pet;
}
