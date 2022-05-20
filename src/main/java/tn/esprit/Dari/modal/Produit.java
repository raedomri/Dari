package tn.esprit.Dari.modal;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="produits")
public class Produit {
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private Long idProduit;
    
    @ManyToOne
    @JoinColumn(name="idCategory",referencedColumnName = "idCategory", updatable = false)
    private Category categoryProduit;
    
    private Double note;
    private Double prixProduit;
    private String nomProduit;

    private  String codeabarraProduit ;
    
    @OneToOne(mappedBy = "produit")
    private UploadFile image ;
    
    private Date dateCreation;
    
 
	private  int quantity;
    
    public Produit() {
		super();
		
	}
   


	@Override
	public String toString() {
		return "Produit [idProduit=" + idProduit + ", categoryProduit=" + categoryProduit + ", prixProduit="
				+ prixProduit + ", nomProduit=" + nomProduit + ", codeabarraProduit=" + codeabarraProduit + ", image="
				+ image + ", dateCreation=" + dateCreation + "]";
	}


	public Long getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}
	public Category getCategoryProduit() {
		return categoryProduit;
	}
	public void setCategoryProduit(Category categoryProduit) {
		this.categoryProduit = categoryProduit;
	}
	public Double getPrixProduit() {
		return prixProduit;
	}
	public void setPrixProduit(Double prixProduit) {
		this.prixProduit = prixProduit;
	}
	public String getNomProduit() {
		return nomProduit;
	}
	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public String getCodeabarraProduit() {
		return codeabarraProduit;
	}
	public void setCodeabarraProduit(String codeabarraProduit) {
		this.codeabarraProduit = codeabarraProduit;
	}

	public UploadFile getImage() {
		return image;
	}

	public void setImage(UploadFile image) {
		this.image = image;
	}


	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public Double getNote() {
		return note;
	}



	public void setNote(Double note) {
		this.note = note;
	}
	
	
    
	}


