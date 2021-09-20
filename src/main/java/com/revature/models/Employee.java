package com.revature.models;

public class Employee {
	
	private int employee_id;
	private String f_name;
	private String l_name;
	private String job_id_fk;
	
	public Employee() {
		super();
	}

	public Employee(int employee_id, String f_name, String l_name, String job_id_fk) {
		super();
		this.employee_id = employee_id;
		this.f_name = f_name;
		this.l_name = l_name;
		this.job_id_fk = job_id_fk;
	}

	public Employee(String f_name, String l_name, String job_id_fk) {
		super();
		this.f_name = f_name;
		this.l_name = l_name;
		this.job_id_fk = job_id_fk;
	}

	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", f_name=" + f_name + ", l_name=" + l_name + ", job_id_fk=" + job_id_fk + "]";
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	public String getJob_id_fk() {
		return job_id_fk;
	}

	public void setJob_id_fk(String job_id_fk) {
		this.job_id_fk = job_id_fk;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + employee_id;
		result = prime * result + ((f_name == null) ? 0 : f_name.hashCode());
		result = prime * result + ((job_id_fk == null) ? 0 : job_id_fk.hashCode());
		result = prime * result + ((l_name == null) ? 0 : l_name.hashCode());
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
		Employee other = (Employee) obj;
		if (employee_id != other.employee_id)
			return false;
		if (f_name == null) {
			if (other.f_name != null)
				return false;
		} else if (!f_name.equals(other.f_name))
			return false;
		if (job_id_fk == null) {
			if (other.job_id_fk != null)
				return false;
		} else if (!job_id_fk.equals(other.job_id_fk))
			return false;
		if (l_name == null) {
			if (other.l_name != null)
				return false;
		} else if (!l_name.equals(other.l_name))
			return false;
		return true;
	}

	
	

}
