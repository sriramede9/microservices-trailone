package com.sri.Ratingdataservice.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sri.Ratingdataservice.models.Rating;
import com.sri.Ratingdataservice.models.UserRating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingController {

	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId) {

		return new Rating(movieId, 4);

	}

	@RequestMapping("users/{userId}")
	public UserRating getListofMoviesUserRated(@PathVariable("userId") String movieId) {

		 List<Rating> asList = Arrays.asList(new Rating("movieIdone", 5), new Rating("movieIdtwo", 3));
		// return new Rating(movieId, 4);
		 UserRating usrating =new UserRating();
		 usrating.setUserRating(asList);
		 return usrating;
	}

}
