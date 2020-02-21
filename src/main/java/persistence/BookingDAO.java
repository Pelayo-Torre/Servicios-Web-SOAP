package persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import exception.BookingException;
import model.Booking;
import utils.Constants;

public class BookingDAO {

	/**
	 * Constructor
	 */
	public BookingDAO() {
	}

	/**
	 * Método para almacenar la reserva que se pasa por parámetro
	 * 
	 * @param booking
	 */
	public String addBooking(Booking booking) {
		Dba dba = new Dba();
		try {
			EntityManager em = dba.getActiveEm();
			em.persist(booking);
			em.getTransaction().commit();
			return Constants.RESPONSE_OK;
		} finally {
			dba.closeEm();
		}
	}

	/**
	 * Método para borrar la reserva cuyo id se pasa por parametro
	 * 
	 * @return
	 * @throws BookingException
	 */
	public String deleteBooking(Long id) throws BookingException {

		Dba dba = new Dba();
		try {
			EntityManager em = dba.getActiveEm();

			Booking booking = em.find(Booking.class, id);
			if (booking == null)
				throw new BookingException("La reserva con id =  " + id + " no existe.", "404");

			em.remove(booking);
			em.getTransaction().commit();
			return Constants.RESPONSE_OK;
		} finally {
			dba.closeEm();
		}
	}

	/**
	 * Método para actualizar la reserva que se pasa por parámetro
	 * 
	 * @param client
	 */
	public String updateBooking(Booking booking) {
		Dba dba = new Dba();
		try {
			EntityManager em = dba.getActiveEm();
			em.merge(booking);
			em.getTransaction().commit();
			return Constants.RESPONSE_OK;
		} finally {
			dba.closeEm();
		}
	}

	/**
	 * Método para obtener la reserva cuyo id se pasa por parametro
	 * 
	 * @return
	 * @throws BookingException
	 */
	public Booking listBooking(Long id) throws BookingException {

		Booking booking = null;
		Dba dba = new Dba();
		try {
			EntityManager em = dba.getActiveEm();

			booking = em.find(Booking.class, id);
			if (booking == null)
				throw new BookingException("La reserva con id =  " + id + " no existe.", "404");

		} finally {
			dba.closeEm();
		}
		return booking;
	}

	/**
	 * Método para comprobar si existe la reserva cuyo codigo se pasa por parametro
	 * 
	 * @return
	 */
	public Booking findBookingByCode(String code) {

		Booking resultList = null;

		Dba dba = new Dba();
		try {
			EntityManager em = dba.getActiveEm();
			resultList = em.createQuery("Select b From Booking b Where b.code = :code", Booking.class)
					.setParameter("code", code).getSingleResult();
		} 
		catch (NoResultException e) {
			return null;
		} 
		finally {
			dba.closeEm();
		}
		return resultList;
	}

	/**
	 * Método para obtener las reservas de un cliente
	 * 
	 * @return
	 */
	public List<Booking> listBookingsOfClient(Long clientId) {

		List<Booking> resultList = null;

		Dba dba = new Dba();
		try {
			EntityManager em = dba.getActiveEm();
			resultList = em.createQuery("select b from Booking b where b.client.id = :clientId", Booking.class)
					.setParameter("clientId", clientId).getResultList();
		} finally {
			dba.closeEm();
		}
		return resultList;
	}

}