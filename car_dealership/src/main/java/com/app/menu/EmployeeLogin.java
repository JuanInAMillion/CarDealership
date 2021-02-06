package com.app.menu;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.dao.CarDAO;
import com.app.dao.CustomerDAO;
import com.app.dao.EmployeeDAO;
import com.app.dao.impl.CarDAOImpl;
import com.app.dao.impl.CustomerDAOImpl;
import com.app.dao.impl.EmployeeDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.CarLot;
import com.app.model.Customer;
import com.app.model.Employee;

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
			CarDAO dao = new CarDAOImpl();
			Scanner sc = new Scanner(System.in);
			int ch = 0;
			do {
				log.info("=======================");
				log.info("1)Add A Car To The Lot");
				log.info("2)View All Cars In The Lot");
				log.info("3)View All Pending Offers");
				log.info("4)Approve or Reject Offer");
				log.info("5)Update Car Status");
				log.info("6)Remove Car from Lot");
				log.info("7)View All Payments");
				log.info("8)EXIT\n");
				try {
					ch=Integer.parseInt(sc.nextLine());
				} catch(NumberFormatException e) {}
				
				switch(ch) {
				case 1: 
					// Add A Car To The Lot	
						String make, model, color, condition;
						int year;
						double price;

						CarDAO addcar = new CarDAOImpl();
				
						log.info("Enter The Car\'s Make: ");
						make = sc.nextLine();
						log.info("Enter The car\'s Model: ");
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
							if(addcar.addCarToLot(c)!=0) {
						log.info("Car Added Successfully. Check Out The Car Lot\n");
						}
						} catch(BusinessException e) {
							log.error(e.getMessage());
						}
					break;
				case 2:
			  		// view all cars in the lot 
					try {
						List<CarLot> carList = dao.viewAllCarsInLot();
						if(carList!=null && carList.size()!=0) {
							log.info("\n\nFound " + carList.size() + " cars in the CarLot....");
							for(CarLot cl: carList) {
								log.info(cl);
							}
						}
					} catch (BusinessException e) {
						log.error(e.getMessage());
					} 
					break;
				case 3:
					System.out.println("Under Construction");
					break;
				case 4:
					System.out.println("Under Construction");
					break;
				case 5:
					System.out.println("Under Construction");
					break;
				case 6:
					System.out.println("Under Construction");
					break;
				case 7:
					System.out.println("Under Construction");
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
