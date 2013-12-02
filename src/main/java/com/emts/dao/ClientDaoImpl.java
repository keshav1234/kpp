package com.emts.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.emts.model.Client;
import com.emts.util.IConstant;

@Repository
public class ClientDaoImpl implements ClientDao{
	@Autowired
	private HibernateTemplate hibernateTemplate;
	public void addclientName(Client client) {
           hibernateTemplate.saveOrUpdate(client);
		
	}
	@SuppressWarnings("unchecked")
	public List<Object> getContent() {
		List<Object> clientContent=null;
		clientContent=hibernateTemplate.find("from Client where IS_DELETED="+IConstant.IS_DELETED_ACTIVE);
		return clientContent;
	}
	public void removeContent(Integer Id) {
		Client client=(Client)hibernateTemplate.get(Client.class,Id);
		client.setIsDeleted(IConstant.IS_DELETED_DEACTIVE);
		if(null!=client)
		{
			System.out.println("if Block");
			hibernateTemplate.update(client);
		}
		
	}
	@SuppressWarnings("unchecked")
	public List<Object> updateClient(Integer Id) {
		List<Object> client=null;
		client=hibernateTemplate.find("from Client client where client.clientId=?",Id);
		return client;
		
	}
	

}
