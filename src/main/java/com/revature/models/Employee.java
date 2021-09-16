package com.revature.models;

public class Employee {
	
	private int employee_id;
	private String f_name;
	private String l_name;
	private String role_title;
	private int salary;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int employee_id, String f_name, String l_name, String role_title, int salary) {
		super();
		this.employee_id = employee_id;
		this.f_name = f_name;
		this.l_name = l_name;
		this.role_title = role_title;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", f_name=" + f_name + ", l_name=" + l_name + ", role_title="
				+ role_title + ", salary=" + salary + "]";
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

	public String getRole_title() {
		return role_title;
	}

	public void setRole_title(String role_title) {
		this.role_title = role_title;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + employee_id;
		result = prime * result + ((f_name == null) ? 0 : f_name.hashCode());
		result = prime * result + ((l_name == null) ? 0 : l_name.hashCode());
		result = prime * result + ((role_title == null) ? 0 : role_title.hashCode());
		result = prime * result + salary;
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
		if (l_name == null) {
			if (other.l_name != null)
				return false;
		} else if (!l_name.equals(other.l_name))
			return false;
		if (role_title == null) {
			if (other.role_title != null)
				return false;
		} else if (!role_title.equals(other.role_title))
			return false;
		if (salary != other.salary)
			return false;
		return true;
	}
	
	

}
