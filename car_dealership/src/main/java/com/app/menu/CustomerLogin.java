package com.app.menu;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.dao.CustomerDAO;
import com.app.dao.impl.CustomerDAOImpl;
import com.app.exception.BusinessException;
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
				//customerMenu();
				if (c!=null) {
					log.info("");
				}
			} catch (BusinessException e) {
				log.error(e.getMessage());
			}
		}
		
}
