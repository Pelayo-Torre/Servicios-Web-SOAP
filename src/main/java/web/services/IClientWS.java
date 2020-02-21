package web.services;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import exception.ClientException;
import model.Client;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface IClientWS {

	@WebMethod
	public String addClient(Client client) throws ClientException;

	@WebMethod
	public String deleteClient(Long id) throws ClientException;

	@WebMethod
	public String updateClient(Long id, Client client) throws ClientException;

	@WebMethod
	public Client listClient(Long id) throws ClientException;

	@WebMethod
	public List<Client> listClientsOfHotel(Long hotelId);

}
