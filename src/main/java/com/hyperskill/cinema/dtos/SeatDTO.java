package com.hyperskill.cinema.dtos;

import com.hyperskill.cinema.models.Ticket;

import java.util.UUID;

public class SeatDTO{
    private Ticket ticket;
    private UUID token;

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
