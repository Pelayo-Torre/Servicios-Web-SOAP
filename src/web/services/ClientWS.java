package web.services;

import java.sql.SQLException;
import java.util.List;

import javax.jws.WebService;

import exception.ClientException;
import model.Client;
import services.ClientService;

@WebService(endpointInterface = "web.services.IClientWS")
public class ClientWS implements IClientWS {

	private ClientService clientService = new ClientService();

	@Override
	public String addClient(Client client) throws ClientException, SQLException {
		return clientService.addClient(client);
	}

	@Override
	public String deleteClient(Long id) throws ClientException, SQLException {
		return clientService.deleteClient(id);
	}

	@Override
	public String updateClient(Long id, Client client) throws ClientException, SQLException {
		return clientService.updateClient(id, client);
	}

	@Override
	public Client listClient(Long id) throws SQLException {
		return clientService.listClient(id);
	}

	@Override
	public List<Client> listClientsOfHotel(Long hotelId) throws SQLException {
		return clientService.listClientsOfHotel(hotelId);
	}

}
