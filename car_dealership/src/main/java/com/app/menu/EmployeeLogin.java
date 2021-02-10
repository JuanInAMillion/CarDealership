package com.app.menu;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.dao.CarDAO;
import com.app.dao.EmployeeDAO;
import com.app.dao.OffersDAO;
import com.app.dao.impl.CarDAOImpl;
import com.app.dao.impl.EmployeeDAOImpl;
import com.app.dao.impl.OffersDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.CarLot;
import com.app.model.Employee;
import com.app.model.Offers;

public class EmployeeLogin {
	private static Logger log = Logger.getLogger("consoleLog.EmployeeLogin");

	// Employee Sign in
	public void employeeLogin(Scanner sc, Employee employee) {
		String employeeemail = "";
		String employeepassword = "";

		EmployeeDAO login = new EmployeeDAOImpl();

		log.info("Enter Your Employee Email: ");
		employeeemail = sc.nextLine();
		log.info("Enter Your Password: ");
		employeepassword = sc.nextLine();

		try {
			Employee em = login.employeeVerifyLogin(employeeemail, employeepassword);
			log.info("Welcome " + em.getFirst_name() + " " + em.getLast_name() + " here are your task for the day\n");
			employeeMenu();
			if (em != null) {
				log.info("");
			}
		} catch (BusinessException e) {
			log.error(e.getMessage());
		}
	}

	// Employee menu after Login
	public static void employeeMenu() {
		CarDAO cardao = new CarDAOImpl();
		OffersDAO offerdao = new OffersDAOImpl();
		Scanner sc = new Scanner(System.in);
		int ch = 0;
		do {
			System.out.println("=======================");
			System.out.println("1)View All Cars In The Lot");
			System.out.println("2)Add A Car To The Lot");
			System.out.println("3)Remove Car from Lot");
			System.out.println("4)View All Pending Offers");
			System.out.println("5)Accept An Offer");
			System.out.println("6)Remove All Accepted and Rejected Offers");
			System.out.println("7)View All Payments");
			System.out.println("8)EXIT\n");
			try {
				ch = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
			}

			switch (ch) {
			case 1:
				// view all cars in the lot
				try {
					List<CarLot> carList = cardao.viewAllCarsInLot();
					if (carList != null && carList.size() != 0) {
						log.info("\n\nFound " + carList.size() + " cars in the CarLot....");
						for (CarLot cl : carList) {
							log.info("Car ID#: " + cl.getCar_id() + "     Make: " + cl.getMake() + "     Model: "
									+ cl.getModel() + "     Year: " + cl.getYear() + "     Color: " + cl.getColor()
									+ "     Condition: " + cl.getCondition() + "     Price: $" + cl.getPrice()
									+ "     Status: " + cl.getStatus() + "\n");
						}
					}
				} catch (BusinessException e) {
					log.error(e.getMessage());
				}
				break;
			case 2:
				// add a car to the lot
				String make, model, color, condition;
				int year;
				double price;

				log.info("Enter The Car\'s Make: ");
				make = sc.nextLine();
				log.info("Enter The Car\'s Model: ");
				model = sc.nextLine();
				log.info("Enter The Car\'s Year: ");
				year = Integer.parseInt(sc.nextLine());
				log.info("Enter The Car\'s Color: ");
				color = sc.nextLine();
				log.info("Enter The Car\'s Condition: ");
				condition = sc.nextLine();
				log.info("Enter The Car\'s Price: ");
				price = Double.parseDouble(sc.nextLine());

				CarLot c = new CarLot(make, model, year, color, condition, price);
				try {
					if (cardao.addCarToLot(c) != 0) {
						log.info("Car Added Successfully. Check Out The Car Lot\n");
					}
				} catch (BusinessException e) {
					log.error(e.getMessage());
				}
				break;
			case 3:
				// remove a car from the lot by car_id
				int car_id;

				log.info("Enter The Car\'s ID Number: ");
				car_id = Integer.parseInt(sc.nextLine());

				try {
					cardao.removeCarFromLot(car_id);
					System.out.println("The Car Was Removed Successfully");
				} catch (BusinessException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				// view all pending offers
				try {
					List<Offers> offerList = offerdao.viewAllOffers();
					if (offerList != null && offerList.size() != 0) {
						log.info("\n\nFound " + offerList.size() + " pending offers....");
						for (Offers ol : offerList) {
							log.info("Offer ID#: " + ol.getOffer_id() + "     Offer Date: " + ol.getDate()
									+ "     Customer ID#: " + ol.getCustomer_id() + "     Car ID#: " + ol.getCar_id()
									+ "     Offer Price: " + ol.getOffer_price() + "     Offer Status: "
									+ ol.getPending_offer() + "\n");
						}
					}
				} catch (BusinessException e) {
					log.error(e.getMessage());
				}
				break;
			case 5:
				// Accept Or reject Offer
				int acceptedOfferId, rejectedOfferId, CarId;
				String rejectedOffer, acceptedOffer, carStatus, carOwner;
				double newPrice;

				log.info("Enter The Offer Id Number: ");
				acceptedOfferId = Integer.parseInt(sc.nextLine());
				log.info("Enter The Car Id Number: ");
				CarId = Integer.parseInt(sc.nextLine());
				log.info("Enter The New Owners ID number: ");
				carOwner = sc.nextLine();
				log.info("Enter The Accepted Offer: ");
				newPrice = Double.parseDouble(sc.nextLine());

				rejectedOffer = "Rejected";
				acceptedOffer = "Accepted";
				carStatus = "Unavailable";
				
				

				try {
					offerdao.rejectOffer(CarId, rejectedOffer); // Rejects all offers for
					offerdao.acceptOffer(acceptedOfferId, acceptedOffer); // Accepts Offer
					cardao.updateCarStatus(CarId, carStatus); // Changes availability of the card in the lot
					cardao.updateCarOwner(CarId, carOwner); // Changes a car's ownership
					cardao.updateCarPrice(CarId, newPrice); // updates the cost of the car
					log.info("Accepted an offer for car ID:" + CarId + " from customer " + carOwner + "\n");
				} catch (BusinessException e) {
					log.error(e.getMessage());
				}

				break;
			case 6:
				// remove rejected and accepted offers
				String rejected_offer;
				String accepted_offer;

				rejected_offer = "Rejected";
				accepted_offer = "Accepted";

				try {
					offerdao.removeOffers(rejected_offer);
					offerdao.removeOffers(accepted_offer);
					System.out.println("All Accepted and Rejected Offers Were Removed Succesfully");
				} catch (BusinessException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 7:
				System.out.println("View All Payments - Under Construction");
				break;
			case 8:
				log.info("\nThank You For Completing your task, have a nice day!\n");
				break;
			default:
				log.info("\nInvalid Menu Option. Choose from the given Options.\n");
				break;
			}
		} while (ch != 8);
		
	}
}
