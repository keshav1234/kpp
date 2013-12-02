package com.emts.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.emts.model.Publication;
import com.emts.util.IConstant;

@Repository
public class PublicationDaoImpl implements PublicationDao{
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public void addPublicationName(Publication publication) {
		hibernateTemplate.saveOrUpdate(publication);
	}
	@SuppressWarnings("unchecked")
	public List<Object> getContent() {
		List<Object> publicationContent=null;
		publicationContent=hibernateTemplate.find("from Publication where IS_DELETED="+IConstant.IS_DELETED_ACTIVE);
		return publicationContent;
	}
	public void removeContent(Integer Id) {
		Publication publication=(Publication)hibernateTemplate.get(Publication.class,Id);
		publication.setIsDeleted(IConstant.IS_DELETED_DEACTIVE);
		if(null!=publication)
		{
			System.out.println("if Block");
			hibernateTemplate.update(publication);
		}
	}
	@SuppressWarnings("unchecked")
	public List<Object> updatePublication(Integer Id) {
		List<Object> publication=null;
		publication=hibernateTemplate.find("from Publication public where public.publicationId=?",Id);
		return publication;
		
	}
	@SuppressWarnings("unchecked")
	public List<Object> getAllState() {
		List<Object> state=null;
		state=hibernateTemplate.find("from State where IS_DELETED="+IConstant.IS_DELETED_ACTIVE);
		return state;
	}
}
