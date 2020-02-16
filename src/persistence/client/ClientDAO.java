package persistence.client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Client;

public class ClientDAO {

	private Connection con;
	private PreparedStatement pst = null;
	private ResultSet rs = null;

	/**
	 * Constructor
	 * 
	 * @param con
	 */
	public ClientDAO(Connection con) {
		this.con = con;
	}

	/**
	 * M�todo para almacenar el cliente que se pasa por par�metro
	 * 
	 * @param client
	 * @throws SQLException
	 */
	public void addClient(Client client) throws SQLException {
		try {
			pst = con.prepareStatement("insert into client values(?,?,?,?,?)");
			pst.setString(1, client.getName());
			pst.setString(2, client.getDni());
			pst.setString(3, client.getTelephone());
			pst.setString(4, client.getEmail());
			pst.setBoolean(5, client.isActive());
			pst.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			pst.close();
		}
	}
	
	/**
	 * M�todo para borrar el cliente cuyo id se pasa por parametro
	 * 
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public void deleteClient(Long id) throws SQLException {

		try {
			pst = con.prepareStatement("delete from client where id=?");
			pst.setLong(1, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			pst.close();
		}
	}

	/**
	 * M�todo para actualizar el cliente que se pasa por par�metro
	 * 
	 * @param client
	 * @throws SQLException
	 */
	public void updateClient(Client client) throws SQLException {
		try {
			pst = con.prepareStatement("update client set name=?, dni=?, telephone=?, email=? where id=?");
			pst.setString(1, client.getName());
			pst.setString(2, client.getDni());
			pst.setString(3, client.getTelephone());
			pst.setString(4, client.getEmail());
			pst.setInt(5, client.getId().intValue());
			pst.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			pst.close();
		}
	}

	/**
	 * M�todo para obtener el cliente cuyo id se pasa por parametro
	 * 
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public Client getClient(Long id) throws SQLException {

		try {
			pst = con.prepareStatement("select * from client where id=?");
			pst.setLong(1, id);
			rs = pst.executeQuery();
			rs.next();
			Client c = new Client();
			c.setName(rs.getString(1));
			c.setDni(rs.getString(2));
			c.setTelephone(rs.getString(3));
			c.setEmail(rs.getString(4));
			return c;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			rs.close();
			pst.close();
		}
	}

	/**
	 * M�todo para obtener los clientes
	 * 
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public List<Client> getClients() throws SQLException {

		List<Client> clients = new ArrayList<Client>();

		try {
			pst = con.prepareStatement("select * from client");
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