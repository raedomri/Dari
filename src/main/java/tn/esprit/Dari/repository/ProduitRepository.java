package tn.esprit.Dari.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.Dari.modal.Category;
import tn.esprit.Dari.modal.Produit;

@Repository("produitRepository")
public interface ProduitRepository extends CrudRepository<Produit, Long> {

	@Query("SELECT a FROM Produit a WHERE a.nomProduit= :l AND a.categoryProduit= :f" )
	List<Produit> Search(@Param ("l") String nom,@Param("f") Category f);

	@Query("SELECT p FROM Produit p WHERE p.note is not null order by note desc " )
	List<Produit> getBestProduct();

	

}
