package com.emts.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.emts.util.IConstant;
@Repository
public class SearchStoryCodeDaoImpl implements SearchStoryCodeDao{
	@Autowired
	private HibernateTemplate hibernateTemplate;
	@SuppressWarnings("unchecked")
	public List<Object> SeachStoryCode(String storyCode) {
		List<Object> searchCode=null;
		searchCode=hibernateTemplate.find("from Tracking WHERE isDeleted="+IConstant.IS_DELETED_ACTIVE+" AND storyCode='"+storyCode+"'");
		return searchCode;
	}

}
