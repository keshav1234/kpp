package com.emts.service;

import java.util.List;

import com.emts.model.Client;


public interface ClientService {
	public void addClientName(Client client);
	public List<Client> getContent();
	public void removeContent(Integer Id);
	public Client updateClient(Integer Id);

}
