package com.app.menu;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.dao.EmployeeDAO;
import com.app.dao.impl.EmployeeDAOImpl;
import com.app.exception.BusinessException;
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
				//employeeMenu();
				if (em!=null) {
					log.info("");
				}
			} catch (BusinessException e) {
				log.error(e.getMessage());
			}
		}
}
