package com.movieAPIs.services;

import java.util.List;

import com.movieAPIs.beans.Creators;

public interface CreatorsHibService {
	public void addNewCreator(Creators creator) throws Exception;
	public Creators getCreator(String name);
	public void deleteField(int id);
	public List<Creators> findAllCreators() throws Exception;
}
