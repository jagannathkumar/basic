package com.myproject.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.dao.MovieDao;
import com.myproject.dto.UserDetails;
import com.myproject.entity.Booking;
import com.myproject.entity.Language;
import com.myproject.entity.Location;
import com.myproject.entity.Movies;
import com.myproject.entity.RunningShows;
import com.myproject.service.MovieService;

@Service
@Transactional
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	MovieDao movieDao;
	@Override
	public List<Movies> getMoviesList() {
		// TODO Auto-generated method stub
		return movieDao.getMovies();
	}
	@Override
	public List<Language> getLanguage() {
		// TODO Auto-generated method stub
		return movieDao.getLanguage();
	}
	public Language getLanguage(int id) {
		return movieDao.getLanguage(id);
	}
	@Override
	public List<RunningShows> getRunningShows() {
		return movieDao.getRunningShows();
	}
	@Override
	public Booking bookTicket(RunningShows runningShows) {
		return movieDao.bookTicket(runningShows);
	}
	@Override
	public List<Location> getLocation() {
		return movieDao.getLocation();
	}
	@Override
	public UserDetails getUserDetails(int userId) {
		return movieDao.getUserDetails(userId);
	}

}
