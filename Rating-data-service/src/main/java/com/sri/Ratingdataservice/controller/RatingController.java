package com.sri.Ratingdataservice.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sri.Ratingdataservice.models.Rating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingController {

	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId) {

		return new Rating(movieId, 4);

	}

}
