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
	private static Logger log=Logger.getLogger("consoleLog.EmployeeLogin");
	//Employee Sign in
		public void employeeLogin(Scanner sc, Employee employee) {
			String employeeemail ="";
			String employeepassword = "";
			
			EmployeeDAO login = new EmployeeDAOImpl();
			
			log.info("Enter Your Employee Email: ");
			employeeemail = sc.nextLine();
			log.info("Enter Your Password: ");
			employeepassword = sc.nextLine();
			
			try {
				Employee em = login.employeeVerifyLogin(employeeemail, employeepassword);
				log.info("Welcome " +em.getFirst_name() + " " + em.getLast_name() +" here are your task for the day\n");
				employeeMenu();
				if (em!=null) {
					log.info("");
				}
			} catch (BusinessException e) {
				log.error(e.getMessage());
			}
		}
		
		
		//Employee menu after Login
		public static void employeeMenu() {
			CarDAO cardao = new CarDAOImpl();
			OffersDAO offerdao = new OffersDAOImpl();
			Scanner sc = new Scanner(System.in);
			int ch = 0;
			do {
				log.info("=======================");
				log.info("1)View All Cars In The Lot");
				log.info("2)Add A Car To The Lot");
				log.info("3)Remove Car from Lot");
				log.info("4)View All Pending Offers");
				log.info("5)Approve or Reject Offer");
				log.info("6)Update Car Status");
				log.info("7)View All Payments");
				log.info("8)EXIT\n");
				try {
					ch=Integer.parseInt(sc.nextLine());
				} catch(NumberFormatException e) {}
				
				switch(ch) {
				case 1: 
					// view all cars in the lot 
					try {
						List<CarLot> carList = cardao.viewAllCarsInLot();
						if(carList!=null && carList.size()!=0) {
							log.info("\n\nFound " + carList.size() + " cars in the CarLot....");
							for(CarLot cl: carList) {
								log.info(cl+"\n");
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

					CarLot c = new CarLot(make, model, year, color, condition,price);	
					try {
						if(cardao.addCarToLot(c)!=0) {
					log.info("Car Added Successfully. Check Out The Car Lot\n");
					}
					} catch(BusinessException e) {
						log.error(e.getMessage());
					}
					break;
				case 3:
					//remove a car from carlot by car_id
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
					// view all cars in the lot 
					try {
						List<Offers> offerList = offerdao.viewAllOffers();
						if(offerList!=null && offerList.size()!=0) {
							log.info("\n\nFound " + offerList.size() + " pending offers....");
							for(Offers ol: offerList) {
								log.info(ol+"\n");
							}
						}
					} catch (BusinessException e) {
						log.error(e.getMessage());
					} 
					break;
				case 5:
					System.out.println("Approve or Reject Offer - Under Construction");
					break;
				case 6:	
					//update car status
					int carIdNum;	
					String carStatus;
						
					log.info("Enter The Car Id Number: ");
					carIdNum = Integer.parseInt(sc.nextLine());
					log.info("type: Available or Unavailable");
					carStatus = sc.nextLine();
					
					try {
						cardao.updateCarStatus(carIdNum, carStatus);
						log.info("Car\'s Status Changed");
					} catch (BusinessException e) {
						log.error(e.getMessage());
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
			} while(ch != 8);
			
		}
}
