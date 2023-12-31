package com.hyperskill.cinema.dtos;

import com.hyperskill.cinema.models.Ticket;

import java.util.UUID;

public class SeatDTO{
    private int row;
    private int column;
    private int price;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
