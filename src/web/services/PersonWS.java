package web.services;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import exception.PersonException;
import model.Client;
import persistence.ClientDAO;
import utils.Constantes;
import validators.PersonValidator;


@WebService(endpointInterface = "web.services.IPersonWS")
public class PersonWS implements IPersonWS{
	
	private ArrayList<Client> personas = new ArrayList<Client>();
	private PersonValidator personValidator = new PersonValidator();

	@Override
	public String add(Client person) throws PersonException {
		personValidator.validate(person);
		personas.add(person);
		return Constantes.RESPONSE_OK;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String update(Client person) throws PersonException {
		personValidator.validate(person);
		personas.add(person);
		return Constantes.RESPONSE_OK;
	}

	@Override
	public void getPerson(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Client> getList() {
		/*
		 * Client [] array = new Client [personas.size()];
		 * personas.toArray(array); return array;
		 */
		try {
			ClientDAO c = new ClientDAO();
			return c.getClients();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<Client>();
	}

}
