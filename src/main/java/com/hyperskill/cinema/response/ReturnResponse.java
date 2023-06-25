package com.hyperskill.cinema.response;

import com.hyperskill.cinema.models.Seat;

public class ReturnResponse {
    private Seat returned_ticket;

    public ReturnResponse(int row, int column) {
        this.returned_ticket = new Seat(row,column);
    }

    public Seat getReturned_ticket() {
        return returned_ticket;
    }

    public void setReturned_ticket(Seat returned_ticket) {
        this.returned_ticket = returned_ticket;
    }
}
