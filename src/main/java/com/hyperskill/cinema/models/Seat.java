package com.hyperskill.cinema.models;

public class Seat {
    private int row;
    private int column;
    private int price;
    private boolean purchase;

    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
        this.purchase = false;
        this.price = row <= 4 ? 10 : 8;
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

    public boolean isPurchase() {
        return purchase;
    }

    public void setPurchase(boolean purchase) {
        this.purchase = purchase;
    }
}
