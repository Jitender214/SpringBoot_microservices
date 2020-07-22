package com.example.resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Model.Movie;

@RestController
@RequestMapping("/movies")
public class MovieResource {
	
	@RequestMapping("/{movieid}")
	public Movie getMovieInfo(@PathVariable("movieid") String movieid) {
		Movie movie = new Movie();
		movie.setMovieid(movieid);
		movie.setName("Test Name");
		return movie;		
	}


}
