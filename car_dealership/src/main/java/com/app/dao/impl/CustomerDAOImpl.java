package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.app.dao.CustomerDAO;
import com.app.dao.dbutil.PostgreSqlConnection;
import com.app.exception.BusinessException;
import com.app.model.Customer;

public class CustomerDAOImpl implements CustomerDAO{

	@Override
	public Customer customerVerifyLogin(String email, String password) throws BusinessException {
Customer customer= null;
		
		try ( Connection connection = PostgreSqlConnection.getConnection() ) {
			String sql = "select * from dealership.customer where email = ? and password = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);	
			ResultSet resultSet = preparedStatement.executeQuery();
			if( resultSet.next() ) {
				customer = new Customer();
				customer.setCustomer_id(resultSet.getInt("customer_id"));
				customer.setFirst_name(resultSet.getString("first_name"));
				customer.setLast_name(resultSet.getString("last_name"));
				customer.setDrivers_license(resultSet.getLong("drivers_license"));
				customer.setEmail(resultSet.getString("email"));
				customer.setPassword(resultSet.getString("password"));
			} 
			else
				throw new BusinessException("Try Again. You either entered a wrong email or password");
				
		} catch (ClassNotFoundException e) {
			
		} catch (SQLException e) {
			
		}
		
		return customer;
	}

	@Override
	public int createCustomer(Customer customer) throws BusinessException {
		int c = 0;
		try (Connection connection = PostgreSqlConnection.getConnection()){	
			String sql = "insert into dealership.customer(first_name, last_name, drivers_license, email, password) VALUES(?, ?, ?, ?, ?)";	
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, customer.getFirst_name());
			preparedStatement.setString(2, customer.getLast_name());
			preparedStatement.setLong(3, customer.getDrivers_license());
			preparedStatement.setString(4, customer.getEmail());
			preparedStatement.setString(5, customer.getPassword());
			c = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occured contact SYSADMIN");
		}
		return c;
	}

}
