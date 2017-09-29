package com.movieAPIs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.movieAPIs.beans.Creators;
import com.movieAPIs.daos.CreatorsDao;
@Service
public class CreatorsHibServiceImpl implements CreatorsHibService {
	
	@Autowired
	
	private CreatorsDao creatorsDao;
	
	@Transactional
	public void addNewCreator(Creators creator) throws Exception {
		creatorsDao.addNewCreator(creator);

	}
	
	@Transactional
	public Creators getCreator(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional
	public void deleteField(int id) {
		// TODO Auto-generated method stub

	}

	@Transactional
	public List<Creators> findAllCreators() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}