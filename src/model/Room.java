package model;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlTransient;

public class Room {

	private Long id;
	private String code;
	private Double price;
	private RoomType roomType;

	private Hotel hotel;
	private Set<Booking> bookings = new HashSet<Booking>();

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

	@XmlTransient
	public Set<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}

	/**
	 * Constructor
	 */
	public Room() {
	}

	/**
	 * Constructor
	 * 
	 * @param code
	 * @param price
	 * @param roomType
	 * @param hotel
	 * @param bookings
	 */
	public Room(String code, double price, RoomType roomType, Hotel hotel, Set<Booking> bookings) {
		super();
		this.code = code;
		this.price = price;
		this.roomType = roomType;
		this.hotel = hotel;
		this.bookings = bookings;
	}

}
