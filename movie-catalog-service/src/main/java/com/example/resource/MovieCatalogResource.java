package com.example.resource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.model.CatalogItem;
import com.example.model.Movie;
import com.example.model.Rating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	@Autowired
	private RestTemplate restTemplate;
	@RequestMapping("/{userid}")
	public List<CatalogItem> getCatalog(@PathVariable("userid") String userid){
		//RestTemplate template = new RestTemplate();
		System.out.println("in getCatalog method()......");
		Rating rating = restTemplate.getForObject("http://localhost:8083/ratingsdata/"+userid, Rating.class);
		Movie movie = restTemplate.getForObject("http://localhost:8082/movies/"+rating.getMovieid(), Movie.class);
		
		//return Collections.singletonList( new CatalogItem(name:"Transformaer",desc:"Test",rating:4));
		
		List<CatalogItem> list = new ArrayList<CatalogItem>();
		CatalogItem item = new CatalogItem();
		
		item.setName(movie.getName());
		item.setDesc("Test Description");
		item.setRating(rating.getRating());
		list.add(item);
		return list;
	}
}

