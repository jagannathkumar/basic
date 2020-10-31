package com.myproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="booking")
public class Booking {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@OneToOne
	private RunningShows runningShows;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public RunningShows getRunningShows() {
		return runningShows;
	}
	public void setRunningShows(RunningShows runningShows) {
		this.runningShows = runningShows;
	}
}
