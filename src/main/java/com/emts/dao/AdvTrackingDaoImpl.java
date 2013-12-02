package com.emts.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.emts.model.AdvertisementTracking;
import com.emts.util.IConstant;
@Repository
public class AdvTrackingDaoImpl implements AdvTrackingDao{
	@Autowired
	private HibernateTemplate hibernateTemplate;
	@SuppressWarnings("unchecked")
	public List<Object> getAllChanel() {
		List<Object> chanel=null;
		chanel=hibernateTemplate.find("from Chanel where IS_DELETED="+IConstant.IS_DELETED_ACTIVE);
		return chanel;
	}

	@SuppressWarnings("unchecked")
	public List<Object> getAllState() {
		List<Object> state=null;
		state=hibernateTemplate.find("from State where IS_DELETED="+IConstant.IS_DELETED_ACTIVE);
		return state;
	}

	@SuppressWarnings("unchecked")
	public List<Object> getAllCity() {
		List<Object> city=null;
		city=hibernateTemplate.find("from City where IS_DELETED="+IConstant.IS_DELETED_ACTIVE);
		return city;
	}

	public void addAdvTracking(AdvertisementTracking advTracking) {
		System.out.println("Avertisement DaoImpl--"+advTracking.getTextArea());
		hibernateTemplate.saveOrUpdate(advTracking);
		System.out.println("Avertisement DaoImpl After Save--"+advTracking.getTextArea());
	}

	@SuppressWarnings("unchecked")
	public List<Object> getAllClient() {
		List<Object> client=null;
		client=hibernateTemplate.find("from Client where IS_DELETED="+IConstant.IS_DELETED_ACTIVE);
		return client;
	}

	@SuppressWarnings("unchecked")
	public List<Object> getAllParty() {
		List<Object> party=null;
		party=hibernateTemplate.find("from Party where IS_DELETED="+IConstant.IS_DELETED_ACTIVE);
		return party;
	}

	@SuppressWarnings("unchecked")
	public List<Object> getAlladvType() {
		List<Object> advType=null;
		advType=hibernateTemplate.find("from AdvType where IS_DELETED="+IConstant.IS_DELETED_ACTIVE);
		return advType;
	}

	@SuppressWarnings("unchecked")
	public List<Object> getContent() {
		List<Object> advTrackingContent=null;
		advTrackingContent=hibernateTemplate.find("from AdvertisementTracking where IS_DELETED="+IConstant.IS_DELETED_ACTIVE);
		return advTrackingContent;
	}

	public void deleteAdvTracking(Integer Id) {
		AdvertisementTracking advTracking=(AdvertisementTracking)hibernateTemplate.get(AdvertisementTracking.class,Id);
		advTracking.setIsDeleted(IConstant.IS_DELETED_DEACTIVE);
		if(null!=advTracking)
		{
			System.out.println("if Block");
			hibernateTemplate.update(advTracking);
		}
		
	}

	@SuppressWarnings("unchecked")
	public List<Object> updateAdvTracking(Integer Id) {
		List<Object> advTracking=null;
		advTracking=hibernateTemplate.find("from AdvertisementTracking advTracking where advTracking.advertismentId=?",Id);
		return advTracking;
	}

	public void repeatAdvTracking(AdvertisementTracking advTracking) {
		hibernateTemplate.save(advTracking);
		
	}

}
