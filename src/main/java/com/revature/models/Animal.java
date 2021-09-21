package com.revature.models;

public class Animal {
	
	private int animal_id;
	private String animal_type;
	private int animal_quantity;
	private int feed_requireed;
	private boolean been_fed;
	private int employee_id_fk;
	private int habitat_id_fk;
	private int enclosure_id_fk;
	
	public Animal() {
		super();
	}

	public Animal(int animal_id, String animal_type, int animal_quantity, int feed_requireed, boolean been_fed,
			int employee_id_fk, int habitat_id_fk, int enclosure_id_fk) {
		super();
		this.animal_id = animal_id;
		this.animal_type = animal_type;
		this.animal_quantity = animal_quantity;
		this.feed_requireed = feed_requireed;
		this.been_fed = been_fed;
		this.employee_id_fk = employee_id_fk;
		this.habitat_id_fk = habitat_id_fk;
		this.enclosure_id_fk = enclosure_id_fk;
	}

	public Animal(String animal_type, int animal_quantity, int feed_requireed, boolean been_fed, int employee_id_fk,
			int habitat_id_fk, int enclosure_id_fk) {
		super();
		this.animal_type = animal_type;
		this.animal_quantity = animal_quantity;
		this.feed_requireed = feed_requireed;
		this.been_fed = been_fed;
		this.employee_id_fk = employee_id_fk;
		this.habitat_id_fk = habitat_id_fk;
		this.enclosure_id_fk = enclosure_id_fk;
	}
	
	public Animal(String animal_type, int animal_quantity, int feed_requireed, int employee_id_fk,
			int habitat_id_fk, int enclosure_id_fk) {
		super();
		this.animal_type = animal_type;
		this.animal_quantity = animal_quantity;
		this.feed_requireed = feed_requireed;
		this.employee_id_fk = employee_id_fk;
		this.habitat_id_fk = habitat_id_fk;
		this.enclosure_id_fk = enclosure_id_fk;
	}

	@Override
	public String toString() {
		return "Animal [animal_id=" + animal_id + ", animal_type=" + animal_type + ", animal_quantity="
				+ animal_quantity + ", feed_requireed=" + feed_requireed + ", been_fed=" + been_fed
				+ ", employee_id_fk=" + employee_id_fk + ", habitat_id_fk=" + habitat_id_fk + ", enclosure_id_fk="
				+ enclosure_id_fk + "]";
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

	public int getFeed_requireed() {
		return feed_requireed;
	}

	public void setFeed_requireed(int feed_requireed) {
		this.feed_requireed = feed_requireed;
	}

	public boolean isBeen_fed() {
		return been_fed;
	}

	public void setBeen_fed(boolean been_fed) {
		this.been_fed = been_fed;
	}

	public int getEmployee_id_fk() {
		return employee_id_fk;
	}

	public void setEmployee_id_fk(int employee_id_fk) {
		this.employee_id_fk = employee_id_fk;
	}

	public int getHabitat_id_fk() {
		return habitat_id_fk;
	}

	public void setHabitat_id_fk(int habitat_id_fk) {
		this.habitat_id_fk = habitat_id_fk;
	}

	public int getEnclosure_id_fk() {
		return enclosure_id_fk;
	}

	public void setEnclosure_id_fk(int enclosure_id_fk) {
		this.enclosure_id_fk = enclosure_id_fk;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + animal_id;
		result = prime * result + animal_quantity;
		result = prime * result + ((animal_type == null) ? 0 : animal_type.hashCode());
		result = prime * result + (been_fed ? 1231 : 1237);
		result = prime * result + employee_id_fk;
		result = prime * result + enclosure_id_fk;
		result = prime * result + feed_requireed;
		result = prime * result + habitat_id_fk;
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
		if (been_fed != other.been_fed)
			return false;
		if (employee_id_fk != other.employee_id_fk)
			return false;
		if (enclosure_id_fk != other.enclosure_id_fk)
			return false;
		if (feed_requireed != other.feed_requireed)
			return false;
		if (habitat_id_fk != other.habitat_id_fk)
			return false;
		return true;
	}
	
	
	
	
}
