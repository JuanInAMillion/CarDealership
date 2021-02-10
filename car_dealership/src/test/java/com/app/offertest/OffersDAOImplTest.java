package com.app.offertest;

import java.util.Date;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.app.dao.OffersDAO;
import com.app.dao.impl.OffersDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Offers;

public class OffersDAOImplTest {
	@InjectMocks
	private static OffersDAO offerdao;

	@Mock
	private OffersDAOImpl offerDaoImpl;

	@BeforeAll
	public static void setUpCarDAOImpl() {
		offerdao = new OffersDAOImpl();
	}

	@Before
	public void beforeSetup() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void testMakeOfferOnCar() {
		try {
			offerdao.makeOfferOnCar(new Offers(new Date(), 2, 103, 8000));
		} catch (BusinessException e) {
			e.getMessage();
		}
	}
	
	@Test
	public void testViewAllOffers() {
		try {
			for (Offers offers : offerdao.viewAllOffers()) {
				
			}
		} catch (BusinessException e) {
			e.getMessage();
		}
	}
	
	@Test
	public void testAcceptOffer() {
		try {
			offerdao.acceptOffer(10005, "Accepted");
		} catch (BusinessException e) {
			e.getMessage();
		}
	}
	
	@Test
	public void testRejectOffer() {
		try {
			offerdao.rejectOffer(104, "Rejected");
		} catch (BusinessException e) {
			e.getMessage();
		}
	}
	
	@Test
	public void testRemoveOffers() {
		try {
			offerdao.removeOffers("Rejected");
		} catch (BusinessException e) {
			e.getMessage();
		}
	}
}
