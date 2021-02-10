package com.app.dao;

import com.app.exception.BusinessException;
import com.app.model.Customer;

public interface CustomerDAO {
	public Customer customerVerifyLogin(String email, String password) throws BusinessException;
	public int createCustomer(Customer customer) throws BusinessException;
	public double makeAPayment(int car_id, double paymentAmount) throws BusinessException;
	public double searchBalance(int car_id) throws BusinessException;
	public int payThisCar(int car_id, double newBalance) throws BusinessException;
}
