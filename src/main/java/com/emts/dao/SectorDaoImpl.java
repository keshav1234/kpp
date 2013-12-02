package com.emts.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.emts.model.Sector;
import com.emts.util.IConstant;

@Repository
public class SectorDaoImpl implements SectorDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	public void addSectorname(Sector sector) {
		hibernateTemplate.saveOrUpdate(sector);		
	}
	@SuppressWarnings("unchecked")
	public List<Object> getContent() {
		List<Object> sectorContent=null;
		sectorContent=hibernateTemplate.find("from Sector where IS_DELETED="+IConstant.IS_DELETED_ACTIVE);
		return sectorContent;
	}
	public void removeContent(Integer Id) {
		Sector sector=(Sector)hibernateTemplate.get(Sector.class,Id);
		sector.setIsDeleted(IConstant.IS_DELETED_DEACTIVE);
		if(null!=sector)
		{
			hibernateTemplate.update(sector);
		}
		
	}
	@SuppressWarnings("unchecked")
	public List<Object> updateSector(Integer Id) {
		List<Object> sector=null;
		sector=hibernateTemplate.find("from Sector sector where sector.sectorId=?",Id);
		return sector;
	}

}
