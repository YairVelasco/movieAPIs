package com.movieAPIs.spring;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.movieAPIs.beans.Creators;
import com.movieAPIs.services.CreatorsService;

@Controller
public class CreatorsController {
	
	private static final Logger logger = Logger.getLogger(CreatorsController.class);
	
	@Autowired
	@Qualifier("HibService")
	CreatorsService creatorsService;
	
	
	@RequestMapping("/NewCreatorForm")
	public String showForm() {
		return "/NewCreatorForm";
	}
	
	@RequestMapping(value = {"/","/creators"}, method= RequestMethod.GET)
	public String findAllCreators(Map<String,Object> model) throws Exception {
			
			List<Creators> creators = creatorsService.findAllCreators();
			model.put("creators", creators);
			/*for (Creators creat : creator) {
				response += creat.toHashMap().toString() + ", ";
			}*/
			return "/creators";
	}
	
	
	@RequestMapping(value="CreateNew", method= RequestMethod.POST)
	public @ResponseBody String addNewCreator(int id, String nomb, String imgP){
		Creators creator = new Creators(id,nomb,imgP);
		
		try {
			creatorsService.addNewCreator(creator);
			return "Content Added";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("Content COULDN'T BE ADDED", e);
			return null;
		}
		
		
	}
	
	@RequestMapping(value = "DeleteByID", method = RequestMethod.DELETE)
	public @ResponseBody String deleteField(int id){
		
		try {
			creatorsService.deleteField(id);
			return "Done deleting the item with ID "+ id;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "Operation FAILED";
		}
		
		
	}
	
	
	@RequestMapping(value = "EditCreator", method = RequestMethod.PATCH)
	public @ResponseBody String EditCreator(int id, String nomb, String imgP) {
		Creators creator = new Creators(id,nomb,imgP);
		
		try {
			creatorsService.EditCreator(creator);
			return "Creator Edited";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "Creator's edition FAILED";
			
		}
	}
	
	@RequestMapping(value= "GetCreatorByName", method = RequestMethod.GET)
	public @ResponseBody String getCreator(String name){
		String response = "";
		try {
			List<Creators> nl = creatorsService.getCreator(name);
			for (Creators creator : nl) {
				response += creator.toHashMap().toString() + ", ";
			}
			return response;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "Couldn't find anything";
		}
	}
	
	
	
	/*
	;
	
	
	public void EditCreator(Creators creator) throws Exception;*/
	
}
