package tn.esprit.Dari.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.Dari.modal.Category;
import tn.esprit.Dari.modal.Produit;
import tn.esprit.Dari.modal.UploadFile;
import tn.esprit.Dari.repository.ProduitRepository;
import tn.esprit.Dari.repository.UploadFileRepository;


@Service("produitService")
public class ProduitServiceImpl implements ProduitService {

	@Autowired
	ProduitRepository produitRepository;

	@Autowired
	UploadFileRepository  uploadFileRepository;
	
	@Override
	public Produit addProduit(Produit produit) {
		produitRepository.save(produit) ;
		return produit;
	}
	@Override
	public String DeleteProduit(long id) {
		produitRepository.delete(produitRepository.findById((long) id).get());
		return "Deleted"; 

	}

	@Override
	public Produit updateProduit (Produit produit) {
		return produitRepository.save(produit);
	}
	
	@Override
	public List<Produit> retrieveAllProduit() {
		List<Produit> produits=(List<Produit>)produitRepository.findAll();
		return produits;
	}
	
	@Override
	public List<Produit> getBestProduct() {
		List<Produit> produits=(List<Produit>)produitRepository.getBestProduct();
		return produits;
	}
	
	

	@Override
	public UploadFile saveImage(UploadFile p) {
		return uploadFileRepository.save(p);

	}

	@Override
	public Produit findById(long id) {
		return produitRepository.findById(id).orElse(null);
	}


	@Override
	public List<Produit> retrieveProduitByNom(String l,Category f) {
		return this.produitRepository.Search(l,f);
	}





}
