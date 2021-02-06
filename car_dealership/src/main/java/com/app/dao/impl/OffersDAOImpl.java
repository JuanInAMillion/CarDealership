package com.app.dao.impl;

import java.util.List;

import com.app.dao.OffersDAO;
import com.app.exception.BusinessException;
import com.app.model.Offers;

public class OffersDAOImpl implements OffersDAO{

	@Override
	public int placeBidOnCar(Offers bids) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Offers> viewAllBids() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int acceptOrRejectBid(int bid_id, String statusChange) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

}
