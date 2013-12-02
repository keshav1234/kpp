package com.emts.service;

import java.util.List;


import com.emts.model.Publication;
import com.emts.model.State;

public interface PublicationService {
	public void addPublicationName(Publication publication);
	public List<Publication> getContent();
	public void removeContent(Integer Id);
	public Publication updatePublication(Integer Id);
	public List<State>getAllState();
}
