package com.emts.dao;

import java.util.List;

import com.emts.model.Sector;

public interface SectorDao {
	public void addSectorname(Sector sector);
	public List<Object> getContent();
	public void removeContent(Integer Id);
	public List<Object> updateSector(Integer Id);
}
