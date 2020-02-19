package model;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlTransient;

public class Hotel {

	private Long id;
	private String name;
	private Location location;
	private String country;
	private int stars;
	private String telephone;
	private String address;
	private boolean deleted;

	private Set<Client> clients = new HashSet<Client>();
	private Set<Room> rooms = new HashSet<Room>();
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

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
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

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
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

	public Hotel(String name, Location location, String country, int stars, String telephone, String address,
			boolean deleted, Set<Client> clients, Set<Room> rooms, Set<Service> services) {
		super();
		this.name = name;
		this.location = location;
		this.country = country;
		this.stars = stars;
		this.telephone = telephone;
		this.address = address;
		this.deleted = deleted;
		this.clients = clients;
		this.rooms = rooms;
		this.services = services;
	}

}
