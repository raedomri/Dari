package tn.esprit.Dari.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.Dari.modal.UploadFile;

@Repository
public interface UploadFileRepository extends CrudRepository<UploadFile, Long> {

}
