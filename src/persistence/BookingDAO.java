package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import model.Booking;
import utils.Constants;

public class BookingDAO {

	private Connection con;
	private PreparedStatement pst = null;
	private ResultSet rs = null;

	/**
	 * Constructor
	 * 
	 * @param con
	 */
	public BookingDAO(Connection con) {
		this.con = con;
	}

	/**
	 * Método para almacenar la reserva que se pasa por parámetro
	 * 
	 * @param client
	 * @throws SQLException
	 */
	public String addBooking(Booking booking) throws SQLException {
		try {
			int id = getMaxId() + 1;
			pst = con.prepareStatement("insert into booking values(?,?,?,?,?,?,?)");
			pst.setInt(1, id);
			pst.setString(2, booking.getCode());
			pst.setString(3, booking.getStartDate());
			pst.setString(4, booking.getEndDate());
			pst.setDouble(5, booking.getPrice());
			pst.setBoolean(6, booking.isCancelled());
			pst.setInt(7, booking.getClientId().intValue());
			int row = pst.executeUpdate();
			return row > 0 ? Constants.RESPONSE_OK : Constants.RESPONSE_KO;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			pst.close();
		}
	}

	/**
	 * Método para obtener el maximo id
	 * 
	 * @return
	 * @throws SQLException
	 */
	private int getMaxId() throws SQLException {
		try {
			pst = con.prepareStatement("select max(id) from booking");
			rs = pst.executeQuery();
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			rs.close();
			pst.close();
		}
	}

	/**
	 * Método para borrar la reserva cuyo id se pasa por parametro
	 * 
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public String deleteBooking(Long id) throws SQLException {

		try {
			pst = con.prepareStatement("update booking set cancelled=? where id=?");
			pst.setBoolean(1, true);
			pst.setLong(2, id);
			int row = pst.executeUpdate();
			return row > 0 ? Constants.RESPONSE_OK : Constants.RESPONSE_KO;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			pst.close();
		}
	}

	/**
	 * Método para actualizar la reserva que se pasa por parámetro
	 * 
	 * @param client
	 * @throws SQLException
	 */
	public String updateBooking(Booking booking) throws SQLException {
		try {
			pst = con.prepareStatement("update booking set code=?, startdate=?, enddate=?, price=? where id=?");
			pst.setString(1, booking.getCode());
			pst.setString(2, booking.getStartDate());
			pst.setString(3, booking.getEndDate());
			pst.setDouble(4, booking.getPrice());
			pst.setInt(5, booking.getId().intValue());
			int row = pst.executeUpdate();
			return row > 0 ? Constants.RESPONSE_OK : Constants.RESPONSE_KO;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			pst.close();
		}
	}

	/**
	 * Método para obtener la reserva cuyo id se pasa por parametro
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ParseException
	 * @throws Exception
	 */
	public Booking listBooking(Long id) throws SQLException, ParseException {

		try {
			pst = con.prepareStatement("select code, startdate, enddate, price from booking where id=?");
			pst.setLong(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				Booking b = new Booking();
				b.setCode(rs.getString(1));
				b.setStartDate(rs.getString(2));
				b.setEndDate(rs.getString(3));
				b.setPrice(rs.getDouble(4));
				return b;
			}
			return null;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			rs.close();
			pst.close();
		}
	}

	/**
	 * Método para comprobar si existe la reserva cuyo codigo se pasa por parametro
	 * 
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public boolean existsBooking(String code) throws SQLException {

		try {
			pst = con.prepareStatement("select * from booking where code=?");
			pst.setString(1, code);
			rs = pst.executeQuery();
			if (rs.next())
				return true;
			return false;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			rs.close();
			pst.close();
		}
	}

	/**
	 * Método para obtener las reservas de un cliente
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ParseException
	 * @throws Exception
	 */
	public List<Booking> listBookings(Long clientId) throws SQLException, ParseException {

		List<Booking> bookings = new ArrayList<Booking>();

		try {
			pst = con.prepareStatement("select code, startdate, enddate, price from booking where clientId=?");
			pst.setLong(1, clientId);
			rs = pst.executeQuery();
			while (rs.next()) {
				Booking b = new Booking();
				b.setCode(rs.getString(1));
				b.setStartDate(rs.getString(2));
				b.setEndDate(rs.getString(3));
				b.setPrice(rs.getDouble(4));
				bookings.add(b);
			}
			return bookings;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			rs.close();
			pst.close();
		}
	}
}