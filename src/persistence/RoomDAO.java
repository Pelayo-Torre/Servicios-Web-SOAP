package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Room;
import model.RoomType;
import utils.Constants;

public class RoomDAO {

	private Connection con;
	private PreparedStatement pst = null;
	private ResultSet rs = null;

	/**
	 * Constructor
	 * 
	 * @param con
	 */
	public RoomDAO(Connection con) {
		this.con = con;
	}

	/**
	 * Método para almacenar la habitación que se pasa por parámetro
	 * 
	 * @param room
	 * @throws SQLException
	 */
	public String addRoom(Room room) throws SQLException {
		try {
			int id = getMaxId() + 1;
			pst = con.prepareStatement("insert into room values(?,?,?,?,?)");
			pst.setInt(1, id);
			pst.setString(2, room.getCode());
			pst.setDouble(3, room.getPrice());
			pst.setString(4, room.getRoomType().name());
			pst.setInt(5, room.getHotelId().intValue());
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
			pst = con.prepareStatement("select max(id) from room");
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
	 * Método para borrar la habitación cuyo id se pasa por parametro
	 * 
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public String deleteRoom(Long id) throws SQLException {

		try {
			pst = con.prepareStatement("delete from room where id=?");
			pst.setBoolean(1, false);
			pst.setLong(1, id);
			int row = pst.executeUpdate();
			return row > 0 ? Constants.RESPONSE_OK : Constants.RESPONSE_KO;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			pst.close();
		}
	}

	/**
	 * Método para actualizar la habitacion que se pasa por parámetro
	 * 
	 * @param room
	 * @throws SQLException
	 */
	public String updateRoom(Room room) throws SQLException {
		try {
			pst = con.prepareStatement("update room set code=?, price=?, type=? where id=?");
			pst.setString(1, room.getCode());
			pst.setDouble(2, room.getPrice());
			pst.setString(3, room.getRoomType().name());
			pst.setInt(4, room.getId().intValue());
			int row = pst.executeUpdate();
			return row > 0 ? Constants.RESPONSE_OK : Constants.RESPONSE_KO;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			pst.close();
		}
	}

	/**
	 * Método para obtener la habitación cuyo id se pasa por parametro
	 * 
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public Room listRoom(Long id) throws SQLException {

		try {
			pst = con.prepareStatement("select code, price, type from room where id=?");
			pst.setLong(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				Room r = new Room();
				r.setCode(rs.getString(1));
				r.setPrice(rs.getDouble(2));
				r.setRoomType(RoomType.valueOf(rs.getString(3)));
				return r;
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
	 * Método para obtener las habitaciones del hotel que se pasa por parametro
	 * 
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public List<Room> listRoomsOfHotel(Long hotelId) throws SQLException {

		List<Room> rooms = new ArrayList<Room>();

		try {
			pst = con.prepareStatement("code, price, type from room where hotelId=?");
			pst.setLong(1, hotelId);
			rs = pst.executeQuery();
			while (rs.next()) {
				Room r = new Room();
				r.setCode(rs.getString(1));
				r.setPrice(rs.getDouble(2));
				r.setRoomType(RoomType.valueOf(rs.getString(3)));
				rooms.add(r);
			}
			return rooms;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			rs.close();
			pst.close();
		}
	}

}