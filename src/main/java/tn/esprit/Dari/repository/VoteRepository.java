package tn.esprit.Dari.repository;

import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.Dari.modal.Produit;
import tn.esprit.Dari.modal.User;
import tn.esprit.Dari.modal.Vote;

@Repository
public interface VoteRepository extends CrudRepository<Vote, Integer>{

    @Query("SELECT v FROM Vote v WHERE v.produit= :produit AND v.user= :user")
    Vote SearchLike(@Param("produit") Produit produit, @Param("user") User user);

    @Query("SELECT sum(note)as val1 ,count(*) as val2 FROM Vote v WHERE v.produit= :produit")
    Map<String,Long>  getProductNote (@Param("produit") Produit produit);
    


}
