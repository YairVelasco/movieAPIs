package com.movieAPIs.beans;

/**
 * @author Admin
 * This is the POJO class for the table 'movies'
 */
public class Movies {
	
	private int idMovies;
	private String title;
	private String releaseDate;
	private Double rating;
	private String summary;
	private Creators creatorName;
	private String imagePath;
	
	public Movies() {
	}


	

	public Movies(int idMovies, String title, String releaseDate, Double rating, String summary, Creators creatorName) {
		super();
		this.idMovies = idMovies;
		this.title = title;
		this.releaseDate = releaseDate;
		this.rating = rating;
		this.summary = summary;
		this.creatorName = creatorName;
	}


	public int getIdMovies() {
		return idMovies;
	}


	public void setIdMovies(int idMovies) {
		this.idMovies = idMovies;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getReleaseDate() {
		return releaseDate;
	}


	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}


	public Double getRating() {
		return rating;
	}


	public void setRating(Double rating) {
		this.rating = rating;
	}


	public String getSummary() {
		return summary;
	}


	public void setSummary(String summary) {
		this.summary = summary;
	}


	public Creators getCreatorName() {
		return creatorName;
	}


	public void setCreatorName(Creators creatorName) {
		this.creatorName = creatorName;
	}




	public String getImagePath() {
		return imagePath;
	}




	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	

}
