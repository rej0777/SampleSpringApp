package pet_clinic_data.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "visits")
public class Visit extends BaseEntity {

	private static final long serialVersionUID = 4872767817746438275L;

	//public Visit(Long id2) {
//		super(id2);
		// TODO Auto-generated constructor stub
//	}

	@Column(name = "date")
    private LocalDate date;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private   Pet pet;

    public LocalDate getDate() {
        return date;
    }

}