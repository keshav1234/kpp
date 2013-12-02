package com.emts.service;

import java.util.List;

import com.emts.model.AdvType;

public interface AdvTypeService {
public void addAdvTypename(AdvType advtype);
public List<AdvType> getContent();
public AdvType updateAdvType(Integer Id);
public void removeContent(Integer Id);
}
