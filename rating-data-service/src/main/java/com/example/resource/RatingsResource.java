package com.example.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Model.Rating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsResource {
	
	@RequestMapping("/{movieId}")
	public Rating getRatings(@PathVariable("movieId") String movieId) {
		System.out.println("in getRatings method().....");
		Rating rat = new Rating();
		rat.setMovieid(movieId);
		rat.setRating(5);
		return rat;
	}
	@RequestMapping("/users/{userId}")
	public List<Rating> getUserRatings(@PathVariable("userId") String userId) {
		System.out.println("in getRatings method().....");
		List<Rating> list = new ArrayList<Rating>();
		Rating rat = new Rating();
		rat.setMovieid("123");
		rat.setRating(3);
		Rating rat2 = new Rating();
		rat2.setMovieid("456");
		rat2.setRating(5);
		list.add(rat);
		list.add(rat2);
		return list;
	}
	

}
