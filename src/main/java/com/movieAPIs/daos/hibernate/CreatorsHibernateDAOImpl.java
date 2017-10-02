package com.movieAPIs.daos.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateOptimisticLockingFailureException;
import org.springframework.stereotype.Repository;

import com.movieAPIs.beans.Creators;
import com.movieAPIs.daos.CreatorsDao;
@Repository("HibRepository")
public class CreatorsHibernateDAOImpl implements CreatorsDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	

	public void addNewCreator(Creators creator)  {
		sessionFactory.getCurrentSession().save(creator);
		
	}

	public List<Creators> getCreator(String name) {
		try {
			return sessionFactory.getCurrentSession().createQuery("from com.movieAPIs.beans.Creators creators where creators.name like ?").setParameter(0, name).list();
		} catch (HibernateException e) {
			throw e;
			
		}
	}

	public void deleteField(int id) {
		sessionFactory.getCurrentSession().createQuery("DELETE com.movieAPIs.beans.Creators creators where creators.idCreators=?").setParameter(0, id).executeUpdate();
	}

	public List<Creators> findAllCreators()  {
		int numb = ((Long)sessionFactory.getCurrentSession().createQuery("select count (*) from com.movieAPIs.beans.Creators").uniqueResult()).intValue();
		System.out.println("Showing all "+ numb +" elements of Creators table\n");
		return sessionFactory.getCurrentSession().createQuery("from com.movieAPIs.beans.Creators creators order by creators.idCreators").list();
		
	}
	
	
	public void EditCreator(Creators creator) {
		/*sessionFactory.getCurrentSession().createQuery("UPDATE creators set name='?'imagePath='?' where id=?")
		.setParameter(0, creator.getName()).setParameter(1, creator.getImagePath()).setParameter(2, creator.getIdCreators());*/
		
		try {
			
			sessionFactory.getCurrentSession().update(creator);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			System.out.println("We couldn't edit this row because ID "+ creator.getIdCreators() +" doesn't exist.");
		}
		
	}

	
	
	//////////////////////////////////////////////////////////////////////////
	//SessionFactory Setter and getter

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	

}
