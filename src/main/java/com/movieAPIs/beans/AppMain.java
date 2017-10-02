package com.movieAPIs.beans;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.movieAPIs.services.CreatorsService;

public class AppMain {

	public static void main(String[] args) throws Exception {
		
		//Instantiation of the POJO we need to send data to the DB
		Creators newCreator = new Creators();
		newCreator.setIdCreators(22);
		newCreator.setName("Nobody");
		newCreator.setImagePath("dont know man");
		
		Creators newCreators2 = new Creators(23,"asd,","dlkamsd");
		
		//We  set the application context to say Spring we are using "beans.xml"
		@SuppressWarnings("resource")
		ApplicationContext appContext = new ClassPathXmlApplicationContext("com/movieAPIs/xml/beans.xml");
		//get the service bean we need to send data to the table
		CreatorsService cs =  appContext.getBean("JdbcService",CreatorsService.class);
		CreatorsService cd = appContext.getBean("HibService",CreatorsService.class);
		
		Map<Integer, String> datos = new HashMap<Integer, String>();
		datos.put(1, "uno");
		datos.put(2, "dos");
		datos.put(3, "tres");
		
		
		try {
			cd.addNewCreator(newCreator);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			throw e1;
		}
		
		
		
		//We do the connection to the DB and send the object 'newCreator'
		try {
			//cd.deleteField();
			cs.addNewCreator(newCreators2);
		} catch (Exception e) {
			System.out.println("The error is in MAIN");
			throw e;
		}
	}

}
