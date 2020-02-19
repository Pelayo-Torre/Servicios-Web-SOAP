package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.EntityManager;

import model.Prueba;
import utils.Constants;

public class PruebaDAO {

	private Connection con;
	private PreparedStatement pst = null;
	private ResultSet rs = null;

	/**
	 * Constructor
	 * 
	 * @param con
	 */
	public PruebaDAO(Connection con) {
		this.con = con;
	}

	/**
	 * Método para almacenar el cliente que se pasa por parámetro
	 * 
	 * @param client
	 * @throws SQLException
	 */
	public String addPrueba(Prueba p) throws SQLException {
		Dba dba = new Dba();
		try {
			EntityManager em = dba.getActiveEm();

			em.persist(p);
			em.getTransaction().commit();
		} finally {
			// 100% sure that the transaction and entity manager will be closed
			dba.closeEm();
		}
		return Constants.RESPONSE_OK;
	}

	
}