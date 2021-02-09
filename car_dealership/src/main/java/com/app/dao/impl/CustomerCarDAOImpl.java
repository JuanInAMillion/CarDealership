package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.app.dao.CustomerCarDAO;
import com.app.dao.dbutil.PostgreSqlConnection;
import com.app.exception.BusinessException;
import com.app.model.CustomerCars;

public class CustomerCarDAOImpl implements CustomerCarDAO{

	@Override
	public int addCarToAccount(CustomerCars customercars) throws BusinessException {
		int c = 0;
		try (Connection connection = PostgreSqlConnection.getConnection()){	
			String sql = "insert into dealership.customercars(car_id, customer_id, date_purchased, make, model, year, color payments_left) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";	
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, customercars.getCar_id());
			preparedStatement.setInt(2, customercars.getCustomer_id());
			preparedStatement.setDate(3, new java.sql.Date(customercars.getDate_purchased().getTime()));
			preparedStatement.setString(4, customercars.getMake());
			preparedStatement.setString(5, customercars.getModel());
			preparedStatement.setInt(6, customercars.getYear());
			preparedStatement.setString(7, customercars.getColor());
			preparedStatement.setDouble(8, customercars.getPayments_left());
			c = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occured contact SYSADMIN");
		}
		return c;
	}

}
