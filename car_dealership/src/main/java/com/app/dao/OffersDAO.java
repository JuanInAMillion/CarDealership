package com.app.dao;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Offers;

public interface OffersDAO {
	public int placeBidOnCar(Offers bids) throws BusinessException;
	public List<Offers> viewAllBids() throws BusinessException;
	public int acceptOrRejectBid(int bid_id, String statusChange) throws BusinessException;
}
