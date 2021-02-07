package com.app.dao;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Offers;

public interface OffersDAO {
	public int makeOfferOnCar(Offers offers) throws BusinessException;
	public List<Offers> viewAllOffers() throws BusinessException;
	public int acceptOrRejectOffer(int offer_id, String statusChange) throws BusinessException;
}
