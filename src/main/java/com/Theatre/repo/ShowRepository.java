package com.Theatre.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Theatre.entity.Movie;
import com.Theatre.entity.Show;
import com.Theatre.entity.Theatre;


@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
    List<Show> findByTheatreId(Long theatreId);
    List<Show> findByMovie(Movie movie);
	List<Show> findByTheatre(Theatre theatre);
}