package com.revature.models;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.dao.AnimalDao;
import com.revature.dao.EmployeeDao;
import com.revature.dao.EnclosureDao;

public class Menu {
	
	EmployeeDao eDao = new EmployeeDao();
	AnimalDao aDao = new AnimalDao();
	EnclosureDao enDao = new EnclosureDao();

	public void displayMenu() {
		
		boolean displayMenu = true;
		
		Scanner scan = new Scanner(System.in);
		//Logger log = LogManager.getLogger(Menu.class);
		
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
				List<Employee> employees = eDao.getEmployees();
				
				for(Employee emp : employees) {
					System.out.println(emp);
				}
				break;
			}
				
			case "ANIMALS": {
				List<Animal> animals = aDao.getAnimals();
				
				for(Animal ani: animals) {
					System.out.println(ani);
				}
				
				break;
			}
				
			case "ANIMALSBYEMPLOYEESID": {
				
				System.out.println("Enter the Employee's ID Number to get the animals they care for: ");
				int id = scan.nextInt();
				scan.nextLine();
				
				List<Animal> animals = aDao.getAnimalsByEmployeeID(id);
				
				for(Animal a : animals) {
					System.out.println(a);
				}
				
				break;
			}
			
			case "ANIMALSBYHABITAT": {
				
				System.out.println("Enter the Habitat to get the animals that inhabit that area: (Case Sensitive!)");
				System.out.println("Types of Habitats: 'City', 'Mountain', 'Forest'");
				String habitatInput = scan.nextLine();
				
				List<Animal> animals = aDao.getAnimalsByHabitat(habitatInput);
				
				for(Animal a : animals) {
					System.out.println(a);
				}
				
				break;
			}
			
			case "UPDATEENCLOSURE": {
				
				System.out.println("Enter the Animal you would like to update");
				String animalInput = scan.nextLine();
				
				System.out.println("Please input the new enclosure id for " + animalInput);
				int enclosure = scan.nextInt();
				scan.nextLine();
				
				aDao.updateQuantity(animalInput, enclosure);
				
				break;
			}
			
			case "ANIMALQUANTITY": {
				
				System.out.println("Enter the Animal you would like to update");
				String animalInput = scan.nextLine();
				
				System.out.println("Please input the new count for animals");
				int countInput = scan.nextInt();
				scan.nextLine();
				
				aDao.updateQuantity(animalInput, countInput);				
				break;
			}
			
			case "ANIMALFED": {
				
				System.out.println("Please put in the animal name:");
				String type = scan.nextLine();
				
				System.out.println("Has the animal been fed? Y/N");
				String fed = scan.nextLine();
				
				if (fed == "Y") {
					aDao.updateFed(type, true);
				} else if (fed == "N") {
					aDao.updateFed(type, false);
				} else {
					System.out.println("Input not recognized");
				}
				
				break;
			}
			
			case "ADDANIMALS": {
				
				System.out.println("Please enter animal type:");
				String type = scan.nextLine();
				
				if(type.toUpperCase().equals("BADGER")) {
					System.out.println("BADGERS!...BADGERS!...We don't need to stinkin' BADGERS!");
					break;
				}
				
				System.out.println("Please enter the number of animals acquired:");
				int quantity = scan.nextInt();
				scan.nextLine();
				
				System.out.println("Please put in how much feed will be required: ");
				int feed = scan.nextInt();
				scan.nextLine();
				
				System.out.println("Please put in the employee id for which employee will care for " + type);
				int employee = scan.nextInt();
				scan.nextLine();
				
				System.out.println("Please put in the habitat id for the habitat the " + type + " inhabits");
				int habitat = scan.nextInt();
				scan.nextLine();
				
				System.out.println("Please put in the enclosure id for the enclosure " + type + " will be placed in");
				int enclosure = scan.nextInt();
				scan.nextLine();
				
				Animal ani = new Animal(type, quantity, feed, employee, habitat, enclosure);
				
				aDao.addAnimal(ani);
				
				//log.info("USER ADDED ANIMAL DATA");
				break;
			}
			
			case "REMOVEANIMAL": {
				
				System.out.println("Please put in Animal Id to delete Animal information");
				
				int id = scan.nextInt();
				scan.nextLine();
				
				aDao.removeAnimal(id);
				
				//log.info("USER REMOVED ANIMAL DATA");
				break;
			}
			
			case "FLY": {
				
				aDao.fly();
				
				//log.info("USER TRIED TO MAKE A POODLE FLY");
				break;
			}
			
			case "ADDENCLOSURE": {
				
				System.out.println("Please Enter New Enclosure Type");
				String type = scan.nextLine();
				
				Enclosure enclosure = new Enclosure(type);
				
				enDao.addEnclosure(enclosure);
				
				//log.info("USER ADDED NEW ENCLOSURE");
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
		
		System.out.println("Employees -> Shows a list of all employees");//completed
		System.out.println("Animals -> Shows a list of all animals");//Completed
		System.out.println("AnimalsByEmployeeID -> Shows all animals assigned to an employee by employee id");//Completed
		System.out.println("---------------------------------------------------------------");
		System.out.println("AnimalsByHabitat -> Shows all animals in a specific habitat");//Completed
		System.out.println("UpdateEnclosure -> Change an animals enclosure");//Completed
		System.out.println("AnimalQuantity -> Increase or Decrease Number of Specific Animal");//completed
		System.out.println("---------------------------------------------------------------");
		System.out.println("AnimalFed -> Update if Animal has been fed");
		System.out.println("AddAnimals -> Add Animal to Raul's Wild Kingdom");//Completed
		System.out.println("RemoveAnimal -> Remove Animal from Raul's Wild Kingdom");//Completed
		System.out.println("---------------------------------------------------------------");
		System.out.println("Fly -> Do you think poodles can learn to fly?");//Completed
		System.out.println("AddEnclosure -> Add an enclosure to Raul's Wild Kingdom"); //Completed
		System.out.println("Exit -> Exit Raul's Wild Kingdom");		
		
	}
	
}
