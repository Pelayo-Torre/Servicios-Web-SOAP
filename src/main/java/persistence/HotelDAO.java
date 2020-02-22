package persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

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
			
		} catch (NoResultException e) {
			return null;
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
			resultList = em.createQuery("select h from Hotel h ", Hotel.class).getResultList();
		} finally {
			dba.closeEm();
		}
		return resultList;
	}
	
	public Hotel getHotelOfClient(Long idClient) {

		Hotel hotel = null;
		Long id = null;

		Dba dba = new Dba();
		try {
			EntityManager em = dba.getActiveEm();
			id = em.createQuery("select c.hotel.id from Client c where c.id = :clientId", Long.class)
					.setParameter("clientId", idClient).getSingleResult();
			
			hotel = em.find(Hotel.class, id);
			
		} finally {
			dba.closeEm();
		}
		return hotel;
	}
	
	public Hotel getHotelOfService(Long idService) {

		Hotel hotel = null;
		Long id = null;

		Dba dba = new Dba();
		try {
			EntityManager em = dba.getActiveEm();
			id = em.createQuery("select s.hotel.id from Service s where s.id = :idService", Long.class)
					.setParameter("idService", idService).getSingleResult();
			
			hotel = em.find(Hotel.class, id);
			
		} finally {
			dba.closeEm();
		}
		return hotel;
	}
	
	public Hotel getHotelOfRoom(Long idRoom) {

		Hotel hotel = null;
		Long id = null;

		Dba dba = new Dba();
		try {
			EntityManager em = dba.getActiveEm();
			id = em.createQuery("select r.hotel.id from Room r where r.id = :idRoom", Long.class)
					.setParameter("idService", idRoom).getSingleResult();
			
			hotel = em.find(Hotel.class, id);
			
		} finally {
			dba.closeEm();
		}
		return hotel;
	}
}