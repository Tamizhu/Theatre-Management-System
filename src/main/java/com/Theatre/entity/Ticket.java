package com.Theatre.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Ticket {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private int ticketNumber;
  private String seatNumber;
  
  @ManyToOne
  @JoinColumn(name = "show_id")
  private Show show;
  
  @Enumerated(EnumType.STRING)
  private TicketType ticketType;
  private double price;
  
public Ticket(String ticketNumber2, String seatNumber2, String type, double price2, Show show2) {}


public Ticket(int ticketNumber, String seatNumber, Show show, TicketType ticketType, double price) {
	super();
	this.ticketNumber = ticketNumber;
	this.seatNumber = seatNumber;
	this.show = show;
	this.ticketType = ticketType;
	this.price = price;
}


public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public int getTicketNumber() {
	return ticketNumber;
}
public void setTicketNumber(int ticketNumber) {
	this.ticketNumber = ticketNumber;
}
public String getSeatNumber() {
	return seatNumber;
}
public void setSeatNumber(String seatNumber) {
	this.seatNumber = seatNumber;
}
public Show getShow() {
	return show;
}
public void setShow(Show show) {
	this.show = show;
}
public TicketType getTicketType() {
	return ticketType;
}
public void setTicketType(TicketType ticketType) {
	this.ticketType = ticketType;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
@Override
public String toString() {
	return "Ticket [id=" + id + ", ticketNumber=" + ticketNumber + ", seatNumber=" + seatNumber + ", show=" + show
			+ ", ticketType=" + ticketType + ", price=" + price + "]";
}
  
    
}
