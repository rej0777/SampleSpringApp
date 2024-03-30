package pet_clinic_data.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = -986394777556127632L;
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    public BaseEntity(Long id2) {//??
//		this.id= id2;
//	}

	public boolean isNew() {
        return this.id == null;
    }

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseEntity other = (BaseEntity) obj;
		return Objects.equals(id, other.id);
	}

	
	
	
}