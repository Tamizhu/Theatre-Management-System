package com.Theatre.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Theatre.entity.Show;
import com.Theatre.entity.Ticket;
import com.Theatre.service.ShowService;
import com.Theatre.service.TicketService;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    @Autowired
    private ShowService showService;
    @Autowired
    private TicketService ticketService;

    @GetMapping
    public List<Show> getAllShows() {
        return showService.getAllShows();
    }

    @GetMapping("/{id}")
    public Show getShow(@PathVariable Long id) {
        return showService.getShow(id);
    }

    @PostMapping
    public Show createShow(@RequestBody Show show) {
        return showService.createShow(show);
    }

    @PutMapping("/{id}")
    public Show updateShow(@PathVariable Long id, @RequestBody Show show) {
        show.setId(id);
        return showService.updateShow(show);
    }

    @DeleteMapping("/{id}")
    public void deleteShow(@PathVariable Long id) {
        showService.deleteShow(id);
    }

    @GetMapping("/{showId}/tickets")
    public List<Ticket> getTicketsByShow(@PathVariable Long showId) {
        return ticketService.getTicketsByShow(showId);
    }

    @PostMapping("/{showId}/tickets")
    public Ticket createTicket(@PathVariable Long showId, @RequestBody Ticket ticket) {
        Show show = showService.getShow(showId);
        ticket.setShow(show);
        return ticketService.createTicket(ticket);
    }
}
