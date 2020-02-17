package persistence;

import java.sql.Connection;

public class ManagerDAO {

	private static ManagerDAO managerDAO = null;
	protected Connection connection = null;
	protected ClientDAO clientDAO = null;
	protected BookingDAO bookingDAO = null;
	protected RoomDAO roomDAO = null;

	/**
	 * M�todo para obtener una instancia de ManagerDAO
	 * 
	 * @return
	 */
	public static ManagerDAO getInstance() {
		if (managerDAO == null) {
			managerDAO = new ManagerDAO();
			managerDAO.connection = Database.getConnection();
		}
		return managerDAO;
	}

	/**
	 * M�todo para obtener una instancia de ClientDAO
	 * 
	 * @return
	 */
	public ClientDAO getClientDAO() {
		if (managerDAO.clientDAO == null) {
			managerDAO.clientDAO = new ClientDAO(managerDAO.connection);
		}
		return managerDAO.clientDAO;
	}

	/**
	 * M�todo para obtener una instacia de BookingDAO
	 * 
	 * @return
	 */
	public BookingDAO getBookingDAO() {
		if (managerDAO.bookingDAO == null) {
			managerDAO.bookingDAO = new BookingDAO(managerDAO.connection);
		}
		return managerDAO.bookingDAO;
	}

	/**
	 * M�todo para obtener una instacia de RoomDAO
	 * 
	 * @return
	 */
	public RoomDAO getRoomDAO() {
		if (managerDAO.roomDAO == null) {
			managerDAO.roomDAO = new RoomDAO(managerDAO.connection);
		}
		return managerDAO.roomDAO;
	}
}