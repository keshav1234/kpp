package com.emts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emts.dao.SectorDao;
import com.emts.model.Sector;
import com.emts.util.IConstant;
@Service
public class SectorServiceImpl implements SectorService {
	
@Autowired SectorDao sectordao;
@Transactional
	public void addSectorname(Sector sector) {
		sector.setIsDeleted(IConstant.IS_DELETED_ACTIVE);
		sectordao.addSectorname(sector);
	}
	@Transactional
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Sector> getContent() {
		List<Sector> sectorContent=new ArrayList<Sector>();
		sectorContent=(List)sectordao.getContent();
		return sectorContent;
	}
	@Transactional
	public void removeContent(Integer Id) {
		sectordao.removeContent(Id);
		
	}
	public Sector updatSector(Integer Id) {
		List<Object> sector=new ArrayList<Object>();
		Sector updateSector = new Sector();
		sector=sectordao.updateSector(Id);
		/*List convert to object*/
		for (Object object : sector) {
			updateSector= (Sector) object; 
		}
		return updateSector;
	}

}
