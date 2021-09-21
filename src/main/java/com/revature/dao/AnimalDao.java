package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Animal;
import com.revature.utils.ConnectionUtil;

public class AnimalDao implements AnimalDaoInterface {

	@Override
	public List<Animal> getAnimals() {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			ResultSet rs = null;
			
			String sql = "select * from employees";
			
			Statement s = conn.createStatement();
			
			rs = s.executeQuery(sql);
			
			List<Animal> animalList = new ArrayList<>();
			
			while(rs.next()) {
				Animal a = new Animal(
						rs.getInt("animal_id"),
						rs.getString("animal_type"),
						rs.getInt("animal_quantity"),
						rs.getInt("feed_required"),
						rs.getBoolean("been_fed"),
						rs.getInt("employee_id_fk"),
						rs.getInt("habitat_id_fk"),
						rs.getInt("enclosure_id_fk")
						);
				animalList.add(a);
			}
			
			return animalList;
			
		} catch (SQLException e) {
			System.out.println("Something went wrong with your database");
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Animal> getAnimalsByEmployeeID(int id) {
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			ResultSet rs = null;
			
			String sql = "select * from animals inner join employees "
						 + "on employees.employee_id  = animals.employee_id_fk where employees.employee_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			List<Animal> animalList = new ArrayList<>();
			
			while(rs.next()) {
				Animal a = new Animal(
						rs.getInt("animal_id"),
						rs.getString("animal_type"),
						rs.getInt("animal_quantity"),
						rs.getInt("feed_required"),
						rs.getBoolean("been_fed"),
						rs.getInt("employee_id_fk"),
						rs.getInt("habitat_id_fk"),
						rs.getInt("enclosure_id_fk")
						);
				animalList.add(a);
			}
			
			return animalList;
			
		} catch(SQLException e) {
			System.out.println("There was a problem accessing the database");
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Animal> getAnimalsByHabitat(String habitat) {

		try(Connection conn = ConnectionUtil.getConnection()) {
			
			ResultSet rs = null;
			
			String sql = "select * from animals inner join habitats "
						 + "on habitats.habitat_id  = animals.habitat_id_fk where habitats.habitat_type = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, habitat);
			
			rs = ps.executeQuery();
			
			List<Animal> animalList = new ArrayList<>();
			
			while(rs.next()) {
				Animal a = new Animal(
						rs.getInt("animal_id"),
						rs.getString("animal_type"),
						rs.getInt("animal_quantity"),
						rs.getInt("feed_required"),
						rs.getBoolean("been_fed"),
						rs.getInt("employee_id_fk"),
						rs.getInt("habitat_id_fk"),
						rs.getInt("enclosure_id_fk")
						);
				animalList.add(a);
			}
			
			return animalList;
			
		} catch(SQLException e) {
			System.out.println("There was a problem accessing the database");
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public void updateEnclosure(String animalName, int change) {
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "update animals set enclosure_id_fk = ? where animal_type = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1,  change);;
			ps.setString(2,  animalName);
			
			ps.executeUpdate();
			
			System.out.println(animalName + " enclosure has been updated to: " + change);
			
		} catch (SQLException e) {
			System.out.println("Failure to change the enclosure of " + animalName);
			e.printStackTrace();
		}
	}

	@Override
	public void updateQuantity(String animalName, int change) {
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "update animals set animal_quantity = ? where animal_type = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1,  change);;
			ps.setString(2,  animalName);
			
			ps.executeUpdate();
			
			System.out.println(animalName + " quantity has been updated to: " + change);
			
		} catch (SQLException e) {
			System.out.println("Failure to change the count of " + animalName);
			e.printStackTrace();
		}

	}

	@Override
	public void updateFed(String animalName, boolean yes) {
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "update animals set animal_fed = ? where animal_type = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setBoolean(1,  yes);;
			ps.setString(2,  animalName);
			
			ps.executeUpdate();
			
			if(yes == true) {
				System.out.println(animalName + " has been fed");
			} else if(yes == false) {
				System.out.println(animalName + " fed status has been reset");
			}
			
		} catch(SQLException e) {
			System.out.println("There was a problem accessing the database");
			e.printStackTrace();
		}

	}

	@Override
	public void addAnimal(Animal animal) {

		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "insert into animals (animal_type, animal_quantity, feed_required, employee_id_fk, habitat_id_fk, enclosure_id_fk)" +
						 "values (?, ?, ?, ?, ?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, animal.getAnimal_type());
			ps.setInt(2, animal.getAnimal_quantity());
			ps.setInt(3, animal.getFeed_requireed());			
			ps.setInt(4, animal.getEmployee_id_fk());
			ps.setInt(5, animal.getHabitat_id_fk());
			ps.setInt(6, animal.getEnclosure_id_fk());
			
			ps.executeUpdate();
			
			System.out.println("Anmimal " + animal.getAnimal_type() + " entered.  Do not forget to feed them");
			
		} catch(SQLException e) {
			System.out.println("There was a problem accessing the database");
			e.printStackTrace();
		}

	}

	@Override
	public void removeAnimal(int id) {

		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "delete from animals where animal_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			ps.executeUpdate();
			
			System.out.println("Animal ID " + id + " got deleted");
			
		} catch(SQLException e) {
			System.out.println("There was a problem accessing the database");
			e.printStackTrace();
		}

	}

	@Override
	public void fly() {
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			ResultSet rs = null;
			ResultSet rs2 = null;
			
			String sql = "select animal_quantity from animals where animal_type = 'Poodle'";
			
			Statement s = conn.createStatement();
			
			rs = s.executeQuery(sql);
			
			rs.next();
			
			if(rs.getInt("animal_quantity") > 0) {
				System.out.println("You gently toss a poodle off a 5ft stand for flying lessons.");
				System.out.println("The poodle gently lands on the ground and scurries away.");
				System.out.println("Sometimes it takes them a little longer to learn how to do it right.");
				
				
				String sql2 = "update animals set animal_quantity = animal_quantity - 1 where animal_type = 'Poodle'";
				
				s.executeUpdate(sql2);
				
				rs2 = s.executeQuery(sql);
				
				rs2.next();
				
				System.out.println("You now have " + rs2.getInt("animal_quantity") + " poodles left");
				
			} else {
				System.out.println("You could not find any poodles to teach how to fly.");
			}
			
		} catch(SQLException e) {
			System.out.println("You could not find any Poodles to teach how to fly.");
			e.printStackTrace();
		}

	}

}
