package com.Theatre.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Theatre.entity.Show;
import com.Theatre.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long>{

	List<Ticket> findByShow(Show show);

}
