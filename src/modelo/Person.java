package modelo;

import javax.xml.bind.annotation.XmlTransient;

public class Person{

	private String name;
	private String mail;
	private String phone;
	private Integer age;
	private String dni;
	private Long id;
	
	private Hotel hotel;
	
	public Person() {}
		
	@XmlTransient
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getMail() {
		return mail;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	@XmlTransient
	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", mail=" + mail + ", phone=" + phone + ", age=" + age + ", dni=" + dni + "]";
	}

}
