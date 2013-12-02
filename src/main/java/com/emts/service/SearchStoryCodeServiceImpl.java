package com.emts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emts.dao.SearchStoryCodeDao;
import com.emts.model.Tracking;
@Service
public class SearchStoryCodeServiceImpl implements SearchStoryCodeService{
@Autowired SearchStoryCodeDao storyCodeDao;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Tracking> SeachStoryCode(String storyCode) {
		List<Tracking> searchCodeList = new ArrayList<Tracking>();
		searchCodeList = (List)storyCodeDao.SeachStoryCode(storyCode);
			return searchCodeList;
	}
	}


