package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
			String sql = "insert into dealership.offer(date, customer_id, car_id, offer_price) VALUES(?, ?, ?, ?)";	
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int acceptOrRejectOffer(int offer_id, String statusChange) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

}
