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
@Table (name = "service")
public class Service {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String code;
	private Double price;

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
	public Service() {
	}

	public Service(String name, String code, Double price, Hotel hotel, Set<Booking> bookings) {
		super();
		this.name = name;
		this.code = code;
		this.price = price;
		this.hotel = hotel;
//		this.bookings = bookings;
	}

	

}
