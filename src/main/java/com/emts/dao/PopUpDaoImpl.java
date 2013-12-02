package com.emts.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.emts.model.PopUp;
@Repository
public class PopUpDaoImpl implements PopUpDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public void addPop(PopUp popUp) {
		hibernateTemplate.save(popUp);
	}
		
	}

