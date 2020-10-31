package com.mindtree.ticketshere.dao;

import com.mindtree.ticketshere.entity.Organizer;
import com.mindtree.ticketshere.entity.User;

public interface DaoLoginSignup {
	public void insert(User user);
	public boolean isPresent(User user);
	public User isValid(User user);
	public void insertOrganizer(Organizer organizer);
	public boolean isPresentOrganizer(Organizer organizer);
	public Organizer isValidOrgainizer(Organizer organizer);
}
