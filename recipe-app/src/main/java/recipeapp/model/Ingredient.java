package recipeapp.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Ingredient {
	
	  public Ingredient(String description, BigDecimal amount, UnitOfMeasure uom, Recipe recipe) {
	        this.description = description;
	        this.amount = amount;
	        this.uom = uom;
	        this.recipe = recipe;
	    }
	  
	  public Ingredient(String description, BigDecimal amount, UnitOfMeasure uom) {
	        this.description = description;
	        this.amount = amount;
	        this.uom = uom;
	    }
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String description;
	private BigDecimal amount;
	
	@OneToOne(fetch = FetchType.EAGER)
	private UnitOfMeasure uom;
	
	@ManyToOne 
	private Recipe recipe;
	

}
