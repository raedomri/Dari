package tn.esprit.Dari.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tn.esprit.Dari.modal.Produit;
import tn.esprit.Dari.modal.User;
import tn.esprit.Dari.modal.Vote;

@Service
public interface VoteService {
	
	    List<Vote> retrieveAllVote();
	    Vote findVoteById(int r);
	    Vote findLikeByProduitAndUser(Produit r, User user);
	    Vote addVoteLike(int idp , int idu, int note);
	  
	     
	

}
