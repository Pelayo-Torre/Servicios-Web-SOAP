package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table (name = "client")
public class Client {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String dni;
	private String telephone;
	private String email;
	private boolean active;

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
	public Client() {
	}

}
