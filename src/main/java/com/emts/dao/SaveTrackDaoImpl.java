package com.emts.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.emts.model.Chanel;
import com.emts.model.Tracking;
import com.emts.util.DateFormat;
import com.emts.util.IConstant;

@Repository
public class SaveTrackDaoImpl implements SaveTrackDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
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
	@SuppressWarnings("unchecked")
	public List<Object> getAllSector() {
		List<Object> sector=null;
		sector=hibernateTemplate.find("from Sector where IS_DELETED="+IConstant.IS_DELETED_ACTIVE);
		return sector;
		
	}
	@SuppressWarnings("unchecked")
	public List<Object> getAllSubSector() {
		List<Object> subsector=null;
		subsector=hibernateTemplate.find("from SubSector where IS_DELETED="+IConstant.IS_DELETED_ACTIVE);
		return subsector;
	}
	@SuppressWarnings("unchecked")
	public List<Object> getAllChanel() {
		List<Object> chanel=null;
		chanel=hibernateTemplate.find("from Chanel where IS_DELETED="+IConstant.IS_DELETED_ACTIVE);
		return chanel;
	}
	
	public void addSaveTracking(Tracking saveTracking) {
		Chanel chanel1=(Chanel)hibernateTemplate.get(Chanel.class,saveTracking.getChanel().getChannelId());
		saveTracking.setChanel(chanel1);
		/*String storyCode="";
		StringTokenizer st = new StringTokenizer(saveTracking.getDate(),"-");
		while(st.hasMoreTokens())
		{
			storyCode=storyCode+st.nextToken();
		}*/
		
		if(saveTracking.getTrackingId()==null)
		{
			@SuppressWarnings("unchecked")
			List<Integer> results=hibernateTemplate.find("select max(a.trackingId) from Tracking a");
			int id=results.get(0)+1;
			saveTracking.setStoryCode(saveTracking.getChanel().getShortChannelName()+"-"+DateFormat.generateStoryCode(saveTracking.getDate())+"-"+id);
		}
		else
		{
			saveTracking.setStoryCode(saveTracking.getChanel().getShortChannelName()+"-"+DateFormat.generateStoryCode(saveTracking.getDate())+"-"+saveTracking.getTrackingId());
		}
		if(saveTracking.getNewsTrend().equals("POSITIVE")||saveTracking.getNewsTrend().equals("Positive"))
		{ 
			int value=saveTracking.getNewsType().getNewTypeId();
			int valuetest=value*1;
			saveTracking.setMarking(valuetest);
		}
		else
		{
			int value=saveTracking.getNewsType().getNewTypeId();
			int valuetest=value*-1;
			saveTracking.setMarking(valuetest);
		}
		hibernateTemplate.saveOrUpdate(saveTracking);
	}
	@SuppressWarnings("unchecked")
	public List<Object> getAllClient() {
		List<Object> client=null;
		client=hibernateTemplate.find("from Client where IS_DELETED="+IConstant.IS_DELETED_ACTIVE);
		return client;
	}
	@SuppressWarnings("unchecked")
	public List<Object> getAllNewsType() {
		List<Object> newsType=null;
		newsType=hibernateTemplate.find("from NewsType where IS_DELETED="+IConstant.IS_DELETED_ACTIVE);
		return newsType;
	}
	@SuppressWarnings("unchecked")
	public List<Object> getContent() {
		List<Object> trackingContent=null;
		trackingContent=hibernateTemplate.find("from Tracking where IS_DELETED="+IConstant.IS_DELETED_ACTIVE);
		return trackingContent;
	}
	public void deleteTracking(Integer Id) {
		Tracking tracking=(Tracking)hibernateTemplate.get(Tracking.class, Id);
		tracking.setIsDeleted(IConstant.IS_DELETED_DEACTIVE);
		if(null!=tracking)
		{
			hibernateTemplate.update(tracking);
		}
		
	}
	@SuppressWarnings("unchecked")
	public List<Object> updateTracking(Integer Id) {
		List<Object> tracking=null;
		tracking=hibernateTemplate.find("from Tracking tracking where tracking.trackingId=?",Id);
		return tracking;
	}
}
