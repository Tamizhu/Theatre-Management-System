package com.Theatre.entity;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "`show`")
public class Show {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @ManyToOne
	    @JoinColumn(name = "theatre_id")
	    private Theatre theatre;
	    @ManyToOne
	    @JoinColumn(name = "movie_id")
	    private Movie movie;
	    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<Ticket> tickets;
	    
	    
	    
		public Show() {
			 
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Theatre getTheatre() {
			return theatre;
		}
		public void setTheatre(Theatre theatre) {
			this.theatre = theatre;
		}
		public Movie getMovie() {
			return movie;
		}
		public void setMovie(Movie movie) {
			this.movie = movie;
		}
		public List<Ticket> getTickets() {
			return tickets;
		}
		public void setTickets(List<Ticket> tickets) {
			this.tickets = tickets;
		}
		public String getTime() {
		    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
		    return LocalTime.now().format(formatter);
		}
  
  
}
