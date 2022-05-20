package tn.esprit.Dari.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table (name="categories")

public class Category {

	
	
	@Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private Long idCategory;
	@NotBlank
    private String nomCategory;
    
    
    
	@Override
	public String toString() {
		return "Category [idCategory=" + idCategory + ", nomCategory=" + nomCategory + "]";
	}
	public Category(String nomCategory) {
		super();
		this.nomCategory = nomCategory;
	}
	public Category() {
		super();
	}
	public Long getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(Long idCategory) {
		this.idCategory = idCategory;
	}
	public String getNomCategory() {
		return nomCategory;
	}
	public void setNomCategory(String nomCategory) {
		this.nomCategory = nomCategory;
	}
    
    
    
    
    
    
}
