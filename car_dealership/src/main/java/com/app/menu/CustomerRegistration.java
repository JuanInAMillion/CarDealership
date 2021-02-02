package com.app.menu;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.dao.CustomerDAO;
import com.app.dao.impl.CustomerDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Customer;

public class CustomerRegistration {
	private static Logger log=Logger.getLogger("consoleLog.CustomerRegistration");
	//Customer Registration
		public void customerRegistration(Scanner sc, Customer customer) {
			String first_name, last_name, email, password;
			long drivers_license;
			
			CustomerDAO register = new CustomerDAOImpl();
				
			log.info("Enter Your First Name: ");
			first_name = sc.nextLine();
			log.info("Enter Your Last Name: ");
			last_name = sc.nextLine();
			log.info("Enter Your Driver\'s License: ");
			drivers_license = Long.parseLong(sc.nextLine());
			log.info("Enter Your Email: ");
			email = sc.nextLine();
			log.info("Enter Your Password: ");
			password = sc.nextLine();
			
			Customer c = new Customer(first_name, last_name, drivers_license, email, password);	
			try {
				if(register.createCustomer(c)!=0) {
					log.info("Registration Successful. Please Log in\n");
				}
			} catch(BusinessException e) {
				log.error(e.getMessage());
			}
			
		}
}
