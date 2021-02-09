package com.app.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.dao.CustomerCarDAO;
import com.app.dao.dbutil.PostgreSqlConnection;
import com.app.exception.BusinessException;

import com.app.model.CustomerCars;
import com.app.model.Offers;

public class CustomerCarDAOImpl implements CustomerCarDAO{

	@Override
	public int addCarToAccount(CustomerCars customercars) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<CustomerCars> viewMyCars() throws BusinessException {
		List<CustomerCars> myCarList = new ArrayList<>();
		try (Connection connection = PostgreSqlConnection.getConnection()) {
			String sql = "select * from dealership.customercars order by car_id";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				CustomerCars customercars = new CustomerCars();
				customercars.setCar_id(resultSet.getInt("car_id"));
				customercars.setCustomer_id(resultSet.getInt("customer_id"));
				customercars.setMake(resultSet.getString("make"));
				customercars.setModel(resultSet.getString("model"));
				customercars.setYear(resultSet.getInt("year"));
				customercars.setColor(resultSet.getString("color"));
				customercars.setPayments_left(resultSet.getDouble("payments_left"));
				myCarList.add(customercars);
			}
			if (myCarList.size() == 0) {
				throw new BusinessException("You don't have any cars yet");
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error occured contact SYSADMIN");
		}
		return myCarList;
	}

}
