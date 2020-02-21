package web.services;

import java.util.List;

import javax.jws.WebService;

import exception.ClientException;
import exception.HotelException;
import model.Client;
import services.ClientService;

@WebService(endpointInterface = "web.services.IClientWS")
public class ClientWS implements IClientWS {

	private ClientService clientService = new ClientService();

	@Override
	public String addClient(Client client, Long hotelId) throws ClientException, HotelException {
		return clientService.addClient(client, hotelId);
	}

	@Override
	public String deleteClient(Long id) throws ClientException {
		return clientService.deleteClient(id);
	}

	@Override
	public String updateClient(Long id, Client client) throws ClientException {
		return clientService.updateClient(id, client);
	}

	@Override
	public Client listClient(Long id) throws ClientException {
		return clientService.listClient(id);
	}

	@Override
	public List<Client> listClientsOfHotel(Long hotelId) {
		return clientService.listClientsOfHotel(hotelId);
	}

}
