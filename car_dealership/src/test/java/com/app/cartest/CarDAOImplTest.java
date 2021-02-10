package com.app.cartest;

import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.app.dao.CarDAO;
import com.app.dao.impl.CarDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.CarLot;

public class CarDAOImplTest {

	@InjectMocks
	private static CarDAO cardao;

	@Mock
	private CarDAOImpl carDaoImpl;

	@BeforeAll
	public static void setUpCarDAOImpl() {
		cardao = new CarDAOImpl();
	}

	@Before
	public void beforeSetup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testViewAllCarsInLot() throws BusinessException {
		List<CarLot> viewAllCarsInLot = cardao.viewAllCarsInLot();
		for (int i = 0; i < viewAllCarsInLot.size(); i++) {
			CarLot carLot = viewAllCarsInLot.get(i);
		}
	}

	@Test
	public void testAddCarToLot() {
		try {
			cardao.addCarToLot(new CarLot("Tesla", "Model T", 2021, "White", "New", 56000));
		} catch (BusinessException e) {
			e.getMessage();
		}
	}

	@Test
	public void testRemoveCarFromLot() {
		try {
			cardao.removeCarFromLot(100);
		} catch (BusinessException e) {
			e.getMessage();
		}
	}

	@Test
	public void testUpdateCarStatus() {
		try {
			cardao.updateCarStatus(103, "Unavailable");
		} catch (BusinessException e) {
			e.getMessage();
		}
	}

	@Test
	public void testUpdateCarOwner()  {
		try {
			cardao.updateCarOwner(112, "3");
		} catch (BusinessException e) {
			e.getMessage();
		}
	}

}
