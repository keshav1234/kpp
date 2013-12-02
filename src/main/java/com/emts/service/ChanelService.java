package com.emts.service;

import java.util.List;

import com.emts.model.Chanel;
import com.emts.model.State;

public interface ChanelService {
	public void addChanelName(Chanel chanel);
	public List<State>getAllState();
	public List<Chanel> getContent();
	public void removeContent(Integer Id);
	public Chanel updateChanel(Integer Id);
}
