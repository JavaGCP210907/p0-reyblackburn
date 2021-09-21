package com.revature.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;
import com.revature.utils.ConnectionUtil;

public class EmployeeDao implements EmployeeDaoInterface {

	@Override
	public List<Employee> getEmployees() {
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			ResultSet rs = null;
			
			String sql = "select * from employees";
			
			Statement s = conn.createStatement();
			
			rs = s.executeQuery(sql);
			
			List<Employee> employeeList = new ArrayList<>();
			
			while(rs.next()) {
				Employee e = new Employee(
						rs.getInt("employee_id"),
						rs.getString("f_name"),
						rs.getString("l_name"),
						rs.getInt("job_id_fk")
						);
				
				employeeList.add(e);
			}
			
			return employeeList;
			
		} catch(SQLException e) {
			System.out.println("Could not get list of employees");
			e.printStackTrace();
		}
		
		return null;
	}

}
