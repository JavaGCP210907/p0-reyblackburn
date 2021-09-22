package com.revature.models;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.dao.AnimalDao;
import com.revature.dao.EmployeeDao;
import com.revature.dao.EnclosureDao;
import com.revature.dao.HabitatDao;

public class Menu {
	
	EmployeeDao eDao = new EmployeeDao();
	AnimalDao aDao = new AnimalDao();
	EnclosureDao enDao = new EnclosureDao();
	HabitatDao hDao = new HabitatDao();

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
				List<Employee> employees = eDao.getEmployees();
				
				for(Employee emp : employees) {
					System.out.println(emp);
				}
				
				log.info("USER LOOKED AT ALL EMPLOYEES");
				
				break;
			}
				
			case "ANIMALS": {
				List<Animal> animals = aDao.getAnimals();
				
				for(Animal ani: animals) {
					System.out.println(ani);
				}

				log.info("USER LOOKED AT ALL ANIMALS");
				
				break;
			}
				
			case "ANIMALSBYEMPLOYEESID": {
				
				//code for getting employee ID and name
				System.out.println("Here are the employees names and ID's");
				
				List<Employee> employees = eDao.getEmployees();
				
				for(Employee e : employees) {
					System.out.println(e.getEmployee_id() + " is the id for " + e.getF_name() + " " + e.getL_name());
				}
				
				System.out.println("Enter the Employee's ID Number to get the animals they care for: ");
				int id = scan.nextInt();
				scan.nextLine();
				
				List<Animal> animals = aDao.getAnimalsByEmployeeID(id);
				
				for(Animal a : animals) {
					System.out.println(a);
				}
				
				log.info("USER LOOKED AT ANIMALS BY EMPLOYEE ID: " + id);
				
				break;
			}
			
			case "ANIMALSBYHABITAT": {
				
				System.out.println("Enter the Habitat to get the animals that inhabit that area: (Case Sensitive!)");
				
				//added way to display habitat here
				List<Habitat> habitats = hDao.getHabitats();
				
				for(Habitat h: habitats) {
					System.out.println(h.getHabitat_type());
				}
				
				String habitatInput = scan.nextLine();
				
				List<Animal> animals = aDao.getAnimalsByHabitat(habitatInput);
				
				for(Animal a : animals) {
					System.out.println(a);
				}
				
				log.info("USER LOOKED AT ANIMALS BY " + habitatInput);
				
				break;
			}
			
			case "UPDATEENCLOSURE": {
				
				System.out.println("Enter the Animal you would like to update: (Case Sensitive)");
				
				List<Animal> animals = aDao.getAnimals();
				
				for(Animal ani: animals) {
					System.out.println(ani.getAnimal_type());
				}
				
				String animalInput = scan.nextLine();
				
				System.out.println("Please input the new enclosure id for " + animalInput);
				
				List<Enclosure> enclosures = enDao.getEnclosures();
				
				for(Enclosure enc : enclosures) {
					System.out.println(enc.getEnclosure_id() + " is the ID for " + enc.getEnclosure_type());
				}
				
				int enclosure = scan.nextInt();
				scan.nextLine();
				
				aDao.updateEnclosure(animalInput, enclosure);
				
				log.info("USER UPDATED " + animalInput + " TO UPDATE ENCLOSURE");
				
				break;
			}
			
			case "ANIMALQUANTITY": {
				
				System.out.println("Enter the Animal you would like to update (Case Sensitive)");
				
				List<Animal> animals = aDao.getAnimals();
				
				for(Animal ani: animals) {
					System.out.println(ani.getAnimal_type());
				}
				
				String animalInput = scan.nextLine();
				
				System.out.println("Please input the new count for animals");
				int countInput = scan.nextInt();
				scan.nextLine();
				
				aDao.updateQuantity(animalInput, countInput);		
				
				log.info("USER UPDATED " + animalInput + " QUANTITY TO " + countInput);
				
				break;
			}
			
			case "ANIMALFED": {
				
				System.out.println("Please put in the animal name: (Case Sensitive)");
				List<Animal> animals = aDao.getAnimals();
				
				for(Animal ani: animals) {
					System.out.println(ani.getAnimal_type());
				}
				
				String type = scan.nextLine();
				
				System.out.println("Has the animal been fed? Y/N");
				String fed = scan.nextLine();
				
				if (fed.toUpperCase().equals("Y")) {
					aDao.updateFed(type, true);
					log.info("USER UPDATED " + type + " FED STATUS");
				} else if (fed.toUpperCase().equals("N")) {
					aDao.updateFed(type, false);
					log.info("USER UPDATED " + type + " FED STATUS");
				} else {
					System.out.println("Input not recognized");
				}
				
				break;
			}
			
			case "ADDANIMALS": {
				
				System.out.println("Please enter animal type: (Case Sensitive)");
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
				
				List<Employee> employees = eDao.getEmployees();
				
				for(Employee e : employees) {
					System.out.println(e.getEmployee_id() + " is the ID for " + e.getF_name() + " " + e.getL_name());
				}
				
				int employee = scan.nextInt();
				scan.nextLine();
				
				System.out.println("Please put in the habitat id for the habitat the " + type + " inhabits");
				
				List<Habitat> habitats = hDao.getHabitats();
				
				for(Habitat h: habitats) {
					System.out.println(h.getHabitat_id() + " is the ID for " + h.getHabitat_type());
				}
				
				int habitat = scan.nextInt();
				scan.nextLine();
				
				System.out.println("Please put in the enclosure id for the enclosure " + type + " will be placed in");
				
				List<Enclosure> enclosures = enDao.getEnclosures();
				
				for(Enclosure enc : enclosures) {
					System.out.println(enc.getEnclosure_id() + " is the ID for " + enc.getEnclosure_type());
				}
				
				int enclosure = scan.nextInt();
				scan.nextLine();
				
				Animal ani = new Animal(type, quantity, feed, employee, habitat, enclosure);
				
				aDao.addAnimal(ani);
				
				log.info("USER ADDED " + type + " DATA");
				break;
			}
			
			case "REMOVEANIMAL": {
				
				System.out.println("Please put in Animal Id to delete Animal information");
				
				List<Animal> animals = aDao.getAnimals();
				
				for(Animal ani: animals) {
					System.out.println(ani.getAnimal_id() + " is the ID for " + ani.getAnimal_type());
				}
				
				int id = scan.nextInt();
				scan.nextLine();
				
				aDao.removeAnimal(id);
				
				log.info("USER REMOVED ANIMAL DATA");
				break;
			}
			
			case "FLY": {
				
				aDao.fly();
				
				log.info("USER TRIED TO MAKE A POODLE FLY");
				break;
			}
			
			case "ADDENCLOSURE": {
				
				System.out.println("Please Enter New Enclosure Type");
				String type = scan.nextLine();
				
				Enclosure enclosure = new Enclosure(type);
				
				enDao.addEnclosure(enclosure);
				
				log.info("USER ADDED NEW ENCLOSURE");
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
		System.out.println("AnimalsByEmployeesID -> Shows all animals assigned to an employee by employee id");//Completed
		System.out.println("---------------------------------------------------------------");
		System.out.println("AnimalsByHabitat -> Shows all animals in a specific habitat");//Completed
		System.out.println("UpdateEnclosure -> Change an animals enclosure");//Update
		System.out.println("AnimalQuantity -> Increase or Decrease Number of Specific Animal");//completed
		System.out.println("---------------------------------------------------------------");
		System.out.println("AnimalFed -> Update if Animal has been fed");//Completed
		System.out.println("AddAnimals -> Add Animal to Raul's Wild Kingdom");//Completed
		System.out.println("RemoveAnimal -> Remove Animal from Raul's Wild Kingdom");//Completed
		System.out.println("---------------------------------------------------------------");
		System.out.println("Fly -> Do you think poodles can learn to fly?");//Completed
		System.out.println("AddEnclosure -> Add an enclosure to Raul's Wild Kingdom"); //Completed
		System.out.println("Exit -> Exit Raul's Wild Kingdom");		
		
	}
	
}
