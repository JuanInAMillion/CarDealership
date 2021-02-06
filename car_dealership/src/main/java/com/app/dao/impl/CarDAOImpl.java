package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.dao.CarDAO;
import com.app.dao.dbutil.PostgreSqlConnection;
import com.app.exception.BusinessException;
import com.app.model.CarLot;

public class CarDAOImpl implements CarDAO{

	@Override
	public int addCarToLot(CarLot carlot) throws BusinessException {
		int c = 0;
		try (Connection connection = PostgreSqlConnection.getConnection()){	
			String sql = "insert into dealership.carlot(make, model, year, color, condition, price) VALUES(?, ?, ?, ?, ?, ?)";	
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, carlot.getMake());
			preparedStatement.setString(2, carlot.getModel());
			preparedStatement.setInt(3, carlot.getYear());
			preparedStatement.setString(4, carlot.getColor());
			preparedStatement.setString(5, carlot.getCondition());
			preparedStatement.setDouble(6, carlot.getPrice());
			c = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occured contact SYSADMIN\n");
		}
		return c;
	}

	@Override
	public void removeCarFromLot(int car_id) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CarLot> viewAllCarsInLot() throws BusinessException {
		List<CarLot> customerList=new ArrayList<>();
		try (Connection connection = PostgreSqlConnection.getConnection()) {
			String sql = "select * from dealership.carlot";
			PreparedStatement preparedStatement=connection.prepareStatement(sql); 
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				CarLot carlot = new CarLot();
				carlot.setCar_id(resultSet.getInt("car_id"));
				carlot.setMake(resultSet.getString("make"));
				carlot.setModel(resultSet.getString("model"));
				carlot.setYear(resultSet.getInt("year"));
				carlot.setColor(resultSet.getString("color"));
				carlot.setCondition(resultSet.getString("condition"));
				carlot.setPrice(resultSet.getDouble("price"));
				carlot.setStatus(resultSet.getString("status"));
				customerList.add(carlot);
			} 
			if(customerList.size() == 0)
			{
				throw new BusinessException("No Car in the CarLot so far");
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error occured contact SYSADMIN");
		}		
		return customerList  ;
	}

	@Override
	public int updateCarStatus(int car_id, String statusChange) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

}
