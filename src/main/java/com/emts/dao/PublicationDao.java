package com.emts.dao;

import java.util.List;

import com.emts.model.Publication;

public interface PublicationDao {
	public void addPublicationName(Publication publication);
	public List<Object> getContent();
	public void removeContent(Integer Id);
	public List<Object> updatePublication(Integer Id);
	public List<Object> getAllState();
}
