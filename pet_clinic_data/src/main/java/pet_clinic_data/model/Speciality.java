package pet_clinic_data.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "specialties")
public class Speciality extends BaseEntity {


	private static final long serialVersionUID = 1550021963464582259L;

	@Column(name = "description")
    private String description;

}