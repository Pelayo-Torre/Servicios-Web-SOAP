package model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlTransient;

import model.Client;

public class Booking {

	private Long id;
	private String code;
	private Date startDate;
	private Date endDate;
	private double price;
	private boolean cancelled;

	private Client client;
	private Set<Service> services = new HashSet<Service>();
	private Set<Room> rooms = new HashSet<Room>();

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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@XmlTransient
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@XmlTransient
	public Set<Service> getServices() {
		return services;
	}

	public void setServices(Set<Service> services) {
		this.services = services;
	}

	@XmlTransient
	public Set<Room> getRooms() {
		return rooms;
	}

	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}

	@XmlTransient
	public boolean isCancelled() {
		return cancelled;
	}

	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}

	/**
	 * Constructor
	 */
	public Booking() {
	}

	/**
	 * Constructor
	 * 
	 * @param code
	 * @param startDate
	 * @param endDate
	 * @param price
	 * @param cancelled
	 * @param client
	 * @param services
	 * @param rooms
	 */
	public Booking(String code, Date startDate, Date endDate, double price, boolean cancelled, Client client,
			Set<Service> services, Set<Room> rooms) {
		super();
		this.code = code;
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
		this.cancelled = cancelled;
		this.client = client;
		this.services = services;
		this.rooms = rooms;
	}
}
