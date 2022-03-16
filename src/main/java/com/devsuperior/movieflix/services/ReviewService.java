package com.devsuperior.movieflix.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.dto.ReviewInsertDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository repository;
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private AuthService authService;
	
	@Transactional
	public ReviewDTO insert(ReviewInsertDTO dto) {
		Review entity = new Review();
		copyToDto(entity, dto);
		entity = repository.save(entity);
		return new ReviewDTO(entity);
	}

	private void copyToDto(Review entity, ReviewInsertDTO dto) {
		entity.setText(dto.getText());
		
		Optional<Movie> movie = movieRepository.findById(dto.getMovieId());
		Movie movieEntity = movie.orElseThrow(() -> new ResourceNotFoundException("Movie Id not found " + dto.getMovieId()));
		entity.setMovie(movieEntity);
		
		User user = authService.authenticated();
		authService.validateSelf();
		entity.setUser(user);
	}
}
