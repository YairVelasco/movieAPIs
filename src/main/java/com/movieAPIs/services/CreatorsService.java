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
	public List<Creators> getCreator(String name)throws Exception;
	public void deleteField(int id)throws Exception;
	public List<Creators> findAllCreators() throws Exception;
	public void EditCreator(Creators creator) throws Exception;
}
