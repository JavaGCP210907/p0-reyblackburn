package com.revature.dao;

import java.util.List;

import com.revature.models.Enclosure;

public interface EnclosureDaoInterface {
	
	public void addEnclosure(Enclosure enclosure);
	
	public List<Enclosure> getEnclosures();

}
