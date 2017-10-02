package com.movieAPIs.daos.jdbc;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.movieAPIs.beans.Creators;
import com.movieAPIs.daos.CreatorsDao;
import com.movieAPIs.daos.CreatorsMapper;

/**
 * @author Admin
 *	Implementation of the DAO object for the table 'creators'
 *	@Repository: sets the object as a bean
 */
@Repository("JdbcRepository")
public class CreatorsDaoImpl implements CreatorsDao{
	
	//Call the object dataSource to make the connection
	@Autowired
	private DataSource dataSource;
	
	//Invokes JdbcTemplate to help us with transactions
	private JdbcTemplate jdbcTemplate;
	
	
	/**
	 * @param dataSource instantiate jdbcTemplate injecting the dataSource to it
	 */
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	
	public List<Creators> getCreator(String name) {
		return null;
	}

	
	public void addNewCreator(Creators creator) throws Exception {
		
		try {
			this.setDataSource(dataSource);
			this.jdbcTemplate.update("insert into creators (idCreators, name, imagePath) values (?, ?, ?)", creator.getIdCreators(), creator.getName(),creator.getImagePath());
		}catch(Exception e) {
			System.out.println("The error is in DAOImpl");
			throw e;
		}
		
		
	}



	public void deleteField(int id) {
		this.setDataSource(dataSource);
		try {
			this.jdbcTemplate.update("delete from creators where idCreators = ?", id);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



	public List<Creators> findAllCreators() {
		this.setDataSource(dataSource);
		try {
			return this.jdbcTemplate.query("select idCreators, name, imagePath from creators", new CreatorsMapper());
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			return null;
			

		}
	}



	public void EditCreator(Creators creator) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
