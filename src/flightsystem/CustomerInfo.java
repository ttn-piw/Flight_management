/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightsystem;

import java.util.Date;

/**
 *
 * @author LENOVO
 */
public class CustomerInfo {
    private String cust_id;
    private String cust_name;
    private String cust_gender;
    private String cust_email;
    private String cust_phone;
    private String cust_address;
    private String flight_id;
    private Date departure_date;
    private Date arrival_date;
    private String departure_airport;
    private String arrival_airport;
    private Integer seats;
   
    
    public CustomerInfo(String cid,String cname, String cgender,String cemail,String cphone, String caddress,String fid, Date fdd , Date fad, String fda,String faa,Integer fs){
        this.cust_id = cust_id;
        this.cust_name =cust_name;
        this.cust_gender = cust_gender;
        this.cust_email= cust_email;
        this.cust_phone= cust_phone;
        this.cust_address = cust_address;
        this.flight_id = flight_id;
        this.departure_date = departure_date;
        this.arrival_date = arrival_date;
        this.departure_airport = departure_airport;
        this.arrival_airport = arrival_airport;
        this.seats = seats;
    }

    public String getCust_id() {
        return cust_id;
    }

    public void setCust_id(String cust_id) {
        this.cust_id = cust_id;
    }

    public String getCust_name() {
        return cust_name;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }

    public String getCust_gender() {
        return cust_gender;
    }

    public void setCust_gender(String cust_gender) {
        this.cust_gender = cust_gender;
    }

    public String getCust_email() {
        return cust_email;
    }

    public void setCust_email(String cust_email) {
        this.cust_email = cust_email;
    }

    public String getCust_phone() {
        return cust_phone;
    }

    public void setCust_phone(String cust_phone) {
        this.cust_phone = cust_phone;
    }

    public String getCust_address() {
        return cust_address;
    }

    public void setCust_address(String cust_address) {
        this.cust_address = cust_address;
    }

    public String getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(String flight_id) {
        this.flight_id = flight_id;
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
    
}