package com.emts.dao;

import java.util.List;

import com.emts.model.Client;

public interface ClientDao {
	public void addclientName(Client client);
	public List<Object> getContent();
	public List<Object> updateClient(Integer Id);
	public void removeContent(Integer Id);

}
