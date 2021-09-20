package com.revature.models;

public class Habitat {
	
	private int habitat_id;
	private String habitat_type;
	
	public Habitat() {
		super();
	}

	public Habitat(int habitat_id, String habitat_type) {
		super();
		this.habitat_id = habitat_id;
		this.habitat_type = habitat_type;
	}

	public Habitat(String habitat_type) {
		super();
		this.habitat_type = habitat_type;
	}

	@Override
	public String toString() {
		return "Habitat [habitat_id=" + habitat_id + ", habitat_type=" + habitat_type + "]";
	}

	public int getHabitat_id() {
		return habitat_id;
	}

	public void setHabitat_id(int habitat_id) {
		this.habitat_id = habitat_id;
	}

	public String getHabitat_type() {
		return habitat_type;
	}

	public void setHabitat_type(String habitat_type) {
		this.habitat_type = habitat_type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + habitat_id;
		result = prime * result + ((habitat_type == null) ? 0 : habitat_type.hashCode());
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
		Habitat other = (Habitat) obj;
		if (habitat_id != other.habitat_id)
			return false;
		if (habitat_type == null) {
			if (other.habitat_type != null)
				return false;
		} else if (!habitat_type.equals(other.habitat_type))
			return false;
		return true;
	}

	


}
