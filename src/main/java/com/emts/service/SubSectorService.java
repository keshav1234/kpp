package com.emts.service;

import java.util.List;

import com.emts.model.SubSector;

public interface SubSectorService {
public void addSubSectorname(SubSector subsector);
public List<SubSector> getContent();
public void removeContent(Integer Id);
public SubSector updateSubSector(Integer Id);
}
