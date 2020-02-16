package persistence;

import java.sql.Connection;

import persistence.client.ClientDAO;

public class ManagerDAO {

	private static ManagerDAO managerDAO = null;
	protected Connection connection = null;
	protected ClientDAO clientDAO = null;

	/**
	 * Método para obtener una instancia de ManagerDAO
	 * @return
	 */
	public static ManagerDAO getInstance() {
		if (managerDAO == null) {
			managerDAO = new ManagerDAO();
			managerDAO.connection = Database.getConnection();
		}
		return managerDAO;
	}

	public ClientDAO getClientDAO() {
		if (managerDAO.clientDAO == null) {
			managerDAO.clientDAO = new ClientDAO(managerDAO.connection);
		}
		return managerDAO.clientDAO;
	}

}