package modelo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlTransient;

import model.Client;

public class Reservation {
	
	private Long id;
	private String code;
	private Date initialDate;
	private Date finalDate;
	private double price;
	
	private Client person;
	
	private Set<Room> rooms = new HashSet<Room>();
	
	private Set<Service> services = new HashSet<Service>();

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getInitialDate() {
		return initialDate;
	}

	public void setInitialDate(Date initialDate) {
		this.initialDate = initialDate;
	}

	public Date getFinalDate() {
		return finalDate;
	}

	public void setFinalDate(Date finalDate) {
		this.finalDate = finalDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@XmlTransient
	public Client getPerson() {
		return person;
	}

	public void setPerson(Client person) {
		this.person = person;
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

	@XmlTransient
	public Long getId() {
		return id;
	}
	

}
