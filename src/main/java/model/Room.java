package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table (name = "room")
public class Room {

	@Id
	@GeneratedValue
	private Long id;
	private String code;
	private Double price;
	private RoomType roomType;

	@ManyToOne
	@JoinColumn(name="hotelId", nullable=false)
	private Hotel hotel;
	
	//private Set<Booking> bookings = new HashSet<Booking>();

	@XmlTransient
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	@XmlTransient
	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

//	@XmlTransient
//	public Set<Booking> getBookings() {
//		return bookings;
//	}
//
//	public void setBookings(Set<Booking> bookings) {
//		this.bookings = bookings;
//	}

	/**
	 * Constructor
	 */
	public Room() {
	}

	public Room(String code, Double price, RoomType roomType, Hotel hotel, Set<Booking> bookings) {
		super();
		this.code = code;
		this.price = price;
		this.roomType = roomType;
		this.hotel = hotel;
		//this.bookings = bookings;
	}

	

}
