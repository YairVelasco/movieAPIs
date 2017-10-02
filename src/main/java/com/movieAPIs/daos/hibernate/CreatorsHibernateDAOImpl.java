package com.movieAPIs.daos.hibernate;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.movieAPIs.beans.Creators;
import com.movieAPIs.daos.CreatorsDao;
@Repository("HibRepository")
public class CreatorsHibernateDAOImpl implements CreatorsDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	

	public void addNewCreator(Creators creator) throws Exception {
		sessionFactory.getCurrentSession().save(creator);
		
	}

	public Creators getCreator(String name) {
		//sessionFactory.getCurrentSession().createQuery()
		return null;
	}

	public void deleteField(int id) {
		sessionFactory.getCurrentSession().createQuery("DELETE com.movieAPIs.beans.Creators creators where creators.idCreators=?").setParameter(0, id).executeUpdate();
	}

	public List<Creators> findAllCreators() throws Exception {
		int numb = ((Long)sessionFactory.getCurrentSession().createQuery("select count (*) from com.movieAPIs.beans.Creators").uniqueResult()).intValue();
		System.out.println("Showing all "+ numb +" elements of Creators table\n");
		return sessionFactory.getCurrentSession().createQuery("from com.movieAPIs.beans.Creators creators order by creators.idCreators").list();
		
	}
	
	
	public void EditCreator(Creators creator) throws Exception {
		/*sessionFactory.getCurrentSession().createQuery("UPDATE creators set name='?'imagePath='?' where id=?")
		.setParameter(0, creator.getName()).setParameter(1, creator.getImagePath()).setParameter(2, creator.getIdCreators());*/
		sessionFactory.getCurrentSession().update(creator);
		
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
