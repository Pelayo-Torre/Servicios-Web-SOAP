package persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import exception.ClientException;
import model.Client;
import utils.Constants;

public class ClientDAO {

	/**
	 * Constructor
	 */
	public ClientDAO() {
	}

	/**
	 * Método para almacenar el cliente que se pasa por parámetro
	 * 
	 * @param client
	 */
	public String addClient(Client client) {
		Dba dba = new Dba();
		try {
			EntityManager em = dba.getActiveEm();
			em.persist(client);
			em.getTransaction().commit();
			return Constants.RESPONSE_OK;
		} finally {
			dba.closeEm();
		}
	}

	/**
	 * Método para borrar el cliente cuyo id se pasa por parametro
	 * 
	 * @return
	 * @throws ClientException
	 */
	public String deleteClient(Long id) throws ClientException {

		Dba dba = new Dba();
		try {
			EntityManager em = dba.getActiveEm();

			Client client = em.find(Client.class, id);
			if (client == null)
				throw new ClientException("El cliente con id =  " + id + " no existe.", "404");

			em.remove(client);
			em.getTransaction().commit();
			return Constants.RESPONSE_OK;
		} finally {
			dba.closeEm();
		}
	}

	/**
	 * Método para actualizar el cliente que se pasa por parámetro
	 * 
	 * @param client
	 */
	public String updateClient(Client client) {
		Dba dba = new Dba();
		try {
			EntityManager em = dba.getActiveEm();
			em.merge(client);
			em.getTransaction().commit();
			return Constants.RESPONSE_OK;
		} finally {
			dba.closeEm();
		}
	}

	/**
	 * Método para obtener el cliente cuyo id se pasa por parametro
	 * 
	 * @return
	 * @throws ClientException
	 */
	public Client listClient(Long id) throws ClientException {

		Client client = null;
		Dba dba = new Dba();
		try {
			EntityManager em = dba.getActiveEm();

			client = em.find(Client.class, id);
			if (client == null)
				throw new ClientException("El cliente con id =  " + id + " no existe.", "404");

		} finally {
			dba.closeEm();
		}
		return client;
	}

	/**
	 * Método para comprobar si existe el cliente cuyo dni se pasa por parametro
	 * 
	 * @return
	 */
	public Client findClientByDNI(String dni) {

		Client resultList = null;

		Dba dba = new Dba();
		try {
			EntityManager em = dba.getActiveEm();
			resultList = em.createQuery("Select c From Client c Where c.dni = :dni", Client.class)
					.setParameter("dni", dni).getSingleResult();
		} 
		catch (NoResultException e) {
			return null;
		} 
		finally {
			dba.closeEm();
		}
		return resultList;
	}

	/**
	 * Método para obtener los clientes del hotel que se pasa por parametro
	 * 
	 * @return
	 */
	public List<Client> listClientsOfHotel(Long hotelId) {

		List<Client> resultList = null;

		Dba dba = new Dba();
		try {
			EntityManager em = dba.getActiveEm();
			resultList = em.createQuery("select c from Client c where c.hotel.id = :hotelId", Client.class)
					.setParameter("hotelId", hotelId).getResultList();
		} finally {
			dba.closeEm();
		}
		return resultList;
	}
}