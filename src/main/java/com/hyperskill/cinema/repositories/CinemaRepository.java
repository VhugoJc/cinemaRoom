package com.hyperskill.cinema.repositories;

import com.hyperskill.cinema.models.Cinema;
import com.hyperskill.cinema.models.Seat;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Repository
public class CinemaRepository {
    private Cinema cinema = createCinema(9,9);

    public Cinema get(){
        return cinema;
    }

    public Cinema createCinema (int rows, int columns) {
        List<Seat> seatList = IntStream.rangeClosed(1, rows)
                .boxed()
                .flatMap(row -> IntStream.rangeClosed(1, columns)
                        .mapToObj(column -> new Seat(row, column)))
                .collect(Collectors.toList());
        return new Cinema(rows, columns, seatList);
    }
}
