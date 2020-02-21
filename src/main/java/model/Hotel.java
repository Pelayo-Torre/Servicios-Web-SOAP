package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "hotel")
public class Hotel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private double latitude;
	private double longitude;
	private String country;
	private int stars;
	private String telephone;
	private String address;

	@Transient
	private Location location;

	@OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
	private Set<Client> clients = new HashSet<Client>();
	@OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
	private Set<Room> rooms = new HashSet<Room>();
	@OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
	private Set<Service> services = new HashSet<Service>();

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

	@XmlTransient
	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	@XmlTransient
	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@XmlTransient
	public Set<Client> getClients() {
		return clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

	@XmlTransient
	public Set<Room> getRooms() {
		return rooms;
	}

	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}

	@XmlTransient
	public Set<Service> getServices() {
		return services;
	}

	public void setServices(Set<Service> services) {
		this.services = services;
	}

	/**
	 * Constructor
	 */
	public Hotel() {
	}

	public Hotel(String name, double latitude, double longitude, String country, int stars, String telephone,
			String address, Location location, Set<Client> clients, Set<Room> rooms, Set<Service> services) {
		super();
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
		this.country = country;
		this.stars = stars;
		this.telephone = telephone;
		this.address = address;
		this.location = location;
		this.clients = clients;
		this.rooms = rooms;
		this.services = services;
	}

}
