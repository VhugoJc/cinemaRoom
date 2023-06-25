package com.hyperskill.cinema.controllers;

import com.hyperskill.cinema.dtos.CinemaDTO;

import com.hyperskill.cinema.dtos.PurchaseDTO;
import com.hyperskill.cinema.models.Purchase;
import com.hyperskill.cinema.requests.PurchaseRequest;
import com.hyperskill.cinema.requests.ReturnRequest;
import com.hyperskill.cinema.response.ReturnResponse;
import com.hyperskill.cinema.response.StatsResponse;
import com.hyperskill.cinema.services.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping
public class CinemaController {
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
        PurchaseDTO rep = this.modelMapper.map(this.cinemaService.returnSeat(returnRequest), PurchaseDTO.class);
        return new ResponseEntity<PurchaseDTO>(rep,HttpStatus.OK);
    }

    @PostMapping("/stats")
    ResponseEntity<?> postStatics(@RequestParam String password){
        if(!password.equals("super_secret")){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "The password is wrong!");
        }

        return new ResponseEntity<StatsResponse>(this.cinemaService.getStats(), HttpStatus.OK);
    }
}
