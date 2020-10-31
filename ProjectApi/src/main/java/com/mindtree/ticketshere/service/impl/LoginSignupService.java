package com.mindtree.ticketshere.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.ticketshere.dao.impl.DaoLoginSignUp;
import com.mindtree.ticketshere.entity.Organizer;
import com.mindtree.ticketshere.entity.User;

@Service
@Transactional
public class LoginSignupService {
	@Autowired
	DaoLoginSignUp ticketsDao;

	public void insert(User user) {
		ticketsDao.insert(user);
	}

	public boolean isPresent(User user) {
		return ticketsDao.isPresent(user);
	}

	public User isValid(User user) {
		return ticketsDao.isValid(user);
	}

	public void insertOrganizer(Organizer organizer) {
		ticketsDao.insertOrganizer(organizer);
	}

	public boolean isPresentOrganizer(Organizer organizer) {
		return ticketsDao.isPresentOrganizer(organizer);
	}

	public Organizer isValidOrganizer(Organizer organizer) {
		return ticketsDao.isValidOrgainizer(organizer);
	}
}
