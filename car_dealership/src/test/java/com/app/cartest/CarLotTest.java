package com.app.cartest;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.app.dao.CarDAO;
import com.app.dao.impl.CarDAOImpl;
import com.app.model.CarLot;

public class CarLotTest {
	
	private static CarDAOImpl carDaoImpl;
	
	@BeforeClass
	public static void setup() {
		carDaoImpl = new CarDAOImpl();
	}
	
	@Test
	public void  testAddCarToLot() {
	
	}
}
