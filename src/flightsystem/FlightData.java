/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightsystem;

import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class FlightData {
    private Integer flight_id;
    private Integer airline_id;
    private Date departure_date;
    private Date arrival_date;
    private String departure_airport;
    private String arrival_airport;
    private Integer seats;
    private Double price;

    public FlightData(Integer flight_id, Integer airline_id, Date departure_date, Date arrival_date, String departure_airport, String arrival_airport, Integer seats, Double price) {
        this.flight_id=flight_id;
        this.airline_id=airline_id;
        this.departure_date=departure_date;
        this.arrival_date=arrival_date;
        this.departure_airport=departure_airport;
        this.arrival_airport=arrival_airport;
        this.seats=seats;
        this.price=price;
    }
    
    
    public Integer getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(Integer flight_id) {
        this.flight_id = flight_id;
    }

    public Integer getAirline_id() {
        return airline_id;
    }

    public void setAirline_id(Integer airline_id) {
        this.airline_id = airline_id;
    }

    public Date getDeparture_date() {
        return departure_date;
    }

    public void setDeparture_date(Date departure_date) {
        this.departure_date = departure_date;
    }

    public Date getArrival_date() {
        return arrival_date;
    }

    public void setArrival_date(Date arrival_date) {
        this.arrival_date = arrival_date;
    }

    public String getDeparture_airport() {
        return departure_airport;
    }

    public void setDeparture_airport(String departure_airport) {
        this.departure_airport = departure_airport;
    }

    public String getArrival_airport() {
        return arrival_airport;
    }

    public void setArrival_airport(String arrival_airport) {
        this.arrival_airport = arrival_airport;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

 
    
}


