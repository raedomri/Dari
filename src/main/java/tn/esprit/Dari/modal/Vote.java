package tn.esprit.Dari.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Vote {

	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int note;

    @ManyToOne
    private Produit produit;

    @ManyToOne
    private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public Vote() {
		super();
	}
    
    
    

}
