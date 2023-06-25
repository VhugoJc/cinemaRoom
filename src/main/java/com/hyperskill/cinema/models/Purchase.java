package com.hyperskill.cinema.models;

import java.util.UUID;

public class Purchase {
    private UUID token;
    private Ticket ticket;

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

    public  Purchase(int row, int column, int price) {
        this.ticket = new Ticket();
        this.ticket.setColumn(column);
        this.ticket.setRow(row);
        this.ticket.setPrice(price);
        this.token = UUID.randomUUID();
    }


}
