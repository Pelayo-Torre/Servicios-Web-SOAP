package web.services;

import java.util.List;

import javax.jws.WebService;

import exception.ClientException;
import exception.HotelException;
import model.dtos.ClientAddDTO;
import model.dtos.ClientDTO;
import model.dtos.DTOAssembler;
import services.ClientService;

@WebService(endpointInterface = "web.services.IClientWS")
public class ClientWS implements IClientWS {

	private ClientService clientService = new ClientService();

	@Override
	public String addClient(ClientAddDTO dto) throws ClientException, HotelException {
		return clientService.addClient(DTOAssembler.toEntity(dto), dto.getIdHotel());
	}

	@Override
	public String deleteClient(Long id) throws ClientException {
		return clientService.deleteClient(id);
	}

	@Override
	public String updateClient(ClientDTO dto) throws ClientException {
		return clientService.updateClient(DTOAssembler.toEntity(dto));
	}

	@Override
	public ClientDTO listClient(Long id) throws ClientException {
		return DTOAssembler.toDTO(clientService.listClient(id));
	}

	@Override
	public List<ClientDTO> listClientsOfHotel(Long hotelId) throws HotelException {
		return DTOAssembler.toListDTO(clientService.listClientsOfHotel(hotelId));
	}

}
