package tn.esprit.Dari.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.Dari.modal.Payement;

@Repository
public interface PayementRepository extends CrudRepository<Payement , Long> {

}
