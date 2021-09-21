package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.models.Enclosure;
import com.revature.utils.ConnectionUtil;

public class EnclosureDao implements EnclosureDaoInterface {

	@Override
	public void addEnclosure(Enclosure enclosure) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "insert into enclosures (enclosure_type)" +
						 "values (?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, enclosure.getEnclosure_type());
			
			ps.executeUpdate();
			
			System.out.println("Added " + enclosure.getEnclosure_type() + " to the enclosures");
			
		}catch (SQLException e) {
			System.out.println("Add Enclosure failed");
			e.printStackTrace();
		}

	}

}
