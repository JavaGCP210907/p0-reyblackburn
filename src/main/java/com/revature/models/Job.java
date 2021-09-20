package com.revature.models;

public class Job {
	
	private int job_id;
	private String job_title;
	private int salary;
	
	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Job(int job_id, String job_title, int salary) {
		super();
		this.job_id = job_id;
		this.job_title = job_title;
		this.salary = salary;
	}

	public Job(String job_title, int salary) {
		super();
		this.job_title = job_title;
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Job [job_id=" + job_id + ", job_title=" + job_title + ", salary=" + salary + "]";
	}

	public int getJob_id() {
		return job_id;
	}

	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}

	public String getJob_title() {
		return job_title;
	}

	public void setJob_title(String job_title) {
		this.job_title = job_title;
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
		result = prime * result + job_id;
		result = prime * result + ((job_title == null) ? 0 : job_title.hashCode());
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
		Job other = (Job) obj;
		if (job_id != other.job_id)
			return false;
		if (job_title == null) {
			if (other.job_title != null)
				return false;
		} else if (!job_title.equals(other.job_title))
			return false;
		if (salary != other.salary)
			return false;
		return true;
	}
	
	

}
