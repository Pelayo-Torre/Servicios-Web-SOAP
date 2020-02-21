package persistence;

import java.util.List;

import javax.persistence.EntityManager;

import exception.RoomException;
import model.Room;
import utils.Constants;

public class RoomDAO {

	/**
	 * Constructor
	 */
	public RoomDAO() {
	}

	/**
	 * M�todo para almacenar la habitaci�n que se pasa por par�metro
	 * 
	 * @param room
	 */
	public String addRoom(Room room) {
		Dba dba = new Dba();
		try {
			EntityManager em = dba.getActiveEm();
			em.persist(room);
			em.getTransaction().commit();
			return Constants.RESPONSE_OK;
		} finally {
			dba.closeEm();
		}
	}

	/**
	 * M�todo para borrar la habitaci�n cuyo id se pasa por parametro
	 * 
	 * @return
	 * @throws RoomException
	 */
	public String deleteRoom(Long id) throws RoomException {

		Dba dba = new Dba();
		try {
			EntityManager em = dba.getActiveEm();

			Room room = em.find(Room.class, id);
			if (room == null)
				throw new RoomException("La habitaci�n con id =  " + id + " no existe.", "404");

			em.getTransaction().begin();
			em.remove(room);
			em.getTransaction().commit();
			return Constants.RESPONSE_OK;
		} finally {
			dba.closeEm();
		}
	}

	/**
	 * M�todo para actualizar la habitacion que se pasa por par�metro
	 * 
	 * @param room
	 */
	public String updateRoom(Room room) {
		Dba dba = new Dba();
		try {
			EntityManager em = dba.getActiveEm();
			em.merge(room);
			em.getTransaction().commit();
			return Constants.RESPONSE_OK;
		} finally {
			dba.closeEm();
		}
	}

	/**
	 * M�todo para obtener la habitaci�n cuyo id se pasa por parametro
	 * 
	 * @return
	 * @throws RoomException
	 */
	public Room listRoom(Long id) throws RoomException {

		Room room = null;
		Dba dba = new Dba();
		try {
			EntityManager em = dba.getActiveEm();

			room = em.find(Room.class, id);
			if (room == null)
				throw new RoomException("La habitaci�n con id =  " + id + " no existe.", "404");

		} finally {
			dba.closeEm();
		}
		return room;
	}

	/**
	 * M�todo para comprobar si existe la habitaci�n cuyo codigo se pasa por
	 * parametro
	 * 
	 * @return
	 */
	public Room findRoomByCode(String code) {

		Room resultList = null;

		Dba dba = new Dba();
		try {
			EntityManager em = dba.getActiveEm();
			resultList = em.createQuery("Select r From room r Where r.code = :code", Room.class)
					.setParameter("code", code).getSingleResult();
		} finally {
			dba.closeEm();
		}
		return resultList;
	}

	/**
	 * M�todo para obtener las habitaciones del hotel que se pasa por parametro
	 * 
	 * @return
	 */
	public List<Room> listRoomsOfHotel(Long hotelId) {

		List<Room> resultList = null;

		Dba dba = new Dba();
		try {
			EntityManager em = dba.getActiveEm();
			resultList = em.createQuery("select r from room r where r.hotelId = :hotelId", Room.class)
					.setParameter("hotelId", hotelId).getResultList();
		} finally {
			dba.closeEm();
		}
		return resultList;
	}

	/**
	 * M�todo para obtener las habitaciones de la reserva que se pasa por parametro
	 * 
	 * @return
	 */
	public List<Room> listRoomsOfBooking(Long bookingId) {

		List<Room> resultList = null;

		Dba dba = new Dba();
		try {
			EntityManager em = dba.getActiveEm();
			// TODO review, change, intermediate table is necessary
			resultList = em.createQuery("select r from room r where r.hotelId = :hotelId", Room.class)
					.setParameter("hotelId", bookingId).getResultList();
		} finally {
			dba.closeEm();
		}
		return resultList;
	}

}