package com.movieAPIs.daos;

import java.util.List;

import com.movieAPIs.beans.Creators;

/**
 * @author Admin
 *	DAO interface to set the classes for 'creators' table
 *	SETS: all the methods useful for the table.
 */
public interface CreatorsDao {
	public void addNewCreator(Creators creator) throws Exception;
	public Creators getCreator(String name);
	public void deleteField(int id);
	public List<Creators> findAllCreators() throws Exception;
}