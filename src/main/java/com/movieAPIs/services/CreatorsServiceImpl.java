package com.movieAPIs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.movieAPIs.beans.Creators;
import com.movieAPIs.daos.CreatorsDao;
import com.movieAPIs.daos.jdbc.CreatorsDaoImpl;

/**
 * @author Admin
 * Implements the methods from the service interface, using the DAO objects as a parameters
 */
@Service("JdbcService")
public class CreatorsServiceImpl implements CreatorsService {
	
	//Calls the implemented interface to use the methods
	@Autowired
	@Qualifier("JdbcRepository")
	private CreatorsDao creatorsDao;
	
	public void addNewCreator(Creators creator) throws Exception {
		
		try {
			creatorsDao.addNewCreator(creator);
		}catch(Exception e) {
			System.out.println("The error is in ServiceImpl");
			throw e;
		}
		
		
	}




	public void deleteField(int id) {
		try {
			creatorsDao.deleteField(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}




	public List<Creators> findAllCreators() throws Exception {
		
		try {
			return creatorsDao.findAllCreators();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		// TODO Auto-generated method stub
		
	}
	
}
