package persistence;

public class ManagerDAO {

	private static ManagerDAO managerDAO = null;
	protected HotelDAO hotelDAO = null;
	protected ClientDAO clientDAO = null;
	protected BookingDAO bookingDAO = null;
	protected RoomDAO roomDAO = null;
	protected ServiceDAO serviceDAO = null;

	/**
	 * Método para obtener una instancia de ManagerDAO
	 * 
	 * @return
	 */
	public static ManagerDAO getInstance() {
		if (managerDAO == null) {
			managerDAO = new ManagerDAO();
		}
		return managerDAO;
	}

	/**
	 * Método para obtener una instancia de HotelDAO
	 * 
	 * @return
	 */
	public HotelDAO getHotelDAO() {
		if (managerDAO.hotelDAO == null) {
			managerDAO.hotelDAO = new HotelDAO();
		}
		return managerDAO.hotelDAO;
	}

	/**
	 * Método para obtener una instancia de ClientDAO
	 * 
	 * @return
	 */
	public ClientDAO getClientDAO() {
		if (managerDAO.clientDAO == null) {
			managerDAO.clientDAO = new ClientDAO();
		}
		return managerDAO.clientDAO;
	}

	/**
	 * Método para obtener una instacia de BookingDAO
	 * 
	 * @return
	 */
	public BookingDAO getBookingDAO() {
		if (managerDAO.bookingDAO == null) {
			managerDAO.bookingDAO = new BookingDAO();
		}
		return managerDAO.bookingDAO;
	}

	/**
	 * Método para obtener una instacia de RoomDAO
	 * 
	 * @return
	 */
	public RoomDAO getRoomDAO() {
		if (managerDAO.roomDAO == null) {
			managerDAO.roomDAO = new RoomDAO();
		}
		return managerDAO.roomDAO;
	}

	/**
	 * Método para obtener una instacia de ServiceDAO
	 * 
	 * @return
	 */
	public ServiceDAO getServiceDAO() {
		if (managerDAO.serviceDAO == null) {
			managerDAO.serviceDAO = new ServiceDAO();
		}
		return managerDAO.serviceDAO;
	}
}