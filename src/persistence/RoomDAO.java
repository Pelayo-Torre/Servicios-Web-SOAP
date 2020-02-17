package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Client;
import model.Room;
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
			pst = con.prepareStatement("insert into room values(?,?,?,?)");
			pst.setInt(1, id);
			pst.setString(2, room.getCode());
			pst.setDouble(3, room.getPrice());
			pst.setString(4, room.getRoomType().name());
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
	 * Método para borrar el cliente cuyo id se pasa por parametro
	 * 
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public String deleteClient(Long id) throws SQLException {

		try {
			pst = con.prepareStatement("update client set active=? where id=?");
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
	 * Método para actualizar el cliente que se pasa por parámetro
	 * 
	 * @param client
	 * @throws SQLException
	 */
	public String updateClient(Client client) throws SQLException {
		try {
			pst = con.prepareStatement("update client set name=?, dni=?, telephone=?, email=? where id=?");
			pst.setString(1, client.getName());
			pst.setString(2, client.getDni());
			pst.setString(3, client.getTelephone());
			pst.setString(4, client.getEmail());
			pst.setInt(5, client.getId().intValue());
			int row = pst.executeUpdate();
			return row > 0 ? Constants.RESPONSE_OK : Constants.RESPONSE_KO;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			pst.close();
		}
	}

	/**
	 * Método para obtener el cliente cuyo id se pasa por parametro
	 * 
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public Client listClient(Long id) throws SQLException {

		try {
			pst = con.prepareStatement("select name, dni, telephone, email from client where id=?");
			pst.setLong(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				Client c = new Client();
				c.setName(rs.getString(1));
				c.setDni(rs.getString(2));
				c.setTelephone(rs.getString(3));
				c.setEmail(rs.getString(4));
				return c;
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
	 * Método para obtener los clientes
	 * 
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public List<Client> listClients() throws SQLException {

		List<Client> clients = new ArrayList<Client>();

		try {
			pst = con.prepareStatement("select name, dni, telephone, email from client");
			rs = pst.executeQuery();
			while (rs.next()) {
				Client c = new Client();
				c.setName(rs.getString(1));
				c.setDni(rs.getString(2));
				c.setTelephone(rs.getString(3));
				c.setEmail(rs.getString(4));
				clients.add(c);
			}
			return clients;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			rs.close();
			pst.close();
		}
	}
}