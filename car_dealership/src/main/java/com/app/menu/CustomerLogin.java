package com.app.menu;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.dao.CarDAO;
import com.app.dao.CustomerDAO;
import com.app.dao.impl.CarDAOImpl;
import com.app.dao.impl.CustomerDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.CarLot;
import com.app.model.Customer;

public class CustomerLogin {
	private static Logger log=Logger.getLogger("consoleLog.CustomerLogin");
	//Customer Login
		public void customerLogin(Scanner sc, Customer customer) {
			String customeremail ="";
			String customerpassword = "";
			
			CustomerDAO login = new CustomerDAOImpl();
			
			log.info("Enter Your Email: ");
			customeremail = sc.nextLine();
			log.info("Enter Your Password: ");
			customerpassword = sc.nextLine();
			
			try {
				Customer c = login.customerVerifyLogin(customeremail, customerpassword);
				log.info("Welcome " +c.getFirst_name()+ " here is your info:\n");
				log.info(c.toString());
				customerMenu();
				if (c!=null) {
					log.info("");
				}
			} catch (BusinessException e) {
				log.error(e.getMessage());
			}
		}	
		
		//Customer menu after Login
				public static void customerMenu() {
					CarDAO dao = new CarDAOImpl();
					Scanner sc = new Scanner(System.in);
					int ch = 0;
					do {
						log.info("=======================");
						log.info("1)View All Cars In The Lot");
						log.info("2)Make An Offer On A Car");
						log.info("3)View All My Cars");
						log.info("4)View My Remaining Payments");
						log.info("5)EXIT\n");
						try {
							ch=Integer.parseInt(sc.nextLine());
						} catch(NumberFormatException e) {}
						
						switch(ch) {
						case 1: 
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
						case 2:
					  		System.out.println("Under Construction");
							break;
						case 3:
							System.out.println("Under Construction");
							break;
						case 4:
							System.out.println("Under Construction");
							break;
						case 5:
							log.info("\nThank You For Completing your task, have a nice day!\n");
							break;
						default:
							log.info("\nInvalid Menu Option. Choose from the given Options.\n");
							break;
						}
					} while(ch != 5);
					
				}
}
