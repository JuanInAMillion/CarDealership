package com.app.menu;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.dao.CarDAO;
import com.app.dao.CustomerCarDAO;
import com.app.dao.CustomerDAO;
import com.app.dao.OffersDAO;
import com.app.dao.impl.CarDAOImpl;
import com.app.dao.impl.CustomerCarDAOImpl;
import com.app.dao.impl.CustomerDAOImpl;
import com.app.dao.impl.OffersDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.CarLot;
import com.app.model.Customer;
import com.app.model.CustomerCars;
import com.app.model.Offers;

public class CustomerLogin {
	private static Logger log = Logger.getLogger("consoleLog.CustomerLogin");

	// Customer Login
	public void customerLogin(Scanner sc, Customer customer) {
		String customeremail = "";
		String customerpassword = "";

		CustomerDAO login = new CustomerDAOImpl();

		log.info("Enter Your Email: ");
		customeremail = sc.nextLine();
		log.info("Enter Your Password: ");
		customerpassword = sc.nextLine();

		try {
			Customer c = login.customerVerifyLogin(customeremail, customerpassword);
			log.info("Welcome " + c.getFirst_name() + " here is your info:\n");
			log.info("Customer ID#: " + c.getCustomer_id() + "     Name: " + c.getFirst_name() + " " + c.getLast_name()
					+ "     Driver\'s License: " + c.getDrivers_license() + "     Email: " + c.getEmail() + "\n");
			customerMenu();
			if (c != null) {
				log.info("");
			}
		} catch (BusinessException e) {
			log.error(e.getMessage());
		}
	}

	// Customer menu after Login
	public static void customerMenu() {
		CarDAO dao = new CarDAOImpl();
		CustomerCarDAO mydao = new CustomerCarDAOImpl();
		Scanner sc = new Scanner(System.in);
		int ch = 0;
		do {
			System.out.println("=======================");
			System.out.println("1)View All Cars In The Lot");
			System.out.println("2)Make An Offer On A Car");
			System.out.println("3)View All My Cars");
			System.out.println("4)Make A Payment");
			System.out.println("5)EXIT\n");
			try {
				ch = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
			}

			switch (ch) {
			case 1:
				// view all cars in the lot
				try {
					List<CarLot> carList = dao.viewAllCarsInLot();
					if (carList != null && carList.size() != 0) {
						log.info("\n\nFound " + carList.size() + " cars in the CarLot....");
						for (CarLot cl : carList) {
							// log.info(cl + "\n");
							log.info("Car ID#: " + cl.getCar_id() + "     Make: " + cl.getMake() + "     Model: "
									+ cl.getModel() + "     Year: " + cl.getYear() + "     Color: " + cl.getColor()
									+ "     Condition: " + cl.getCondition() + "     Price: " + cl.getPrice()
									+ "     Status: " + cl.getStatus() + "\n");
						}
					}
				} catch (BusinessException e) {
					log.error(e.getMessage());
				}
				break;
			case 2:
				// make an offer on a car
				Date date;
				int customer_id, car_id;
				double offer_price;

				OffersDAO makeoffer = new OffersDAOImpl();

				date = new Date();
				log.info("Enter Your Customer ID: ");
				customer_id = Integer.parseInt(sc.nextLine());
				log.info("Enter The Car ID For The Car You Want: ");
				car_id = Integer.parseInt(sc.nextLine());
				log.info("Place An Offer On That Car: ");
				offer_price = Double.parseDouble(sc.nextLine());

				Offers o = new Offers(date, customer_id, car_id, offer_price);
				try {
					if (makeoffer.makeOfferOnCar(o) != 0) {
						log.info("You\'re offer of " + offer_price + " has been placed\n");
					}
				} catch (BusinessException e) {
					log.error(e.getMessage());
				}
				break;
			case 3:
				// view all cars I own
				
				String owner;
				log.info("Enter your Customer ID: ");
				owner = sc.nextLine();
				try {
					List<CarLot> myCarList=dao.getMyCars(owner);
					if(myCarList!=null && myCarList.size() > 0) {
						log.info("\n\nI own " + myCarList.size() + " car(s)....");
						for(CarLot mc:myCarList) {
							log.info("Car ID#: " + mc.getCar_id() + "     Make: " + mc.getMake() + "     Model: "
									+ mc.getModel() + "     Year: " + mc.getYear() + "     Color: " + mc.getColor()
									+ "     Price: " + mc.getPrice() + "\n");
						}
					}
				} catch (BusinessException e) {
					log.error(e.getMessage());
				}
				
				break;
			case 4:
				log.info("No Payments Yet");
				break;
			case 5:
				log.info("\nThank You For Completing your task, have a nice day!\n");
				break;
			default:
				log.info("\nInvalid Menu Option. Choose from the given Options.\n");
				break;
			}
		} while (ch != 5);

	}
}
