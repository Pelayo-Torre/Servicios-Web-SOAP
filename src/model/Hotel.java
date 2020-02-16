package model;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlTransient;

import model.Client;

public class Hotel {

	private Long id;
	private String name;
	private Location location;
	private int stars;
	private String telephone;

	private Address address;

	private Integer totalRooms;
	private String country;

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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Integer getTotalRooms() {
		return totalRooms;
	}

	public void setTotalRooms(Integer totalRooms) {
		this.totalRooms = totalRooms;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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

	/**
	 * Constructor
	 * 
	 * @param name
	 * @param location
	 * @param stars
	 * @param telephone
	 * @param address
	 * @param totalRooms
	 * @param country
	 * @param clients
	 * @param rooms
	 * @param services
	 */
	public Hotel(String name, Location location, int stars, String telephone, Address address, Integer totalRooms,
			String country, Set<Client> clients, Set<Room> rooms, Set<Service> services) {
		super();
		this.name = name;
		this.location = location;
		this.stars = stars;
		this.telephone = telephone;
		this.address = address;
		this.totalRooms = totalRooms;
		this.country = country;
		this.clients = clients;
		this.rooms = rooms;
		this.services = services;
	}

}
