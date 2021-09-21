package com.revature.dao;

import java.util.List;

import com.revature.models.Animal;

public interface AnimalDaoInterface {
	
	public List<Animal> getAnimals();
	
	public List<Animal> getAnimalsByEmployeeID(int id);
	
	public List<Animal> getAnimalsByHabitat(String habitat);
	
	public void updateEnclosure(String animalName, int change);
	
	public void updateQuantity(String animalName, int change);
	
	public void updateFed(String animalName, boolean yes);
	
	public void addAnimal(Animal animal);
	
	public void removeAnimal(int id);
	
	public void fly();

}
