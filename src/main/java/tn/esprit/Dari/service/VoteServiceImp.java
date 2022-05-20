package tn.esprit.Dari.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.Dari.modal.Produit;
import tn.esprit.Dari.modal.User;
import tn.esprit.Dari.modal.Vote;
import tn.esprit.Dari.repository.VoteRepository;


@Service
public class VoteServiceImp implements VoteService {

    @Autowired
    VoteRepository VoteRepo ;
    @Autowired
    UserService usersService;
    @Autowired
    ProduitService produitService;

    @Override
    public List<Vote> retrieveAllVote() {
        List<Vote> votes = (List<Vote>) VoteRepo.findAll();
        return votes;
    }

    @Override
    public Vote findVoteById(int r) {
        return this.VoteRepo.findById(r).get();
    }


    @Override
    @Transactional
    public Vote addVoteLike( int idp , int idu, int note) {
    	Produit produit = produitService.findById(idp);
        Vote vote = findLikeByProduitAndUser(produit,usersService.findUserById(idu));
        System.out.println(vote);
        if(vote==null)
        	vote = new Vote();
        
        vote.setUser(usersService.findUserById(idu));
        vote.setProduit(produitService.findById(idp));
        vote.setNote(note);
        vote =VoteRepo.save(vote);
        Map<String,Long> productNote = VoteRepo.getProductNote(produit);
        Long val1 =  productNote.get("val1");
        Long val2 =  productNote.get("val2");
        produit.setNote((Double.valueOf(val1+"")/Double.valueOf(val2+"")));
        produitService.updateProduit(produit);
        return vote;

    }

 



   

	@Override
	public Vote findLikeByProduitAndUser(Produit r, User user) {
		return  VoteRepo.SearchLike(r,user);
	}


}


