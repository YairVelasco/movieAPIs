package com.movieAPIs.beans;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 * @author Admin
 *This class is a POJO class for the table 'creators'
 */
@Entity(name="creators")
@Table(name="creators")
public class Creators {
	@Id
	@Column
	private int idCreators;
	@Column
	private String name;
	@Column
	private String imagePath;
	public Creators() {
		super();
	}
	public Creators(int idCreators, String name, String imagePath) {
		super();
		this.idCreators = idCreators;
		this.name = name;
		this.imagePath = imagePath;
	}
	
	public Map<String,String> toHashMap(){
		Map<String,String> datos = new HashMap<String,String>();
		datos.put("idCreators", ""+this.getIdCreators());
		datos.put("name", this.getName());
		datos.put("imagePath", this.getImagePath());
		return datos;
	}
	
	public int getIdCreators() {
		return idCreators;
	}
	public void setIdCreators(int idCreators) {
		this.idCreators = idCreators;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	
}
