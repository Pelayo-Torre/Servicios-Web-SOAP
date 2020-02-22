package services;

import java.util.List;

import exception.ClientException;
import exception.HotelException;
import model.Client;
import model.Hotel;
import persistence.ClientDAO;
import persistence.HotelDAO;
import persistence.ManagerDAO;
import utils.Constants;
import validators.ClientValidator;

public class ClientService {

	private ClientDAO dao = ManagerDAO.getInstance().getClientDAO();
	private HotelDAO hotelDao = ManagerDAO.getInstance().getHotelDAO();
	private ClientValidator clientValidator = new ClientValidator();

	/**
	 * Método para añadir un cliente
	 * 
	 * @param client
	 * @return
	 * @throws ClientException
	 * @throws HotelException 
	 */
	public String addClient(Client client, Long hotelId) throws ClientException, HotelException {
		clientValidator.validate(client);
		
		if(hotelId == null)
			throw new HotelException("El Idenificador del hotel es obligatorio", "404");
		
		Client c = dao.findClientByDNI(client.getDni());
		if (c != null)
			throw new ClientException("El cliente con dni =  " + client.getDni() + " ya existe en el sistema", "404");
		
		Hotel h = hotelDao.listHotel(hotelId);
		
		if(h == null)
			throw new HotelException("El hotel con ID = " + hotelId + " no existe en el sistema", "404");
		
		client.setHotel(h);
		client.setActive(Constants.ACTIVE);
		return dao.addClient(client);
	}

	/**
	 * Método para borrar un cliente
	 * 
	 * @param id
	 * @return
	 * @throws ClientException
	 */
	public String deleteClient(Long id) throws ClientException {
		Client client = dao.listClient(id);
		
		if(client == null)
			throw new ClientException("El client con ID " + id + " no existe en el sistema", "404");
		
		client.setActive(Constants.INACTIVE);
		return updateClient(client);
	}

	/**
	 * Método para actualizar el cliente que se pasa por parámetro
	 * 
	 * @param client
	 * @return
	 * @throws ClientException
	 */
	public String updateClient(Client client) throws ClientException {
		clientValidator.validate(client);
		
		if(client.getActive() == null)
			client.setActive(Constants.ACTIVE);
		else if(client.getActive() != 0 && client.getActive() != 1)
			throw new ClientException("El campo activo del cliente es inválido", "404");
		
		if(dao.listClient(client.getId()) == null)
			throw new ClientException("El client con ID " + client.getId() + " no se encuentra registrado en el sistema", "404");
		
		Hotel hotel = hotelDao.getHotelOfClient(client.getId());
		client.setHotel(hotel);
		
		return dao.updateClient(client);
	}

	/**
	 * Método para obtener el cliente cuyo id se pasa por parámetro
	 * 
	 * @param id
	 * @return
	 * @throws ClientException
	 */
	public Client listClient(Long id) throws ClientException {
		Client client = dao.listClient(id);
		
		if(client == null)
			throw new ClientException("El cliente con ID " + id + " no existe en el sistema", "404");
		
		return client;
	}

	/**
	 * Método para obtener la lista de clientes del hotel que se pasa por parametro
	 * 
	 * @return
	 * @throws HotelException 
	 */
	public List<Client> listClientsOfHotel(Long hotelId) throws HotelException {
		if(hotelDao.listHotel(hotelId) == null)
			throw new HotelException("El hotel con ID " + hotelId + " no está registrado en el sistema", "404");
		return dao.listClientsOfHotel(hotelId);
	}

}
