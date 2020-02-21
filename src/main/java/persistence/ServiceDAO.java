package persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import exception.ServiceException;
import model.Service;
import utils.Constants;

public class ServiceDAO {

	/**
	 * Constructor
	 */
	public ServiceDAO() {
	}

	/**
	 * Método para almacenar el servicio que se pasa por parámetro
	 * 
	 * @param service
	 */
	public String addService(Service service) {
		Dba dba = new Dba();
		try {
			EntityManager em = dba.getActiveEm();
			em.persist(service);
			em.getTransaction().commit();
			return Constants.RESPONSE_OK;
		} finally {
			dba.closeEm();
		}
	}

	/**
	 * Método para borrar el servicio cuyo id se pasa por parametro
	 * 
	 * @return
	 * @throws ServiceException
	 */
	public String deleteService(Long id) throws ServiceException {

		Dba dba = new Dba();
		try {
			EntityManager em = dba.getActiveEm();

			Service service = em.find(Service.class, id);
			if (service == null)
				throw new ServiceException("El servicio con id =  " + id + " no existe.", "404");

			em.remove(service);
			em.getTransaction().commit();
			return Constants.RESPONSE_OK;
		} finally {
			dba.closeEm();
		}
	}

	/**
	 * Método para actualizar el servicio que se pasa por parámetro
	 * 
	 * @param service
	 */
	public String updateService(Service service) {
		Dba dba = new Dba();
		try {
			EntityManager em = dba.getActiveEm();
			em.merge(service);
			em.getTransaction().commit();
			return Constants.RESPONSE_OK;
		} finally {
			dba.closeEm();
		}
	}

	/**
	 * Método para obtener el servicio cuyo id se pasa por parametro
	 * 
	 * @return
	 * @throws ServiceException
	 */
	public Service listService(Long id) throws ServiceException {

		Service service = null;
		Dba dba = new Dba();
		try {
			EntityManager em = dba.getActiveEm();

			service = em.find(Service.class, id);
			if (service == null)
				throw new ServiceException("El servicio con id =  " + id + " no existe.", "404");

		} finally {
			dba.closeEm();
		}
		return service;
	}

	/**
	 * Método para comprobar si existe el servicio cuyo codigo se pasa por parametro
	 * 
	 * @return
	 */
	public Service findServiceByCode(String code) {

		Service resultList = null;

		Dba dba = new Dba();
		try {
			EntityManager em = dba.getActiveEm();
			resultList = em.createQuery("Select s From Service s Where s.code = :code", Service.class)
					.setParameter("code", code).getSingleResult();
		} catch (NoResultException e) {
			return null;
		} finally {
			dba.closeEm();
		}
		return resultList;
	}

	/**
	 * Método para obtener los servicios del hotel que se pasa por parametro
	 * 
	 * @return
	 */
	public List<Service> listServicesOfHotel(Long hotelId) {

		List<Service> resultList = null;

		Dba dba = new Dba();
		try {
			EntityManager em = dba.getActiveEm();
			resultList = em.createQuery("select s From Service s where s.hotel.id = :hotelId", Service.class)
					.setParameter("hotelId", hotelId).getResultList();
		} finally {
			dba.closeEm();
		}
		return resultList;
	}

}