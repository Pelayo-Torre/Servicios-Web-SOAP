package model;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "prueba")
public class Prueba implements Serializable {

	@XmlTransient
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SEQ")
	private int id;

	@Column
	private String nombre;
	
	
	@XmlTransient
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Prueba [id=" + id + ", nombre=" + nombre + "]";
	}

	public Prueba(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	public Prueba() {
		// TODO Auto-generated constructor stub
	}
	
	
}
