package tn.esprit.Dari.service;

import tn.esprit.Dari.modal.Payement;


public interface PayementService {

	Payement addPayement(Payement payement);

	Payement updatePayement(Payement payement);

	Payement findPayementById(long id);
	String callStripeAPIBuy(Payement payement);


}
