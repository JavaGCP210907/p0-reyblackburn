package com.revature.models;

public class Animal {
	
	private int animal_id;
	private String animal_type;
	private int animal_quantity;
	private int employee_id_fk;
	
	public Animal() {
		super();
	}

	public Animal(int animal_id, String animal_type, int animal_quantity, int employee_id_fk) {
		super();
		this.animal_id = animal_id;
		this.animal_type = animal_type;
		this.animal_quantity = animal_quantity;
		this.employee_id_fk = employee_id_fk;
	}

	@Override
	public String toString() {
		return "Animal [animal_id=" + animal_id + ", animal_type=" + animal_type + ", animal_quantity="
				+ animal_quantity + ", employee_id_fk=" + employee_id_fk + "]";
	}

	public int getAnimal_id() {
		return animal_id;
	}

	public void setAnimal_id(int animal_id) {
		this.animal_id = animal_id;
	}

	public String getAnimal_type() {
		return animal_type;
	}

	public void setAnimal_type(String animal_type) {
		this.animal_type = animal_type;
	}

	public int getAnimal_quantity() {
		return animal_quantity;
	}

	public void setAnimal_quantity(int animal_quantity) {
		this.animal_quantity = animal_quantity;
	}

	public int getEmployee_id_fk() {
		return employee_id_fk;
	}

	public void setEmployee_id_fk(int employee_id_fk) {
		this.employee_id_fk = employee_id_fk;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + animal_id;
		result = prime * result + animal_quantity;
		result = prime * result + ((animal_type == null) ? 0 : animal_type.hashCode());
		result = prime * result + employee_id_fk;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		if (animal_id != other.animal_id)
			return false;
		if (animal_quantity != other.animal_quantity)
			return false;
		if (animal_type == null) {
			if (other.animal_type != null)
				return false;
		} else if (!animal_type.equals(other.animal_type))
			return false;
		if (employee_id_fk != other.employee_id_fk)
			return false;
		return true;
	}
	
	

}
