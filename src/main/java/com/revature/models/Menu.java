package com.revature.models;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Menu {

	public void displayMenu() {
		
		boolean displayMenu = true;
		
		Scanner scan = new Scanner(System.in);
		Logger log = LogManager.getLogger(Menu.class);
		
		//Greeting
		System.out.println();
		System.out.println("************************************");
		System.out.println("***Welcome to Raul's Wild Kingdom***");
		System.out.println("************************************");
		
		//Menu
		while(displayMenu) {
			
			Menu.menuDisplay();
			
			String input = scan.nextLine();
			input = input.toUpperCase();
			
			System.out.println("You have chosen " + input);
			
			switch (input) {
			
			case "EMPLOYEES": {
				
				break;
			}
				
			case "ANIMALS": {
				
				break;
			}
				
			case "ANIMALSBYEMPLOYEES": {
				
				break;
			}
			
			case "UPDATEANIMALS": {
				
				
				log.info("USER UPDATE ANIMAL DATA");
				break;
			}
			
			case "EXIT": {
				System.out.println("Thank you for choosing Raul's Wild Kingdom");
				displayMenu = false;
				break;
			}
			
			default: {
				System.out.println("Input not recognized.  Please try again!");
			break;
			}
			
			} //end of switch statement
			
		}//end of while loop
		
		scan.close();
		
	}
	
	private static void menuDisplay() {
		
		System.out.println("-----------------");
		System.out.println("SELECT AN OPTION:");
		System.out.println("-----------------");
		
		System.out.println("Employees -> Shows a list of all employees");
		System.out.println("Animals -> Shows a list of all animals");
		System.out.println("AnimalsByEmployees -> Shows all animals assigned to an employee");
		System.out.println("UPdateAnimals -> Update Animals and what Animals are assigned");
		
		System.out.println("Exit -> Exit Raul's Wild Kingdom");		
		
	}
	
}
