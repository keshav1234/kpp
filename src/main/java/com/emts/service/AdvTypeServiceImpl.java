package com.emts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emts.dao.AdvTypeDao;
import com.emts.model.AdvType;
import com.emts.util.IConstant;

@Service
public class AdvTypeServiceImpl implements AdvTypeService{
@Autowired AdvTypeDao advtypedao;
	public void addAdvTypename(AdvType advtype) {
		advtype.setIsDeleted(IConstant.IS_DELETED_ACTIVE);
		advtypedao.addAdvTypename(advtype);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AdvType> getContent() {
		List<AdvType> advTypeContent=new ArrayList<AdvType>();
		advTypeContent=(List)advtypedao.getContent();
		return advTypeContent;
	}
	@Transactional
	public void removeContent(Integer Id) {
		
		advtypedao.removeContent(Id);
		
	}
	public AdvType updateAdvType(Integer Id) {
		List<Object> advType=new ArrayList<Object>();
		AdvType advType1 = new AdvType();
		advType=advtypedao.updateAdvType(Id);
		/*List convert to object*/
		for (Object object : advType) {
			advType1= (AdvType) object; 
		}
		return advType1;
	}


}
