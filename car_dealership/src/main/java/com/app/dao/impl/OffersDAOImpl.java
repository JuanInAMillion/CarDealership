package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.dao.OffersDAO;
import com.app.dao.dbutil.PostgreSqlConnection;
import com.app.exception.BusinessException;
import com.app.model.Offers;

public class OffersDAOImpl implements OffersDAO{

	@Override
	public int makeOfferOnCar(Offers offers) throws BusinessException {
		int o = 0;
		try (Connection connection = PostgreSqlConnection.getConnection()){	
			String sql = "insert into dealership.offers(date, customer_id, car_id, offer_price) VALUES(?, ?, ?, ?)";	
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setDate(1, new java.sql.Date(offers.getDate().getTime()));
			preparedStatement.setInt(2, offers.getCustomer_id());
			preparedStatement.setInt(3, offers.getCar_id());
			preparedStatement.setDouble(4, offers.getOffer_price());
			o = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occured contact SYSADMIN");
		}
		return o;
	}

	@Override
	public List<Offers> viewAllOffers() throws BusinessException {
		List<Offers> offerList = new ArrayList<>();
		try (Connection connection = PostgreSqlConnection.getConnection()) {
			String sql = "select * from dealership.offers order by car_id";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Offers offers = new Offers();
				offers.setOffer_id(resultSet.getInt("offer_id"));
				offers.setDate(resultSet.getDate("date"));
				offers.setCustomer_id(resultSet.getInt("customer_id"));
				offers.setCar_id(resultSet.getInt("car_id"));
				offers.setOffer_price(resultSet.getDouble("offer_price"));
				offers.setPending_offer(resultSet.getString("pending_offer"));
				offerList.add(offers);
			}
			if (offerList.size() == 0) {
				throw new BusinessException("No Pending Offers So Far");
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error occured contact SYSADMIN");
		}
		return offerList;
	}
	
	@Override
	public int acceptOffer(int offer_id, String acceptedOffer) throws BusinessException {
		int s = 0;
		try (Connection connection = PostgreSqlConnection.getConnection()) {
			String sql = "update dealership.offers set pending_offer=? where offer_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, acceptedOffer);
			preparedStatement.setInt(2, offer_id);
			s = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occured contact SYSADMIN");
		}
		return s;
	}

	@Override
	public int rejectOffer(int car_id, String rejectedOffer) throws BusinessException {
		int s = 0;
		try (Connection connection = PostgreSqlConnection.getConnection()) {
			String sql = "update dealership.offers set pending_offer=? where car_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, rejectedOffer);
			preparedStatement.setInt(2, car_id);
			s = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occured contact SYSADMIN");
		}
		return s;
	}

	@Override
	public void removeOffers(String pending_offer) throws BusinessException {
		int r = 0;
		try (Connection connection = PostgreSqlConnection.getConnection()) {
			String sql = "delete from dealership.offers where pending_offer=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, pending_offer);
			r = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error occured contact SYSADMIN");
		}
		
	}

}
