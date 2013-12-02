package com.emts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emts.dao.SubSectorDao;
import com.emts.model.SubSector;
import com.emts.util.IConstant;

@Service
public class SubSectorServiceImpl implements SubSectorService {
@Autowired SubSectorDao subsectordao;
	public void addSubSectorname(SubSector subsector) {
		subsector.setIsDeleted(IConstant.IS_DELETED_ACTIVE);
		subsectordao.addSubSectorname(subsector);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SubSector> getContent() {
		List<SubSector> subsectorContent=new ArrayList<SubSector>();
		subsectorContent=(List)subsectordao.getContent();
		return subsectorContent;
	}
	public void removeContent(Integer Id) {
		subsectordao.removeContent(Id);
		
	}
	public SubSector updateSubSector(Integer Id) {
		List<Object> subSector=new ArrayList<Object>();
		SubSector updateSubSector = new SubSector();
		subSector=subsectordao.updateSubSector(Id);
		/*List convert to object*/
		for (Object object : subSector) {
			updateSubSector= (SubSector) object; 
		}
		return updateSubSector;
	}

}
