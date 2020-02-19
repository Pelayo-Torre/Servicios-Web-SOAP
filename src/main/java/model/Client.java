package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

public class Client {

	private Long id;
	private String name;
	private String dni;
	private String telephone;
	private String email;
	private boolean active;

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
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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
	 * @param hotelId
	 * @param bookings
	 */
	public Client(String name, String dni, String telephone, String email, boolean active, Long hotelId,
			Set<Booking> bookings) {
		super();
		this.name = name;
		this.dni = dni;
		this.telephone = telephone;
		this.email = email;
		this.active = active;
		this.hotelId = hotelId;
		this.bookings = bookings;
	}

}
