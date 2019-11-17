package com.sri.Movieinfoservice.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sri.Movieinfoservice.model.Movie;

@RestController
@RequestMapping("/movie")
public class MovieResource {

	@GetMapping("/{movieId}")
	public Movie getmovieInfo(@PathVariable String movieId) {

		return new Movie(movieId, " test Name -- getting movie details by id think titanic by Movie Id"+movieId);
	}

}
