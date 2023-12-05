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

public class BookingData {
       private Integer booking_id;
    private Integer flight_id;
    private Integer cust_id;
    private String cust_name;
    private String cust_phone;
    private Integer booked_seats;
    private Double total_amount;
    private Date booking_date;

    public BookingData(Integer booking_id, Integer flight_id, Integer cust_id, String cust_name, String cust_phone, Integer booked_seats, Double total_amount, Date booking_date) {
        this.booking_id = booking_id;
        this.flight_id = flight_id;
        this.cust_id = cust_id;
        this.cust_name = cust_name;
        this.cust_phone = cust_phone;
        this.booked_seats = booked_seats;
        this.total_amount = total_amount;
        this.booking_date = booking_date;
    }
    
    

    public Integer getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(Integer booking_id) {
        this.booking_id = booking_id;
    }

    public Integer getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(Integer flight_id) {
        this.flight_id = flight_id;
    }

    public Integer getCust_id() {
        return cust_id;
    }

    public void setCust_id(Integer cust_id) {
        this.cust_id = cust_id;
    }

    public Integer getBooked_seats() {
        return booked_seats;
    }

    public void setBooked_seats(Integer booked_seats) {
        this.booked_seats = booked_seats;
    }

    public Double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(Double total_amount) {
        this.total_amount = total_amount;
    }

    public Date getBooking_date() {
        return booking_date;
    }

    public void setBooking_date(Date booking_date) {
        this.booking_date = booking_date;
    }

    public String getCust_name() {
        return cust_name;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }

    public String getCust_phone() {
        return cust_phone;
    }

    public void setCust_phone(String cust_phone) {
        this.cust_phone = cust_phone;
    }

}
