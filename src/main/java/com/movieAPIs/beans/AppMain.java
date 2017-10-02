package com.movieAPIs.beans;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateOptimisticLockingFailureException;

import com.movieAPIs.services.CreatorsService;

public class AppMain {
	public static String creatorsMenu = "What do you want to do?:\n1. Add new creator\n2. "
			+ "Edit a creator\n3. Get a list of all creators\n4. Delete creator\n5. Search Creator by Name";

	public static void main(String[] args) throws Exception {

		// Variables used for the excecution of the CRUD
		int tempId;
		String tempCreator;
		String tempImagePath;
		Creators newCreator;

		// We set the application context to say Spring we are using "beans.xml"
		@SuppressWarnings("resource")
		ApplicationContext appContext = new ClassPathXmlApplicationContext("com/movieAPIs/xml/beans.xml");

		// Get the service bean we need to send data to the table
		CreatorsService cd = appContext.getBean("HibService", CreatorsService.class);
		// Instantiation of BufferedReader for our reads from the console
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// MENU
		System.out.println(creatorsMenu);
		System.out.println("--------------------------------------------");
		int opc = Integer.parseInt(br.readLine());
		switch (opc) {
		// //INSERT
		case 1:
			System.out.print("Nuevo id: "); tempId = Integer.parseInt(br.readLine());
			System.out.print("new Creator's name: "); tempCreator = br.readLine();
			System.out.print("new Creator's imagePath: "); tempImagePath = br.readLine();
			newCreator = new Creators(tempId, tempCreator, tempImagePath);
			try {
				cd.addNewCreator(newCreator);
				System.out.println("--------------------------------------------");
				System.out.println("A new Creator has been added with parameters: \nName: " + newCreator.getName()
						+ "\nImage Path: " + newCreator.getImagePath() + "\nwith id: " + newCreator.getIdCreators());
			} catch (Exception e) {

				throw e;
			}
			break;
		// //EDIT
		case 2:
			System.out.print("Introduce the id you want to EDIT: "); tempId = Integer.parseInt(br.readLine());
			System.out.print("set a newer Creator's name: "); tempCreator = br.readLine();
			System.out.print("set a newer Creator's imagePath: "); tempImagePath = br.readLine();
			newCreator = new Creators(tempId, tempCreator, tempImagePath);
			
				cd.EditCreator(newCreator);
				System.out.println("--------------------------------------------");
				System.out.println("The creator's id " + newCreator.getIdCreators()
						+ " has been updated with new parameters: \nName: " + newCreator.getName() + "\nImage Path: "
						+ newCreator.getImagePath());
			
			
			break;
		// //FIND_ALL
		case 3:
			try {
				System.out.println("--------------------------------------------");
				List<Creators> allCreators = cd.findAllCreators();
				for (Creators creator : allCreators) {
					System.out.println("from ID: " + creator.getIdCreators() + " 	NAME: " + creator.getName()
							+ "	IMAGE PATH: " + creator.getImagePath() + ".");
				}

			} catch (Exception e) {

				throw e;
			}
			break;
		// //DELETE
		case 4:
			System.out.print("Introduce the id you want to DELETE: "); tempId = Integer.parseInt(br.readLine());
			String prompt;
			do {
				System.out.println("Are you sure you want to delete the item with ID: " + tempId + "? Y/N");
				prompt = br.readLine();
			} while (!prompt.equalsIgnoreCase("Y") && !prompt.equalsIgnoreCase("N"));
			if (prompt.equalsIgnoreCase("Y")) {
				System.out.println("This is the ID to be deleted: " + tempId);
				try {
					cd.deleteField(tempId);
					System.out.println("--------------------------------------------");
					System.out.println("The item with the ID " + tempId + " has been removed from the DB");
				} catch (Exception e) {

					throw e;
				}
			}
			break;
//		//SEARCH BY NAME	
		case 5:
			System.out.print("Type the name of the Creator you are looking for: "); tempCreator = br.readLine();
			try {
				System.out.println("--------------------------------------------");
				List<Creators> FoundCreators = cd.getCreator(tempCreator);
				if (FoundCreators.isEmpty()) {
					System.out.println("We couldn't find any Creator matching the name: " + tempCreator+".");
				} else {
					System.out.print("Found "+ FoundCreators.size() +" row(s) matching the name: "+tempCreator+".\n\n");
					for (Creators creator : FoundCreators) {
						System.out.println("from ID: " + creator.getIdCreators() + " 	NAME: " + creator.getName()
								+ "	IMAGE PATH: " + creator.getImagePath() + ".");
					}
				}
			} catch (Exception e) {

				throw e;
			}

		}

		// We do the connection to the DB and send the object 'newCreator'

	}

}
