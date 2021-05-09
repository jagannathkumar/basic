package com.myproject.service;
import java.util.List;

import com.myproject.dto.UserDetails;
import com.myproject.entity.Booking;
import com.myproject.entity.Language;
import com.myproject.entity.Location;
import com.myproject.entity.Movies;
import com.myproject.entity.RunningShows;

public interface MovieService {
	public List<Movies> getMoviesList();
	public List<Language> getLanguage();
	public List<RunningShows> getRunningShows();
	public Booking bookTicket(RunningShows runningShows);
	public List<Location> getLocation();
	public Language getLanguage(int id);
	public UserDetails getUserDetails(int userId);
}
