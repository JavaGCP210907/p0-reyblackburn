package com.revature.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Habitat;
import com.revature.utils.ConnectionUtil;

public class HabitatDao implements HabitatDaoInterface {

	@Override
	public List<Habitat> getHabitats() {
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			ResultSet rs = null;
			
			String sql = "select * from habitats";
			
			Statement s = conn.createStatement();
			
			rs = s.executeQuery(sql);
			
			List<Habitat> habitatList = new ArrayList<>();
			
			while(rs.next()) {
				Habitat h = new Habitat(
						rs.getInt("habitat_id"),
						rs.getString("habitat_type")
						);
				
				habitatList.add(h);
			}
			
			return habitatList;
			
		} catch(SQLException e) {
			System.out.println("Could not get list of employees");
			e.printStackTrace();
		}
		
		return null;
	}

}
