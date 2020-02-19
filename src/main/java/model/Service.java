package model;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlTransient;

public class Service {

	private Long id;
	private String name;
	private String code;
	private Double price;

	private Long hotelId;
	private Set<Booking> bookings = new HashSet<Booking>();

	@XmlTransient
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Long getHotelId() {
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
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
	public Service() {
	}

	/**
	 * Constructor
	 * 
	 * @param name
	 * @param code
	 * @param price
	 * @param hotelId
	 * @param bookings
	 */
	public Service(String name, String code, double price, Long hotelId, Set<Booking> bookings) {
		super();
		this.name = name;
		this.code = code;
		this.price = price;
		this.hotelId = hotelId;
		this.bookings = bookings;
	}

}
