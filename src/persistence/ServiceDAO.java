package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Service;
import utils.Constants;

public class ServiceDAO {

	private Connection con;
	private PreparedStatement pst = null;
	private ResultSet rs = null;

	/**
	 * Constructor
	 * 
	 * @param con
	 */
	public ServiceDAO(Connection con) {
		this.con = con;
	}

	/**
	 * Método para almacenar el servicio que se pasa por parámetro
	 * 
	 * @param service
	 * @throws SQLException
	 */
	public String addService(Service service) throws SQLException {
		try {
			int id = getMaxId() + 1;
			pst = con.prepareStatement("insert into service values(?,?,?,?,?)");
			pst.setInt(1, id);
			pst.setString(2, service.getName());
			pst.setString(3, service.getCode());
			pst.setDouble(4, service.getPrice());
			pst.setInt(5, service.getHotelId().intValue());
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
			pst = con.prepareStatement("select max(id) from service");
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
	 * Método para borrar el servicio cuyo id se pasa por parametro
	 * 
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public String deleteService(Long id) throws SQLException {

		try {
			pst = con.prepareStatement("delete from service where id=?");
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
	 * Método para actualizar el servicio que se pasa por parámetro
	 * 
	 * @param service
	 * @throws SQLException
	 */
	public String updateService(Service service) throws SQLException {
		try {
			pst = con.prepareStatement("update service set name=?, code=?, price=? where id=?");
			pst.setString(1, service.getName());
			pst.setString(2, service.getCode());
			pst.setDouble(3, service.getPrice());
			pst.setInt(4, service.getId().intValue());
			int row = pst.executeUpdate();
			return row > 0 ? Constants.RESPONSE_OK : Constants.RESPONSE_KO;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			pst.close();
		}
	}

	/**
	 * Método para obtener el servicio cuyo id se pasa por parametro
	 * 
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public Service listService(Long id) throws SQLException {

		try {
			pst = con.prepareStatement("select name, code, price from service where id=?");
			pst.setLong(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				Service s = new Service();
				s.setName(rs.getString(1));
				s.setCode(rs.getString(2));
				s.setPrice(rs.getDouble(3));
				return s;
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
	 * Método para obtener los servicios del hotel que se pasa por parametro
	 * 
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public List<Service> listServicesOfHotel(Long hotelId) throws SQLException {

		List<Service> services = new ArrayList<Service>();

		try {
			pst = con.prepareStatement("select name, code, price from service where hotelId=?");
			pst.setLong(1, hotelId);
			rs = pst.executeQuery();
			while (rs.next()) {
				Service s = new Service();
				s.setName(rs.getString(1));
				s.setCode(rs.getString(2));
				s.setPrice(rs.getDouble(3));
				services.add(s);
			}
			return services;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			rs.close();
			pst.close();
		}
	}

}