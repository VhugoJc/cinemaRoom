package com.hyperskill.cinema.services;

import com.hyperskill.cinema.models.Cinema;
import com.hyperskill.cinema.models.Purchase;
import com.hyperskill.cinema.models.Seat;
import com.hyperskill.cinema.models.Ticket;
import com.hyperskill.cinema.repositories.CinemaRepository;
import com.hyperskill.cinema.repositories.PurchaseRepository;
import com.hyperskill.cinema.requests.PurchaseRequest;
import com.hyperskill.cinema.requests.ReturnRequest;
import com.hyperskill.cinema.response.ReturnResponse;
import com.hyperskill.cinema.response.StatsResponse;
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

    // Retrieves all seats in the cinema.
    public Cinema getAllSeats() {
        return this.cinemaRepository.get();
    }

    // Retrieves the available seats in the cinema.
    public Cinema getAvailableSeats (){
        Cinema cinema = new Cinema(getAllSeats());
        List<Seat> seatList = cinema.getAvailable_seats();
        List<Seat> filteredList = seatList.stream()
                .filter(seat -> !seat.isPurchase())
                .collect(Collectors.toList());
        cinema.setAvailable_seats(filteredList);
        return cinema;
    }

    // Sets a seat as purchased based on the purchase request.
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

    // Returns a purchased seat based on the return request.
    public ReturnResponse returnSeat(ReturnRequest returnReq) {
        List<Purchase> purchaseList = this.purchaseRepository.getAll();
        Purchase purchase = purchaseList.stream()
                .filter(p -> p.getToken().equals(returnReq.getToken()))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Wrong token!"));
        this.purchaseRepository.remove(purchase);
        ReturnResponse resp = new ReturnResponse(purchase.getTicket().getRow(),purchase.getTicket().getColumn());
        return resp;
    }

    // Retrieves the statistics of the cinema.
    public StatsResponse getStats(){
        List<Purchase> purchaseList = this.purchaseRepository.getAll();
        List<Seat> seatList = getAllSeats().getAvailable_seats();
        int income = 0;
        for (Purchase p: purchaseList){
            income+=p.getTicket().getPrice();
        }
        StatsResponse resp = new StatsResponse();
        resp.setCurrent_income(income);
        resp.setNumber_of_available_seats(seatList.size()-purchaseList.size());
        resp.setNumber_of_purchased_tickets(purchaseList.size());
        return resp;
    }
}
