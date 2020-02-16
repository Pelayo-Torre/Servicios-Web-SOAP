package web.services;

import java.util.List;

import javax.jws.WebService;

import exception.ClientException;
import model.Client;
import persistence.ManagerDAO;
import persistence.client.ClientDAO;
import utils.Constants;
import validators.ClientValidator;

@WebService(endpointInterface = "web.services.IClientWS")
public class ClientWS implements IClientWS {

	private ClientValidator clientValidator = new ClientValidator();

	@Override
	public String addClient(Client client) throws ClientException {
		clientValidator.validate(client);
		try {
			ClientDAO c = ManagerDAO.getInstance().getClientDAO();
			client.setActive(true);
			c.addClient(client);
			return Constants.RESPONSE_OK;
		} catch (Exception e) {
			e.printStackTrace();
			//throw new Exception();
		}
		return "";
	}

	@Override
	public void deleteClient(Long id) throws Exception {
		try {
			ClientDAO c = ManagerDAO.getInstance().getClientDAO();
			c.deleteClient(id);
		} catch (Exception e) {
			throw new Exception();
		}

	}

	@Override
	public String updateClient(Client client) throws Exception {
		clientValidator.validate(client);
		try {
			ClientDAO c = ManagerDAO.getInstance().getClientDAO();
			Client cli = c.getClient(client.getId());
			if (cli != null) {
				c.deleteClient(cli.getId());
			}
			return Constants.RESPONSE_OK;
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
