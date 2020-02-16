package model;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlTransient;

import model.Hotel;

public class Client {

	private Long id;
	private String name;
	private String dni;
	private String telephone;
	private String email;
	private boolean active;

	private Set<Booking> bookings = new HashSet<Booking>();
	private Hotel hotel;

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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@XmlTransient
	public Set<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}

	@XmlTransient
	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	@XmlTransient
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * Constructor
	 */
	public Client() {
	}

	/**
	 * Constructor
	 * 
	 * @param name
	 * @param dni
	 * @param telephone
	 * @param email
	 * @param active
	 * @param bookings
	 * @param hotel
	 */
	public Client(String name, String dni, String telephone, String email, boolean active, Set<Booking> bookings,
			Hotel hotel) {
		super();
		this.name = name;
		this.dni = dni;
		this.telephone = telephone;
		this.email = email;
		this.active = active;
		this.bookings = bookings;
		this.hotel = hotel;
	}

}
