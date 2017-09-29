package com.movieAPIs.daos;

import com.movieAPIs.beans.Movies;

/**
 * @author Admin
 *	DAO: interface for the table 'movies'
 *	SETS: all methods useful for that table
 */
public interface MoviesDao {
	public void addNew() ;
	public Movies getMovie(String title);
	
}
