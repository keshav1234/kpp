package com.emts.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.emts.model.Registration;

@Repository
public class RegistrationDaoIml implements RegistrationDao{
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public void addUser(Registration reg) 
	{
		hibernateTemplate.save(reg);
	}
}
