package com.app.dao;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.CustomerCars;

public interface CustomerCarDAO {
	public int addCarToAccount(CustomerCars customercars) throws BusinessException;
	public List<CustomerCars> viewMyCars() throws BusinessException;
}
