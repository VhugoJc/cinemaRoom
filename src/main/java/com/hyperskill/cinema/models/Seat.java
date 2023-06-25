package com.hyperskill.cinema.models;

import java.util.UUID;

public class Seat {

    private boolean purchase;
    private int row;
    private int column;
    int price;

    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
        this.price = row<=4 ?10 :8;
        this.purchase = false;
    }

    public boolean isPurchase() {
        return purchase;
    }

    public void setPurchase(boolean purchase) {
        this.purchase = purchase;
    }

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
