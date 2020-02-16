package web.services;

import java.util.List;

import javax.jws.WebService;

import model.Client;
import persistence.ManagerDAO;
import persistence.client.ClientDAO;
import validators.ClientValidator;

@WebService(endpointInterface = "web.services.IClientWS")
public class ClientWS implements IClientWS {

	private ClientValidator clientValidator = new ClientValidator();

	@Override
	public String addClient(Client client) throws Exception {
		clientValidator.validate(client);
		try {
			ClientDAO c = ManagerDAO.getInstance().getClientDAO();
			client.setActive(true);
			return c.addClient(client);
		} catch (Exception e) {
			throw new Exception();
		}
	}

	@Override
	public String deleteClient(Long id) throws Exception {
		try {
			ClientDAO c = ManagerDAO.getInstance().getClientDAO();
			return c.deleteClient(id);
		} catch (Exception e) {
			throw new Exception();
		}

	}

	@Override
	public String updateClient(Long id, Client client) throws Exception {
		clientValidator.validate(client);
		try {
			ClientDAO c = ManagerDAO.getInstance().getClientDAO();
			client.setId(id);
			return c.updateClient(client);
		} catch (Exception e) {
			throw new Exception();
		}
	}

	@Override
	public Client listClient(Long id) throws Exception {
		try {
			ClientDAO c = ManagerDAO.getInstance().getClientDAO();
			return c.getClient(id);
		} catch (Exception e) {
			throw new Exception();
		}
	}

	@Override
	public List<Client> listClients() throws Exception {
		try {
			ClientDAO c = ManagerDAO.getInstance().getClientDAO();
			return c.getClients();
		} catch (Exception e) {
			throw new Exception();
		}
	}

}
