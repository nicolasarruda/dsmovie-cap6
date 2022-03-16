package com.devsuperior.movieflix.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.devsuperior.movieflix.entities.Review;

public class ReviewInsertDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotEmpty
	private String text;
	
	private Long movieId;

	public ReviewInsertDTO() {
	}
	
	public ReviewInsertDTO(String text, Long movieId) {
		this.text = text;
		this.movieId = movieId;
	}
	
	public ReviewInsertDTO(Review entity) {
		text = entity.getText();
		movieId = entity.getMovie().getId();
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
}
