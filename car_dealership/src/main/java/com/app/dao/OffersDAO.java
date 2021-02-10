package com.app.dao;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Offers;

public interface OffersDAO {
	public int makeOfferOnCar(Offers offers) throws BusinessException;
	public List<Offers> viewAllOffers() throws BusinessException;
	public int acceptOffer(int offer_id, String pendingStatus) throws BusinessException;
	public int rejectOffer(int car_id, String pendingStatus) throws BusinessException;
	public void removeOffers(String pending_offer) throws BusinessException;
}
