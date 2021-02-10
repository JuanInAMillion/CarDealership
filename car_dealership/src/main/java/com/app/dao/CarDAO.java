package com.app.dao;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.CarLot;

public interface CarDAO {
	public List<CarLot> viewAllCarsInLot() throws BusinessException;
	public int addCarToLot(CarLot carlot) throws BusinessException;
	public void removeCarFromLot(int car_id) throws BusinessException;
	public int updateCarStatus(int car_id, String statusChange) throws BusinessException;
	public int updateCarOwner(int car_id, String ownerChange) throws BusinessException;
	public int updateCarPrice(int car_id, double newPrice) throws BusinessException;
	public List<CarLot> getMyCars(String owner) throws BusinessException;
}
