package recipeapp.model;


import java.util.*;

import org.hibernate.metamodel.ValueClassification;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	 private String description;
	    private Integer prepTime;
	    private Integer cookTime;
	    private Integer servings;
	    private String source;
	    private String url;
	    @Lob
	    private String directions;
	    
	    @Lob
	    private Byte[] image;
	    
	    @Enumerated(value = EnumType.STRING)
	    private Difficulty difficulty;
	    
	    
	    
	    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
	    private Set<Ingredient> ingredients= new HashSet<>();
	    
	    @ManyToMany
	    private Set<Category> categories = new HashSet<>();
	    
	    @OneToOne(cascade = CascadeType.ALL)
	    private Notes notes;
	    
	    public Recipe addIngredient(Ingredient ingredient){
	        ingredient.setRecipe(this);
	        this.ingredients.add(ingredient);
	        return this;
	    }
	    
	
}
