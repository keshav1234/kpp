package com.emts.service;

import java.util.List;

import com.emts.model.Sector;

public interface SectorService {
	public void addSectorname(Sector sector);
	public List<Sector> getContent();
	public void removeContent(Integer Id);
	public Sector updatSector(Integer Id);
}
