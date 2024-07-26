package com.Theatre.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Theatre {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private int capacity;
  
  @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Show> shows;
  
  

public Theatre(  String name, int capacity, List<Show> shows) {
	super();
	 
	this.name = name;
	this.capacity = capacity;
	this.shows = shows;
}



public Theatre() {}



public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getCapacity() {
	return capacity;
}

public void setCapacity(int capacity) {
	this.capacity = capacity;
}

public List<Show> getShows() {
	return shows;
}

public void setShows(List<Show> shows) {
	this.shows = shows;
}

@Override
public String toString() {
	return "Theatre [id=" + id + ", name=" + name + ", capacity=" + capacity + ", shows=" + shows + "]";
}
  
  	
}
