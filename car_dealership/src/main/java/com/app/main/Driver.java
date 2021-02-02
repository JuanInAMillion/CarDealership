package com.app.main;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.menu.CustomerLogin;
import com.app.menu.CustomerRegistration;
import com.app.model.Customer;
import com.app.model.Employee;

public class Driver {
	private static Logger log=Logger.getLogger("consoleLog.Driver");
	public static void main(String[] args) {
		
		CustomerLogin cl = new CustomerLogin();
		CustomerRegistration cr = new CustomerRegistration();
		Customer customer = null;
		Employee employee = null;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to Larusso's Car Dealership");
		System.out.println("-----------------------");
		int ch = 0;
		do {
			System.out.println("Choose an Option");
			System.out.println("=======================");
			System.out.println("1)Login");
			System.out.println("2)Register");
			System.out.println("3)Employee Login");
			System.out.println("4)EXIT\n");
			try {
				ch=Integer.parseInt(sc.nextLine());
			} catch(NumberFormatException e) {}
			
			switch(ch) {
			case 1:
				cl.customerLogin(sc,customer);				
				break;
			case 2:
				cr.customerRegistration(sc,customer);
				break;
			case 3:
				System.out.println("Employee Login\n");
				break;
			case 4:
				System.out.println("Thank You For Visiting Larusso's Car Dealership, have a nice day!\n");
				break;
			default:
				System.out.println("Invalid Menu Option. Choose from the given Options.\n");
				break;
			}
		} while(ch != 4);
		sc.close();
	}
}
