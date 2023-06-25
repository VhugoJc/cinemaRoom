package com.hyperskill.cinema.services;

import com.hyperskill.cinema.models.Cinema;
import com.hyperskill.cinema.models.Purchase;
import com.hyperskill.cinema.models.Seat;
import com.hyperskill.cinema.models.Ticket;
import com.hyperskill.cinema.repositories.CinemaRepository;
import com.hyperskill.cinema.repositories.PurchaseRepository;
import com.hyperskill.cinema.requests.PurchaseRequest;
import com.hyperskill.cinema.requests.ReturnRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CinemaService {
    @Autowired
    private CinemaRepository cinemaRepository;
    @Autowired
    private PurchaseRepository purchaseRepository;
    public Cinema getAllSeats() {
        return this.cinemaRepository.get();
    }

    public Cinema getAvailableSeats (){
        Cinema cinema = new Cinema(getAllSeats());
        List<Seat> seatList = cinema.getAvailable_seats();
        List<Seat> filteredList = seatList.stream()
                .filter(seat -> !seat.isPurchase())
                .collect(Collectors.toList());
        cinema.setAvailable_seats(filteredList);
        return cinema;
    }

    public Purchase setSeat(PurchaseRequest request){
        List<Seat> seatList = getAllSeats().getAvailable_seats();

        Seat selectedSeat = seatList.stream()
                .filter(seat -> seat.getRow() == request.getRow() && seat.getColumn() == request.getColumn())
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "The number of a row or a column is out of bounds!"));

        if (selectedSeat.isPurchase()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The ticket has already been purchased.");
        }

        selectedSeat.setPurchase(true);
        Purchase newPurchase = new Purchase(selectedSeat.getRow(), selectedSeat.getColumn(), selectedSeat.getPrice());
        this.purchaseRepository.add(newPurchase);
        return newPurchase;
    }


}
