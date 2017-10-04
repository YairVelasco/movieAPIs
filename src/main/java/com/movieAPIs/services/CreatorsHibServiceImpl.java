package com.movieAPIs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateOptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.movieAPIs.beans.Creators;
import com.movieAPIs.daos.CreatorsDao;
@Service("HibService")
public class CreatorsHibServiceImpl implements CreatorsService {
	
	
	@Autowired
	@Qualifier("HibRepository")
	private CreatorsDao creatorsDao;
	
	@Transactional
	public void addNewCreator(Creators creator)  {
		creatorsDao.addNewCreator(creator);

	}
	
	@Transactional
	public List<Creators> getCreator(String name){
		
	
			return creatorsDao.getCreator(name);
		
	}
	
	@Transactional
	public void deleteField(int id) {
		creatorsDao.deleteField(id);

	}

	@Transactional
	public List<Creators> findAllCreators()  {
		return creatorsDao.findAllCreators();
	}
	@Transactional
	public void EditCreator(Creators creator)  {
		try {
			creatorsDao.EditCreator(creator);
		} catch (HibernateOptimisticLockingFailureException e) {
			System.out.println("We couldn't edit this row because ID "+ creator.getIdCreators() +" doesn't exist.");
		}
		
	}

}
