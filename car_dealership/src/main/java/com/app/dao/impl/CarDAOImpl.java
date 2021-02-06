package com.app.dao.impl;

import java.util.List;

import com.app.dao.CarDAO;
import com.app.exception.BusinessException;
import com.app.model.CarLot;

public class CarDAOImpl implements CarDAO{

	@Override
	public int addCarToLot(CarLot carlot) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void removeCarFromLot(int car_id) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CarLot> viewAllCarsInLot() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateCarStatus(int car_id, String statusChange) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

}
