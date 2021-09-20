package com.revature.models;

public class Enclosure {
	
	private int enclosure_id;
	private String enclosure_type;
	
	public Enclosure() {
		super();
	}

	public Enclosure(int enclosure_id, String enclosure_type) {
		super();
		this.enclosure_id = enclosure_id;
		this.enclosure_type = enclosure_type;
	}

	public Enclosure(String enclosure_type) {
		super();
		this.enclosure_type = enclosure_type;
	}

	@Override
	public String toString() {
		return "Enclosure [enclosure_id=" + enclosure_id + ", enclosure_type=" + enclosure_type + "]";
	}

	public int getEnclosure_id() {
		return enclosure_id;
	}

	public void setEnclosure_id(int enclosure_id) {
		this.enclosure_id = enclosure_id;
	}

	public String getEnclosure_type() {
		return enclosure_type;
	}

	public void setEnclosure_type(String enclosure_type) {
		this.enclosure_type = enclosure_type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + enclosure_id;
		result = prime * result + ((enclosure_type == null) ? 0 : enclosure_type.hashCode());
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
		Enclosure other = (Enclosure) obj;
		if (enclosure_id != other.enclosure_id)
			return false;
		if (enclosure_type == null) {
			if (other.enclosure_type != null)
				return false;
		} else if (!enclosure_type.equals(other.enclosure_type))
			return false;
		return true;
	}

}
