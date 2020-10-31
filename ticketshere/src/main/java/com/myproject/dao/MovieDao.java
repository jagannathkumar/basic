package com.myproject.dao;
import java.util.List;

import com.myproject.entity.Booking;
import com.myproject.entity.Language;
import com.myproject.entity.Location;
import com.myproject.entity.Movies;
import com.myproject.entity.RunningShows;
import com.myproject.entity.Theatre;

public interface MovieDao {
	public List<Movies> getMovies();
	public List<Language> getLanguage();
	public List<RunningShows> getRunningShows();
	public Booking bookTicket(RunningShows runningShows);
	public List<Location> getLocation();
}
