package com.movieAPIs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.movieAPIs.beans.Creators;
import com.movieAPIs.daos.CreatorsDao;
import com.movieAPIs.daos.hibernate.CreatorsHibernateDAOImpl;
@Service("HibService")
public class CreatorsHibServiceImpl implements CreatorsService {
	
	
	@Autowired
	@Qualifier("HibRepository")
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
		creatorsDao.deleteField(id);

	}

	@Transactional
	public List<Creators> findAllCreators() throws Exception {
		return creatorsDao.findAllCreators();
	}
	@Transactional
	public void EditCreator(Creators creator) throws Exception {
		creatorsDao.EditCreator(creator);
		
	}

}
