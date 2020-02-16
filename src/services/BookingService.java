package services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exception.ClientException;
import model.Booking;
import model.Client;
import persistence.BookingDAO;
import persistence.ClientDAO;
import persistence.ManagerDAO;
import validators.ClientValidator;

public class BookingService {
	
	private BookingDAO dao;

	/**
	 * Método para añadir una reserva
	 * 
	 * @param booking
	 * @return
	 * @throws SQLException
	 */
	public String addBooking(Booking booking) throws SQLException {
		dao = ManagerDAO.getInstance().getBookingDAO();
		booking.setCancelled(false);
		return dao.addBooking(booking);
	}

}
