package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlTransient;

@Entity
public class Booking{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String startDate;
	private String endDate;
	private double price;
	private Integer cancelled;

	@ManyToOne
	@JoinColumn(name = "clientId")
	private Client client;

	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "bookingservice", joinColumns = @JoinColumn(name = "bookingId"), inverseJoinColumns = @JoinColumn(name = "serviceId"))
	private Set<Service> services = new HashSet<Service>();

	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "bookingroom", joinColumns = @JoinColumn(name = "bookingId"), inverseJoinColumns = @JoinColumn(name = "roomId"))
	private Set<Room> rooms = new HashSet<Room>();

	@XmlTransient
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	public Integer getCancelled() {
		return cancelled;
	}

	public void setCancelled(Integer cancelled) {
		this.cancelled = cancelled;
	}
	
	public double subPrice(double price) {
		return this.price -= price;
	}
	
	public double addPrice(double price) {
		return this.price += price;
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
	 * @param client
	 * @param services
	 * @param rooms
	 */
	public Booking( String startDate, String endDate, double price, Client client, Set<Service> services,
			Set<Room> rooms) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
		this.client = client;
		this.services = services;
		this.rooms = rooms;
	}

}
