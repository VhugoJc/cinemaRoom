package com.hyperskill.cinema.dtos;

import com.hyperskill.cinema.models.Seat;

public class PurchaseDTO {
    private SeatDTO returned_ticket;

    public SeatDTO getReturned_ticket() {
        return returned_ticket;
    }

    public void setReturned_ticket(SeatDTO returned_ticket) {
        this.returned_ticket = returned_ticket;
    }
}
