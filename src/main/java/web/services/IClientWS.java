package web.services;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import exception.ClientException;
import exception.HotelException;
import model.dtos.ClientAddDTO;
import model.dtos.ClientDTO;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface IClientWS {

	@WebMethod
	public String addClient(ClientAddDTO client) throws ClientException, HotelException;

	@WebMethod
	public String deleteClient(Long id) throws ClientException;

	@WebMethod
	public String updateClient(ClientDTO client) throws ClientException;

	@WebMethod
	public ClientDTO listClient(Long id) throws ClientException;

	@WebMethod
	public List<ClientDTO> listClientsOfHotel(Long hotelId) throws HotelException;

}
