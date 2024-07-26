package com.Theatre.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Theatre.entity.Theatre;
import com.Theatre.service.TheatreService;

@RestController
@RequestMapping("/api/theatres")
public class TheatreController {
    @Autowired
    private TheatreService theatreService;

    @GetMapping
    public List<Theatre> getAllTheatres() {
        return theatreService.getAllTheatres();
    }

//    @GetMapping("/{id}")
//    public Theatre getTheatre(@PathVariable Long id) {
//        return theatreService.getTheatre(id);
//    }
//
//    @PostMapping
//    public Theatre createTheatre(@RequestBody Theatre theatre) {
//        return theatreService.createTheatre(theatre);
//    }
//
//    @PutMapping("/{id}")
//    public Theatre updateTheatre(@PathVariable Long id, @RequestBody Theatre theatre) {
//        theatre.setId(id);
//        return theatreService.updateTheatre(theatre);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteTheatre(@PathVariable Long id) {
//        theatreService.deleteTheatre(id);
//    }
}
