package services;

import java.sql.SQLException;
import java.util.List;

import exception.ClientException;
import model.Client;
import persistence.ClientDAO;
import persistence.ManagerDAO;
import validators.ClientValidator;

public class ClientService {

	private ClientDAO dao = ManagerDAO.getInstance().getClientDAO();
	private ClientValidator clientValidator = new ClientValidator();

	/**
	 * Método para añadir un cliente
	 * 
	 * @param client
	 * @return
	 * @throws SQLException
	 * @throws ClientException
	 */
	public String addClient(Client client) throws SQLException, ClientException {
		clientValidator.validate(client);
		if (dao.existsClient(client.getDni()))
			throw new ClientException("El cliente que se añadir ya existe en el sistema", "404");
		client.setActive(true);
		return dao.addClient(client);
	}

	/**
	 * Método para borrar un cliente
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 * @throws ClientException
	 */
	public String deleteClient(Long id) throws SQLException, ClientException {
		Client c = dao.listClient(id);
		if (c == null)
			throw new ClientException("El cliente que se desea eliminar no existe", "404");

		return dao.deleteClient(id);
	}

	/**
	 * Método para actualizar el cliente que se pasa por parámetro
	 * 
	 * @param client
	 * @return
	 * @throws SQLException
	 * @throws ClientException
	 */
	public String updateClient(Long id, Client client) throws SQLException, ClientException {
		clientValidator.validate(client);
		Client c = dao.listClient(id);
		if (c == null)
			throw new ClientException("El cliente que se desea eliminar no existe", "404");
		client.setId(id);
		return dao.updateClient(client);
	}

	/**
	 * Método para obtener el cliente cuyo id se pasa por parámetro
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Client listClient(Long id) throws SQLException {
		return dao.listClient(id);
	}

	/**
	 * Método para obtener la lista de clientes del hotel que se pasa por parametro
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Client> listClientsOfHotel(Long hotelId) throws SQLException {
		return dao.listClients(hotelId);
	}

}
