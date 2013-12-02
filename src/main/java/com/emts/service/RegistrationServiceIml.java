package com.emts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emts.dao.RegistrationDao;
import com.emts.model.Registration;
import com.emts.util.IConstant;

@Service
public class RegistrationServiceIml implements RegistrationService{
	@Autowired
	private RegistrationDao regdao;

	@Transactional
	public void addUser(Registration reg) 
	{
		reg.setIsDeleted(IConstant.IS_DELETED_ACTIVE);
		regdao.addUser(reg);
	}
}