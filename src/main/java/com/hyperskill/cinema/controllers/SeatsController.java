package com.hyperskill.cinema.controllers;

import com.hyperskill.cinema.dtos.CinemaDTO;

import com.hyperskill.cinema.dtos.SeatDTO;
import com.hyperskill.cinema.models.Purchase;
import com.hyperskill.cinema.models.Seat;
import com.hyperskill.cinema.requests.PurchaseRequest;
import com.hyperskill.cinema.requests.ReturnRequest;
import com.hyperskill.cinema.services.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;

@RestController
@RequestMapping
public class SeatsController {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CinemaService cinemaService;

    @GetMapping("/seats")
    ResponseEntity<?> getSeats () {
        CinemaDTO response = this.modelMapper.map(this.cinemaService.getAvailableSeats(), CinemaDTO.class);
        return new ResponseEntity<CinemaDTO>(response,HttpStatus.OK);
    }
    @PostMapping("/purchase")
    ResponseEntity<?> postPurchase (@RequestBody PurchaseRequest purchase) {
        Purchase seat = this.cinemaService.setSeat(purchase);
        return new ResponseEntity<Purchase>(seat,HttpStatus.OK);
    }

    @PostMapping("/return")
    ResponseEntity<?> postReturn(@RequestBody ReturnRequest returnRequest){
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
