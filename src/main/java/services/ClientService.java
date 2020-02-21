package services;

import java.util.List;

import exception.ClientException;
import exception.HotelException;
import model.Client;
import model.Hotel;
import persistence.ClientDAO;
import persistence.HotelDAO;
import persistence.ManagerDAO;
import validators.ClientValidator;

public class ClientService {

	private ClientDAO dao = ManagerDAO.getInstance().getClientDAO();
	private HotelDAO hotelDao = ManagerDAO.getInstance().getHotelDAO();
	private ClientValidator clientValidator = new ClientValidator();

	/**
	 * M�todo para a�adir un cliente
	 * 
	 * @param client
	 * @return
	 * @throws ClientException
	 * @throws HotelException 
	 */
	public String addClient(Client client, Long hotelId) throws ClientException, HotelException {
		clientValidator.validate(client);
		Client c = dao.findClientByDNI(client.getDni());
		if (c != null)
			throw new ClientException("El cliente con dni =  " + client.getDni() + " ya existe en el sistema", "404");
		
		Hotel h = hotelDao.listHotel(hotelId);
		client.setHotel(h);
		return dao.addClient(client);
	}

	/**
	 * M�todo para borrar un cliente
	 * 
	 * @param id
	 * @return
	 * @throws ClientException
	 */
	public String deleteClient(Long id) throws ClientException {
		return dao.deleteClient(id);
	}

	/**
	 * M�todo para actualizar el cliente que se pasa por par�metro
	 * 
	 * @param client
	 * @return
	 * @throws ClientException
	 */
	public String updateClient(Long id, Client client) throws ClientException {
		clientValidator.validate(client);
		client.setId(id);
		return dao.updateClient(client);
	}

	/**
	 * M�todo para obtener el cliente cuyo id se pasa por par�metro
	 * 
	 * @param id
	 * @return
	 * @throws ClientException
	 */
	public Client listClient(Long id) throws ClientException {
		return dao.listClient(id);
	}

	/**
	 * M�todo para obtener la lista de clientes del hotel que se pasa por parametro
	 * 
	 * @return
	 */
	public List<Client> listClientsOfHotel(Long hotelId) {
		return dao.listClientsOfHotel(hotelId);
	}

}
