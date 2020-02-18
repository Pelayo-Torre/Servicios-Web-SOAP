package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Hotel;
import model.Location;
import utils.Constants;

public class HotelDAO {

	private Connection con;
	private PreparedStatement pst = null;
	private ResultSet rs = null;

	/**
	 * Constructor
	 * 
	 * @param con
	 */
	public HotelDAO(Connection con) {
		this.con = con;
	}

	/**
	 * Método para almacenar el hotel que se pasa por parámetro
	 * 
	 * @param hotel
	 * @throws SQLException
	 */
	public String addHotel(Hotel hotel) throws SQLException {
		try {
			int id = getMaxId() + 1;
			pst = con.prepareStatement("insert into hotel values(?,?,?,?,?,?,?,?)");
			pst.setInt(1, id);
			pst.setString(2, hotel.getName());
			pst.setDouble(3, hotel.getLocation().getLatitude());
			pst.setDouble(4, hotel.getLocation().getLongitude());
			pst.setString(5, hotel.getCountry());
			pst.setInt(6, hotel.getStars());
			pst.setString(7, hotel.getTelephone());
			pst.setString(8, hotel.getAddress());
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
			pst = con.prepareStatement("select max(id) from hotel");
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
	 * Método para borrar el hotel cuyo id se pasa por parametro
	 * 
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public String deleteHotel(Long id) throws SQLException {

		try {
			// TODO modificar
			pst = con.prepareStatement("update hotel set active=? where id=?");
			pst.setBoolean(1, false);
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
	 * Método para actualizar el hotel que se pasa por parámetro
	 * 
	 * @param hotel
	 * @throws SQLException
	 */
	public String updateHotel(Hotel hotel) throws SQLException {
		try {
			pst = con.prepareStatement(
					"update hotel set name=?, latitude=?, longitude=?, country=?, stars=?, telephone=?, address=? where id=?");
			pst.setString(1, hotel.getName());
			pst.setDouble(2, hotel.getLocation().getLatitude());
			pst.setDouble(3, hotel.getLocation().getLongitude());
			pst.setString(4, hotel.getCountry());
			pst.setInt(5, hotel.getStars());
			pst.setString(6, hotel.getTelephone());
			pst.setString(7, hotel.getAddress());
			pst.setInt(8, hotel.getId().intValue());
			int row = pst.executeUpdate();
			return row > 0 ? Constants.RESPONSE_OK : Constants.RESPONSE_KO;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			pst.close();
		}
	}

	/**
	 * Método para obtener el hotel cuyo id se pasa por parametro
	 * 
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public Hotel listHotel(Long id) throws SQLException {

		try {
			pst = con.prepareStatement(
					"select name, latitude, longitude, country, stars, telephone, address from hotel where id=?");
			pst.setLong(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				Hotel h = new Hotel();
				h.setName(rs.getString(1));
				h.setLocation(new Location(rs.getDouble(2), rs.getDouble(3)));
				h.setCountry(rs.getString(4));
				h.setStars(rs.getInt(5));
				h.setTelephone(rs.getString(6));
				h.setAddress(rs.getString(7));
				return h;
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
	 * Método para obtener los hoteles que se pasa por parametro
	 * 
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public List<Hotel> listHotels() throws SQLException {

		List<Hotel> hotels = new ArrayList<Hotel>();

		try {
			pst = con.prepareStatement(
					"select name, latitude, longitude, country, stars, telephone, address from hotel");
			rs = pst.executeQuery();
			while (rs.next()) {
				Hotel h = new Hotel();
				h.setName(rs.getString(1));
				h.setLocation(new Location(rs.getDouble(2), rs.getDouble(3)));
				h.setCountry(rs.getString(4));
				h.setStars(rs.getInt(5));
				h.setTelephone(rs.getString(6));
				h.setAddress(rs.getString(7));
				hotels.add(h);
			}
			return hotels;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			rs.close();
			pst.close();
		}
	}
}