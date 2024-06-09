package spring6andTesting.restJPA.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring6andTesting.restJPA.model.BeerStyle;
import spring6andTesting.restJPA.model.CustomerDTO;

@Entity
//@Data
@Getter
@Setter
@Builder

@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(length = 36,columnDefinition = "varchar",updatable = false, nullable = false)
	private UUID id;
	@Version
	private Integer version;
	
    private String name;
    private LocalDateTime createdDate;
    private LocalDateTime updateDate;
}