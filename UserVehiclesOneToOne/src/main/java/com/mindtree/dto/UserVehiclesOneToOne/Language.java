package com.mindtree.dto.UserVehiclesOneToOne;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="language_master")
public class Language {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="LANGUAGE_ID")
	private int id;
	String language;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
}
