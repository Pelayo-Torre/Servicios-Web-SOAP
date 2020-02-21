package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

@Entity
public class Room implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String code;
	private Double price;
	private String type;

	@Transient
	private RoomType roomType;

	@ManyToOne
	@JoinColumn(name = "hotelId", nullable = false)
	private Hotel hotel;

	@ManyToMany(mappedBy = "rooms")
	private Set<Booking> bookings = new HashSet<Booking>();

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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@XmlTransient
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	@XmlTransient
	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
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
	public Room() {
	}

	/**
	 * Constructor
	 * 
	 * @param code
	 * @param price
	 * @param type
	 * @param roomType
	 * @param hotel
	 * @param bookings
	 */
	public Room(String code, Double price, String type, RoomType roomType, Hotel hotel, Set<Booking> bookings) {
		super();
		this.code = code;
		this.price = price;
		this.type = type;
		this.roomType = roomType;
		this.hotel = hotel;
		this.bookings = bookings;
	}

}
