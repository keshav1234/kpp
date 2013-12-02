package com.emts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emts.dao.PublicationDao;
import com.emts.model.Publication;
import com.emts.model.State;
import com.emts.util.IConstant;

@Service
public class PublicationServiceImpl implements PublicationService {
	@Autowired PublicationDao publicationDao;

	public void addPublicationName(Publication publication) {
         publication.setIsDeleted(IConstant.IS_DELETED_ACTIVE);
         publicationDao.addPublicationName(publication);
	}
    
	@Transactional
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Publication> getContent() {
		List<Publication>publicationContent=new ArrayList<Publication>();
		publicationContent=(List) publicationDao.getContent();
		return publicationContent;
	}
	@Transactional
	public void removeContent(Integer Id) {
		
		publicationDao.removeContent(Id);
		
	}
	public Publication updatePublication(Integer Id) {
		List<Object> publication=new ArrayList<Object>();
		Publication updatePublication = new Publication();
		publication=publicationDao.updatePublication(Id);
		/*List convert to object*/
		for (Object object : publication) {
			updatePublication= (Publication) object; 
		}
		return updatePublication;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<State> getAllState() {
		List<State> state=new ArrayList<State>();
		state=(List)publicationDao.getAllState();
		return state;
	}

	
}
