package com.devsuperior.movieflix.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;

public class MovieDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String title;
	private String subTitle;
	private String synopsis;
	private Integer year;
	
	private String genre;
	
	private List<ReviewDTO> reviews = new ArrayList<>();
	
	public MovieDTO() {
	}

	public MovieDTO(Long id, String title, String subTitle, String synopsis, Integer year, GenreDTO genre) {
		this.id = id;
		this.title = title;
		this.subTitle = subTitle;
		this.synopsis = synopsis;
		this.year = year;
	}
	
	public MovieDTO(Movie entity) {
		id = entity.getId();
		title = entity.getTitle();
		subTitle = entity.getSubTitle();
		synopsis = entity.getSynopsis();
		year = entity.getYear();
	}
	
	public MovieDTO(Movie entity, Genre genre, List<Review> reviews) {
		this(entity);
		this.genre = genre.getName();
		reviews.forEach(rev -> this.reviews.add(new ReviewDTO(rev)));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public List<ReviewDTO> getReviews() {
		return reviews;
	}
}