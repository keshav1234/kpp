package com.emts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emts.dao.StateDao;
import com.emts.model.Country;
import com.emts.model.State;
import com.emts.util.IConstant;

@Service
public class StateServiceImpl implements StateService{
@Autowired StateDao statedao;

@SuppressWarnings({ "unchecked", "rawtypes" })
public List<Country> getAllCountry() {
	List<Country> country=new ArrayList<Country>();
	country=(List)statedao.getAllCountry();
	return country;
}
@Transactional
public void addStateName(State state) {
	state.setIsDeleted(IConstant.IS_DELETED_ACTIVE);
    statedao.addStateName(state);	
}
@SuppressWarnings({ "unchecked", "rawtypes" })
public List<State> getContent() {
	List<State> stateContent=new ArrayList<State>();
	stateContent=(List)statedao.getContent();
	return stateContent;
}
@Transactional
public void removeContent(Integer Id) {
	statedao.removeContent(Id);
	
}
public State updateState(Integer Id) {
	List<Object> state=new ArrayList<Object>();
	State updateState = new State();
	state=statedao.updateState(Id);
	/*List convert to object*/
	for (Object object : state) {
		updateState= (State) object; 
	}
	return updateState;
}
}

