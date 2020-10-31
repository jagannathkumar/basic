package com.mindtree.ticketshere.service;

import com.mindtree.ticketshere.entity.Organizer;
import com.mindtree.ticketshere.entity.User;

public interface LoginSignUpService {

	public void insert(User user);
	public User isValid(User user);
	public void insertOrganizer(Organizer organizer);
	public boolean isPresentOrganizer(Organizer organizer);
	public Organizer isValidOrganizer(Organizer organizer);
}
