package com.Theatre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Theatre.entity.Movie;
import com.Theatre.entity.Show;
import com.Theatre.entity.Theatre;
import com.Theatre.entity.Ticket;
import com.Theatre.repo.MovieRepository;
import com.Theatre.repo.ShowRepository;
import com.Theatre.repo.TheatreRepository;
import com.Theatre.repo.TicketRepository;

@Service
public class TheatreService {
    @Autowired
    private TheatreRepository theatreRepository;
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private TicketRepository ticketRepository;

    public List<Theatre> getAllTheatres() {
        return theatreRepository.findAll();
    }

    public List<Show> getShowsByTheatre(Long theatreId) {
        return showRepository.findByTheatreId(theatreId);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public List<Show> getShowsByMovie(Long movieId) {
        Movie movie = movieRepository.findById(movieId).orElseThrow();
        return showRepository.findByMovie(movie);
    }

    public void issueTicket(Long showId, String ticketNumber, String seatNumber, String type, double price) {
        Show show = showRepository.findById(showId).orElseThrow();
        Ticket ticket = new Ticket(ticketNumber, seatNumber, type, price, show);
        ticketRepository.save(ticket);
    }

    public void generateReport() {
        List<Show> shows = showRepository.findAll();
        for (Show show : shows) {
            double totalAmount = show.getTickets().stream().mapToDouble(Ticket::getPrice).sum();
            System.out.println(show.getTheatre().getName() + ", " + show.getTime() + ", " + totalAmount + " Rs");
        }
    }
}
