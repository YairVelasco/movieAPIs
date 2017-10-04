package com.movieAPIs.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.movieAPIs.beans.Creators;
import com.movieAPIs.services.CreatorsService;

@Controller
public class CreatorsController {
	
	@Autowired
	@Qualifier("HibService")
	CreatorsService creatorsService;
	
	@RequestMapping(value ="/GetAllC", method= RequestMethod.GET)
	public List<Creators> findAllCreators()  {
		try {
			return creatorsService.findAllCreators();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
