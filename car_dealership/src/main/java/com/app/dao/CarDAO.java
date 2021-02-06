package com.app.dao;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.CarLot;

public interface CarDAO {
	public int addCarToLot(CarLot carlot) throws BusinessException;
	public void removeCarFromLot(int car_id) throws BusinessException;
	public List<CarLot> viewAllCarsInLot() throws BusinessException;
	public int updateCarStatus(int car_id, String statusChange) throws BusinessException;
}
