package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Review;

public class ReviewDTO {

	private String text;
	private Long movieId;
	private String email;
	
	public ReviewDTO() {
	}

	public ReviewDTO(String text, Long movieId) {
		this.text = text;
		this.movieId = movieId;
	}
	
	public ReviewDTO(Review entity) {
		text = entity.getText();
		movieId = entity.getMovie().getId();
		email = entity.getUser().getEmail();
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
