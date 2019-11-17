package com.sri.Movieratingservice.resource;

import java.util.Arrays;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.sri.Movieratingservice.model.CatalogItem;
import com.sri.Movieratingservice.model.Movie;
import com.sri.Movieratingservice.model.Rating;
import com.sri.Movieratingservice.model.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	// hardcoding for now

	@Autowired
	private RestTemplate rt;

	@Autowired
	private WebClient.Builder builder;

	List<Rating> ratings = Arrays.asList(new Rating("movieIdone", 5), new Rating("movieIdtwo", 3));

	@GetMapping("/{userId}")

	public List<CatalogItem> getCatalog(@PathVariable String userId) {

		// get all rated movie id

		// for each id call movie info service and get details

		// 1 find a way to call movie info servie which takes user id and gives
		// movie,descand rating.

		// Movie movie = rt.getForObject("http://localhost:8082/movies/foo",
		// Movie.class);

		// how to make calls async?
		// he should have a database vision to fetch by id and stuff

		// trying with webclinet

		// WebClient.Builder builder = WebClient.builder();

		// builder.build().get().uri("http://localhost:8082/movie/one").retrieve().bodyToMono(Movie.class).block();

		/*
		 * return ratings.stream().map(r -> { // Movie movie2 =
		 * rt.getForObject("http://localhost:8082/movie/" + // r.getMovieId(),
		 * Movie.class);
		 * 
		 * Movie movie2 = builder.build().get().uri("http://localhost:8082/movie/" +
		 * r.getMovieId()).retrieve() .bodyToMono(Movie.class).block(); return new
		 * CatalogItem("movie name" + movie2.getMovieName(), "desc and rating", 5);
		 * }).collect(Collectors.toList());
		 */

		UserRating ratings2 = rt.getForObject("http://MOVIE-RATING-SERVICE/ratingsdata/users/" + userId, UserRating.class);
		
		//based on user-ID I have get all the movies he has watched.
		//based on movie I am get the movie ID and movie details and info.

		return ratings2.getUserRating().stream().map(r -> {
			Movie movie2 = rt.getForObject("http://MOVIE-INFO-SERVICE/movie/" + r.getMovieId(), Movie.class);
			return new CatalogItem("movie name" + movie2.getMovieName(), "desc and rating", 5);
		}).collect(Collectors.toList());

		// return null;
	}

}
