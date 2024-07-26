package com.Theatre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Theatre.entity.Movie;
import com.Theatre.entity.Show;
import com.Theatre.entity.Theatre;
import com.Theatre.repo.MovieRepository;
import com.Theatre.repo.ShowRepository;
import com.Theatre.repo.TheatreRepository;

@Service
public class ShowService {
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private TheatreRepository theatreRepository;
    @Autowired
    private MovieRepository movieRepository;

    public List<Show> getAllShows() {
        return showRepository.findAll();
    }

    public Show getShow(Long id) {
        return showRepository.findById(id).orElseThrow();
    }

    public Show createShow(Show show) {
        return showRepository.save(show);
    }

    public Show updateShow(Show show) {
        return showRepository.save(show);
    }

    public void deleteShow(Long id) {
        showRepository.deleteById(id);
    }

    public List<Show> getShowsByTheatre(Long theatreId) {
        Theatre theatre = theatreRepository.findById(theatreId).orElseThrow();
        return showRepository.findByTheatre(theatre);
    }

    public List<Show> getShowsByMovie(Long movieId) {
        Movie movie = movieRepository.findById(movieId).orElseThrow();
        return showRepository.findByMovie(movie);
    }
}
