package model;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlTransient;

public class Booking {

	private Long id;
	private String code;
	private String startDate;
	private String endDate;
	private double price;
	private boolean cancelled;

	private Long clientId;
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

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
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
	 * @param clientId
	 * @param services
	 * @param rooms
	 */
	public Booking(String code, String startDate, String endDate, double price, boolean cancelled, Long clientId,
			Set<Service> services, Set<Room> rooms) {
		super();
		this.code = code;
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
		this.cancelled = cancelled;
		this.clientId = clientId;
		this.services = services;
		this.rooms = rooms;
	}
}
