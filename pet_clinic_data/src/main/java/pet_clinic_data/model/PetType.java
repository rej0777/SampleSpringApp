package pet_clinic_data.model;

import java.util.Set;

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
@Table(name = "types")
public class PetType extends BaseEntity {

	private static final long serialVersionUID = 4974194515701171948L;
	
	@Builder
    public PetType(Long id, String name) {
        super(id);
        this.name = name;
    }

    @Column(name = "name")
    private String name;


    @Override
    public String toString() {
        return name;
    }
}
