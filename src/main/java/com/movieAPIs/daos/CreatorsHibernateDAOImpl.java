package com.movieAPIs.daos;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.movieAPIs.beans.Creators;
@Repository("forHib")
public class CreatorsHibernateDAOImpl implements CreatorsDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	

	public void addNewCreator(Creators creator) throws Exception {
		sessionFactory.getCurrentSession().save(creator);
	}

	public Creators getCreator(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteField(int id) {
		// TODO Auto-generated method stub

	}

	public List<Creators> findAllCreators() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
