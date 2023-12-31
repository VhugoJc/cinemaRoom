package com.hyperskill.cinema.models;

import java.util.List;

public class Cinema {
        private int total_rows;
        private int total_columns;
        private List<Seat> available_seats;

    public int getTotal_rows() {
        return total_rows;
    }

    public Cinema(Cinema obj) {
        this.total_rows = obj.total_rows;
        this.total_columns = obj.total_columns;
        this.available_seats = obj.available_seats;
    }

    public Cinema(int total_rows, int total_columns, List<Seat> available_seats) {
        this.total_rows = total_rows;
        this.total_columns = total_columns;
        this.available_seats = available_seats;
    }

    public void setTotal_rows(int total_rows) {
        this.total_rows = total_rows;
    }

    public int getTotal_columns() {
        return total_columns;
    }

    public void setTotal_columns(int total_columns) {
        this.total_columns = total_columns;
    }

    public List<Seat> getAvailable_seats() {
        return available_seats;
    }

    public void setAvailable_seats(List<Seat> available_seats) {
        this.available_seats = available_seats;
    }

}
