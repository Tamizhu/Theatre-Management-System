package com.Theatre.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Theatre.entity.Theatre;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Long> {

}
