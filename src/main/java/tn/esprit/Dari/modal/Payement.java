package tn.esprit.Dari.modal;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="payements")
public class Payement {
	
	@Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long id;
	private Date createDate;
	private Integer quantity;
	private Double amount;
	@ManyToOne
	private User user ;
	@ManyToOne
	private Produit product ;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus status ;
	
	@Enumerated(EnumType.STRING)
	private PayementType  payementType;
	
	private String referenceExterne;
	
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Produit getProduct() {
		return product;
	}
	public void setProduct(Produit product) {
		this.product = product;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getReferenceExterne() {
		return referenceExterne;
	}
	public void setReferenceExterne(String referenceExterne) {
		this.referenceExterne = referenceExterne;
	}
	public PayementType getPayementType() {
		return payementType;
	}
	public void setPayementType(PayementType payementType) {
		this.payementType = payementType;
	}
	
	
	
}
