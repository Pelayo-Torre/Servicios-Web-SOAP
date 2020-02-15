package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Client;


public class ClientDAO  {

	private Connection con;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	
	public List<Client> getClients() throws Exception {

		List<Client> clients = new ArrayList<Client>();

		try {
			con = Database.getConnection();
			pst = con.prepareStatement("select * from client");
			rs = pst.executeQuery();
			while (rs.next()) {
				Client c = new Client();
				c.setName(rs.getString(1));
				c.setDni(rs.getString(2));
				c.setPhone(rs.getString(3));
				c.setMail(rs.getString(4));
				clients.add(c);
			}
			return clients;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally { 
			rs.close();
			pst.close();
			Database.closeConnection(); 
		}
			 
	}
}