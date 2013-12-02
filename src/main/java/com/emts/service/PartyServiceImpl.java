package com.emts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emts.dao.PartyDao;
import com.emts.model.Party;
import com.emts.util.IConstant;

@Service
public class PartyServiceImpl implements PartyService {
	@Autowired
	private PartyDao partyDao;

	@Transactional
	public void addPartyName(Party party) {
		party.setIsDeleted(IConstant.IS_DELETED_ACTIVE);
		partyDao.addPartyName(party);

	}

	@Transactional
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Party> getContent() {
		List<Party> partyContent = new ArrayList<Party>();
		partyContent = (List) partyDao.getContent();
		return partyContent;
	}

	
	@Transactional
	public void removeContent(Integer Id) {
		
		partyDao.removeContent(Id);
		
	}
	public Party updateParty(Integer Id) {
		List<Object> party=new ArrayList<Object>();
		Party updateParty = new Party();
		party=partyDao.updateParty(Id);
		/*List convert to object*/
		for (Object object : party) {
			updateParty= (Party) object; 
		}
		return updateParty;
	}

}
