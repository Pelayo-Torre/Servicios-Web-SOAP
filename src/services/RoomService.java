package services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exception.ClientException;
import exception.RoomException;
import model.Client;
import model.Room;
import persistence.ClientDAO;
import persistence.ManagerDAO;
import persistence.RoomDAO;
import validators.ClientValidator;
import validators.RoomValidator;

public class RoomService {

	private RoomDAO dao;
	private RoomValidator roomValidator = new RoomValidator();

	/**
	 * M�todo para a�adir una habitacion
	 * 
	 * @param client
	 * @return
	 * @throws SQLException
	 * @throws RoomException 
	 * @throws ClientException
	 */
	public String addRoom(Room room) throws SQLException, RoomException {
		roomValidator.validate(room);
		dao = ManagerDAO.getInstance().getRoomDAO();
		return dao.addRoom(room);
	}

	/**
	 * M�todo para borrar un cliente
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 * @throws ClientException
	 */
	public String deleteClient(Long id) throws SQLException, ClientException {
		dao = ManagerDAO.getInstance().getClientDAO();

		Client c = dao.listClient(id);
		if (c == null)
			throw new ClientException("El cliente que se desea eliminar no existe", "404");

		return dao.deleteClient(id);
	}

	/**
	 * M�todo para actualizar el cliente que se pasa por par�metro
	 * 
	 * @param client
	 * @return
	 * @throws SQLException
	 * @throws ClientException
	 */
	public String updateClient(Long id, Client client) throws SQLException, ClientException {
		roomValidator.validate(client);
		dao = ManagerDAO.getInstance().getClientDAO();
		Client c = dao.listClient(id);
		if (c == null)
			throw new ClientException("El cliente que se desea eliminar no existe", "404");
		client.setId(id);
		return dao.updateClient(client);
	}

	/**
	 * M�todo para obtener el cliente cuyo id se pasa por par�metro
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Client listClient(Long id) throws SQLException {
		dao = ManagerDAO.getInstance().getClientDAO();
		return dao.listClient(id);
	}

	/**
	 * M�todo para obtener la lista de clientes
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Client> listClients() throws SQLException {
		dao = ManagerDAO.getInstance().getClientDAO();
		return dao.listClients();
	}

	
}
