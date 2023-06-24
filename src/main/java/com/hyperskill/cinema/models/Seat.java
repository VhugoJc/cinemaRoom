package com.hyperskill.cinema.models;

import java.util.UUID;

public class Seat {

    private boolean purchase;
    private UUID token;
    private Ticket ticket;

    public Seat(int row, int column) {
        this.token =  UUID.randomUUID();
        this.purchase = false;
        this.ticket = new Ticket();
        this.ticket.setRow(row);
        this.ticket.setColumn(column);
        this.ticket.setPrice(row <= 4 ? 10 : 8);
    }

    public Seat() {
    }
    // for SeatDTO
    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }

    //
    public int getRow() {
        return ticket.getRow();
    }
    public int getColumn() {
        return ticket.getColumn();
    }

    public boolean isPurchase() {
        return purchase;
    }

    public void setPurchase(boolean purchase) {
        this.purchase = purchase;
    }
}
