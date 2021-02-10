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

public class CarDAOImpl implements CarDAO {

	@Override
	public List<CarLot> viewAllCarsInLot() throws BusinessException {
		List<CarLot> carList = new ArrayList<>();
		try (Connection connection = PostgreSqlConnection.getConnection()) {
			String sql = "select * from dealership.carlot where status='Available' order by car_id";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				CarLot carlot = new CarLot();
				carlot.setCar_id(resultSet.getInt("car_id"));
				carlot.setMake(resultSet.getString("make"));
				carlot.setModel(resultSet.getString("model"));
				carlot.setYear(resultSet.getInt("year"));
				carlot.setColor(resultSet.getString("color"));
				carlot.setCondition(resultSet.getString("condition"));
				carlot.setPrice(resultSet.getDouble("price"));
				carlot.setStatus(resultSet.getString("status"));
				carlot.setOwner(resultSet.getString("owner"));
				carList.add(carlot);
			}
			if (carList.size() == 0) {
				throw new BusinessException("No Car in the CarLot so far");
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error occured contact SYSADMIN");
		}
		return carList;
	}

	@Override
	public int addCarToLot(CarLot carlot) throws BusinessException {
		int c = 0;
		try (Connection connection = PostgreSqlConnection.getConnection()) {
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
		int r = 0;
		try (Connection connection = PostgreSqlConnection.getConnection()) {
			String sql = "delete from dealership.carlot where car_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, car_id);
			r = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error occured contact SYSADMIN");
		}
	}

	@Override
	public int updateCarStatus(int car_id, String statusChange) throws BusinessException {
		int s = 0;
		try (Connection connection = PostgreSqlConnection.getConnection()) {
			String sql = "update dealership.carlot set status=? where car_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, statusChange);
			preparedStatement.setInt(2, car_id);
			s = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occured contact SYSADMIN");
		}
		return s;
	}

	@Override
	public int updateCarOwner(int car_id, String ownerChange) throws BusinessException {
		int o = 0;
		try (Connection connection = PostgreSqlConnection.getConnection()) {
			String sql = "update dealership.carlot set owner=? where car_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, ownerChange);
			preparedStatement.setInt(2, car_id);
			o = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occured contact SYSADMIN");
		}
		return o;
	}

	@Override
	public int updateCarPrice(int car_id, double newPrice) throws BusinessException {
		int o = 0;
		try (Connection connection = PostgreSqlConnection.getConnection()) {
			String sql = "update dealership.carlot set price=? where car_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setDouble(1, newPrice);
			preparedStatement.setInt(2, car_id);
			o = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occured contact SYSADMIN");
		}
		return o;
	}
	
	@Override
	public List<CarLot> getMyCars(String owner) throws BusinessException {
		List<CarLot> myCarList = new ArrayList<>();
		try (Connection connection = PostgreSqlConnection.getConnection()) {
			String sql = "select car_id, make, model, year, color, price from dealership.carlot where owner=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, owner);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				CarLot carlot = new CarLot();
				carlot.setCar_id(resultSet.getInt("car_id"));
				carlot.setMake(resultSet.getString("make"));
				carlot.setModel(resultSet.getString("model"));
				carlot.setYear(resultSet.getInt("year"));
				carlot.setColor(resultSet.getString("color"));
				carlot.setPrice(resultSet.getDouble("price"));
				myCarList.add(carlot);
			}
			if (myCarList.size() == 0) {
				throw new BusinessException("You don't have any cars yet");
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error occured contact SYSADMIN ");
		}
		return myCarList;

	}

}
