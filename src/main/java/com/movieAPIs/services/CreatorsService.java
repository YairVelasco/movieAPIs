package com.movieAPIs.services;

import java.util.List;

import com.movieAPIs.beans.Creators;

/**
 * @author Admin
 *	Service: Interface for 'creators' service
 *	SETS: the methods useful for table 'creators'
 */
public interface CreatorsService {
	public void addNewCreator(Creators creator) throws Exception;
	public Creators getCreator(String name);
	public void deleteField(int id);
	public List<Creators> findAllCreators() throws Exception;
	public void EditCreator(Creators creator) throws Exception;
}
