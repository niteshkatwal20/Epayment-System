package com.example.smartpay.Movie;

public class MovieModel {
    String id, hallName, movieName, customerName, noofSeats, movieTicketAmount;

    public MovieModel() {
    }

    public MovieModel(String id, String hallName, String movieName, String customerName, String noofSeats, String movieTicketAmount) {
        this.id = id;
        this.hallName = hallName;
        this.movieName = movieName;
        this.customerName = customerName;
        this.noofSeats = noofSeats;
        this.movieTicketAmount = movieTicketAmount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getNoofSeats() {
        return noofSeats;
    }

    public void setNoofSeats(String noofSeats) {
        this.noofSeats = noofSeats;
    }

    public String getMovieTicketAmount() {
        return movieTicketAmount;
    }

    public void setMovieTicketAmount(String movieTicketAmount) {
        this.movieTicketAmount = movieTicketAmount;
    }
}
