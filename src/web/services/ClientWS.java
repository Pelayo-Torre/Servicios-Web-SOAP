package web.services;

import java.sql.SQLException;
import java.util.List;

import javax.jws.WebService;

import exception.ClientException;
import model.Client;
import services.ClientService;
import utils.Constants;

@WebService(endpointInterface = "web.services.IPersonWS")
public class ClientWS implements IClientWS {

	private ClientService clientService = new ClientService();

	@Override
	public String addClient(Client client) throws ClientException  {		
		try {
			clientService.add(client);
			return Constants.RESPONSE_OK;
		} catch (SQLException e) {
			return Constants.RESPONSE_KO;
		}
	}

	@Override
	public String deleteClient(Long id) throws ClientException  {
		try {
			clientService.delete(id);
			return Constants.RESPONSE_OK;
		} catch (SQLException e) {
			return Constants.RESPONSE_KO;
		}

	}

	@Override
	public String updateClient(Client client) throws ClientException  {
		try {
			clientService.update(client);
			return Constants.RESPONSE_OK;
		} catch (SQLException e) {
			return Constants.RESPONSE_KO;
		}
	}

	@Override
	public Client getClient(Long id) {
		try {
			return clientService.getClient(id);
		} catch (SQLException e) {
			return null;
		}
	}

	@Override
	public List<Client> listClients() {
		try {
			return clientService.listClients();
		} catch (SQLException e) {
			return null;
		}
	}

}
