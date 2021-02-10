package com.app.dao;

import com.app.exception.BusinessException;
import com.app.model.Customer;

public interface CustomerDAO {
	public Customer customerVerifyLogin(String email, String password) throws BusinessException;
	public int createCustomer(Customer customer) throws BusinessException;
}
