package com.movieAPIs.beans;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.movieAPIs.services.CreatorsService;

public class AppMain {
	public static String creatorsMenu = "What do you want to do?:\n1. Add new creator\n2. "
			+ "Edit a creator\n3. Get a list of all creators\n4. Delete creator\n5. Search Creator by Name";

	public static void main(String[] args) {

		// Variables used for the excecution of the CRUD
		int tempId = 0;
		String tempCreator = "";
		String tempImagePath = "";
		Creators newCreator;

		// We set the application context to say Spring we are using "beans.xml"
		@SuppressWarnings("resource")
		//ApplicationContext appContext = new ClassPathXmlApplicationContext("com/movieAPIs/xml/beans.xml");
		ApplicationContext appContext = new ClassPathXmlApplicationContext("/webapp/WEB-INF/spring-servlet.xml");

		// Get the service bean we need to send data to the table
		CreatorsService cd = appContext.getBean("HibService", CreatorsService.class);
		// Instantiation of BufferedReader for our reads from the console
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// MENU
		System.out.println(creatorsMenu);
		System.out.println("--------------------------------------------");
		int opc = 0;
		try {
			opc = Integer.parseInt(br.readLine());
		} catch (NumberFormatException e2) {
			e2.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		switch (opc) {
		// //INSERT
		case 1:
			try {
				System.out.print("Nuevo id: "); tempId = Integer.parseInt(br.readLine());
				System.out.print("new Creator's name: "); tempCreator = br.readLine();
				System.out.print("new Creator's imagePath: "); tempImagePath = br.readLine();
			} catch (NumberFormatException e1) {
				System.out.println("ERROR: The ID must be a number");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			newCreator = new Creators(tempId, tempCreator, tempImagePath);
			try {
				cd.addNewCreator(newCreator);
				System.out.println("--------------------------------------------");
				System.out.println("INFO MESSAGE: A new Creator has been added with parameters: \nName: " + newCreator.getName()
						+ "\nImage Path: " + newCreator.getImagePath() + "\nwith id: " + newCreator.getIdCreators());
			} catch (Exception e) {

				System.out.println(e);
			}
			break;
		// //EDIT
		case 2:
			try {
				System.out.print("Introduce the id you want to EDIT: "); tempId = Integer.parseInt(br.readLine());
				System.out.print("set a newer Creator's name: "); tempCreator = br.readLine();
				System.out.print("set a newer Creator's imagePath: "); tempImagePath = br.readLine();
			} catch (NumberFormatException e2) {
				System.out.println("ERROR: ID must be a number");
				break;
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			newCreator = new Creators(tempId, tempCreator, tempImagePath);
			
			try {
				cd.EditCreator(newCreator);
				System.out.println("--------------------------------------------");
				System.out.println("INFO MESSAGE: The creator's id " + newCreator.getIdCreators()
						+ " has been updated with new parameters: \nName: " + newCreator.getName() + "\nImage Path: "
						+ newCreator.getImagePath());
			} catch (Exception e1) {
				System.out.println("---ERROR: The ID "+ newCreator.getIdCreators() +" does not exist in the DB, try a different one or check the option 3 for a list of all existent records.---");
			}
			
			
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

				System.out.println(e);
			}
			break;
		// //DELETE
		case 4:
			try {
				System.out.print("Introduce the id you want to DELETE: "); tempId = Integer.parseInt(br.readLine());
			} catch (NumberFormatException e2) {
				e2.printStackTrace();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			String prompt = "";
			do {
				System.out.println("PROMPT: Are you sure you want to delete the item with ID: " + tempId + "? Y/N");
				try {
					prompt = br.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} while (!prompt.equalsIgnoreCase("Y") && !prompt.equalsIgnoreCase("N"));
			if (prompt.equalsIgnoreCase("Y")) {
				System.out.println("This is the ID to be deleted: " + tempId);
				try {
					cd.deleteField(tempId);
					System.out.println("--------------------------------------------");
					System.out.println("INFO MESSAGE: The item with the ID " + tempId + " has been removed from the DB");
				} catch (Exception e) {

					System.out.println(e);
				}
			}
			break;
//		//SEARCH BY NAME	
		case 5:
			try {
				System.out.print("Type the name of the Creator you are looking for: "); tempCreator = br.readLine();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
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

				System.out.println(e);
			}

		}

		// We do the connection to the DB and send the object 'newCreator'

	}

}
