package com.app.dao;

import com.app.exception.BusinessException;
import com.app.model.Employee;

public interface EmployeeDAO {
	public Employee employeeVerifyLogin(String email, String password) throws BusinessException;
}
