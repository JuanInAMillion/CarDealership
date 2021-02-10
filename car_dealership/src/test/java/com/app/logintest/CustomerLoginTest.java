package com.app.logintest;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.app.dao.CustomerDAO;
import com.app.dao.impl.CustomerDAOImpl;
import com.app.exception.BusinessException;

public class CustomerLoginTest {
	@InjectMocks
	private static CustomerDAO customerdao;

	@Mock
	private CustomerDAOImpl customerDaoImpl;

	@BeforeAll
	public static void setUpCarDAOImpl() {
		customerdao = new CustomerDAOImpl();
	}

	@Before
	public void beforeSetup() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void testCustomerVerifyLogin() {
		try {
			customerdao.customerVerifyLogin("juan231f@yahoo.com", "password1");
		} catch (BusinessException e) {
			e.getMessage();
		}
	}
}
