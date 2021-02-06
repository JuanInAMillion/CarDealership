package com.app.dao;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.model.CustomerCars;

public interface CustomerDAO {
	public Customer customerVerifyLogin(String email, String password) throws BusinessException;
	public int createCustomer(Customer customer) throws BusinessException;
	public List<CustomerCars> viewAllCarsIOwn() throws BusinessException;
}
