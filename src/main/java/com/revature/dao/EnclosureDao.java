package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

	@Override
	public List<Enclosure> getEnclosures() {
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			ResultSet rs = null;
			
			String sql = "select * from enclosures";
			
			Statement s = conn.createStatement();
			
			rs = s.executeQuery(sql);
			
			List<Enclosure> enclosureList = new ArrayList<>();
			
			while(rs.next()) {
				Enclosure e = new Enclosure(
						rs.getInt("enclosure_id"),
						rs.getString("enclosure_type")
						);
				
				enclosureList.add(e);
			}
			
			return enclosureList;
			
		} catch(SQLException e) {
			System.out.println("Could not get list of employees");
			e.printStackTrace();
		}
		
		return null;
	}

}
