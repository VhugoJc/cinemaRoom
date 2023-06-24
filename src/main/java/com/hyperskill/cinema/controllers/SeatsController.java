package com.hyperskill.cinema.controllers;

import com.hyperskill.cinema.dtos.CinemaDTO;
import com.hyperskill.cinema.models.Cinema;
import com.hyperskill.cinema.models.Seat;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/seats")
public class SeatsController {
    @Autowired
    private ModelMapper modelMapper;
    private Cinema cinema = createCinema();
    private final int rows = 9;
    private final int columns = 9;

    private Cinema createCinema () {
        List<Seat> seatList = new ArrayList<>();
        for(int i = 1; i <= rows; i++){
            for(int j = 1; j <= columns; j++){
                Seat newSeat = new Seat(i,j);
                seatList.add(newSeat);
            }
        }
        return new Cinema(rows, columns, seatList);
    }

    @GetMapping
    ResponseEntity<?> getSeats () {
        CinemaDTO response = this.modelMapper.map(cinema, CinemaDTO.class);
        return new ResponseEntity<CinemaDTO>(response,HttpStatus.OK);
    }
}
