package com.Theatre.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Theatre.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

}
