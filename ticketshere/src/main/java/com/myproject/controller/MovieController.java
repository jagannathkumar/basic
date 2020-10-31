package com.myproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.entity.Booking;
import com.myproject.entity.Language;
import com.myproject.entity.Location;
import com.myproject.entity.Movies;
import com.myproject.entity.RunningShows;
import com.myproject.service.MovieService;

@Component
@CrossOrigin(origins = "*")
@RestController
public class MovieController {
	
	@Autowired
	MovieService movieService;
	
	@RequestMapping(value = "/getMovies", method = RequestMethod.GET)
	public List<Movies> getMoviesList(){
		return movieService.getMoviesList();
	}
	
	@RequestMapping(value = "/getLang", method = RequestMethod.GET)
	public List<Language> getLanguage(){
		return movieService.getLanguage();
	}
	
	@RequestMapping(value = "/getRunning", method = RequestMethod.GET)
	public List<RunningShows> getRunningShows(){
		return movieService.getRunningShows();
	}
	
	@RequestMapping(value="/bookTkt", method= RequestMethod.POST)
	public Booking bookTicket(@RequestBody RunningShows runningShows) {
		return movieService.bookTicket(runningShows);
	}
	@RequestMapping(value="/getLoc", method=RequestMethod.GET)
	public List<Location> getLocation() {
		return movieService.getLocation();
	}
}
