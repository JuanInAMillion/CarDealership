package com.app.main;

import java.util.Scanner;

import com.app.model.Customer;
import com.app.model.Employee;

public class CarDealership {
	public static void main(String[] args) {
		
		Customer customer = null;
		Employee employee = null;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to Chase Bank");
		System.out.println("-----------------------");
		int ch = 0;
		do {
			System.out.println("\nChoose an Options");
			System.out.println("=======================");
			System.out.println("1)Login");
			System.out.println("2)Register");
			System.out.println("3)Employee Login");
			System.out.println("4)EXIT");
			System.out.println("");
			try {
				ch=Integer.parseInt(sc.nextLine());
			} catch(NumberFormatException e) {}
			
			switch(ch) {
			case 1:
				System.out.println("Login");
				break;
			case 2:
				System.out.println("Register");
				break;
			case 3:
				System.out.println("Employee Login");
				break;
			case 4:
				System.out.println("\nThank You For Visiting Larusso's Car Dealership, have a nice day!\n");
				break;
			default:
				System.out.println("\nInvalid Menu Option. Choose from the given Options.\n");
				break;
			}
		} while(ch != 4);
		sc.close();
	}
}
