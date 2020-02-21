package persistence;

import java.util.List;

import javax.persistence.EntityManager;

import exception.HotelException;
import model.Hotel;
import utils.Constants;

public class HotelDAO {

	/**
	 * Constructor
	 */
	public HotelDAO() {
	}

	/**
	 * Método para almacenar el hotel que se pasa por parámetro
	 * 
	 * @param hotel
	 */
	public String addHotel(Hotel hotel) {
		Dba dba = new Dba();
		try {
			EntityManager em = dba.getActiveEm();
			em.persist(hotel);
			em.getTransaction().commit();
			return Constants.RESPONSE_OK;
		} finally {
			dba.closeEm();
		}
	}

	/**
	 * Método para borrar el hotel cuyo id se pasa por parametro
	 * 
	 * @return
	 * @throws HotelException
	 */
	public String deleteHotel(Long id) throws HotelException {
		Dba dba = new Dba();
		try {
			EntityManager em = dba.getActiveEm();

			Hotel hotel = em.find(Hotel.class, id);
			if (hotel == null)
				throw new HotelException("El hotel con id =  " + id + " no existe.", "404");

			em.getTransaction().begin();
			em.remove(hotel);
			em.getTransaction().commit();
			return Constants.RESPONSE_OK;
		} finally {
			dba.closeEm();
		}
	}

	/**
	 * Método para actualizar el hotel que se pasa por parámetro
	 * 
	 * @param hotel
	 */
	public String updateHotel(Hotel hotel) {
		Dba dba = new Dba();
		try {
			EntityManager em = dba.getActiveEm();
			em.merge(hotel);
			em.getTransaction().commit();
			return Constants.RESPONSE_OK;
		} finally {
			dba.closeEm();
		}
	}

	/**
	 * Método para obtener el hotel cuyo id se pasa por parametro
	 * 
	 * @return
	 * @throws HotelException
	 */
	public Hotel listHotel(Long id) throws HotelException {
		Hotel hotel = null;
		Dba dba = new Dba();
		try {
			EntityManager em = dba.getActiveEm();

			hotel = em.find(Hotel.class, id);
			if (hotel == null)
				throw new HotelException("El hotel con id =  " + id + " no existe.", "404");

		} finally {
			dba.closeEm();
		}
		return hotel;
	}

	/**
	 * Método para obtener los hoteles que se pasa por parametro
	 * 
	 * @return
	 */
	public List<Hotel> listHotels() {

		List<Hotel> resultList = null;

		Dba dba = new Dba();
		try {
			EntityManager em = dba.getActiveEm();
			resultList = em.createQuery("select h from hotel h ", Hotel.class).getResultList();
		} finally {
			dba.closeEm();
		}
		return resultList;
	}
}