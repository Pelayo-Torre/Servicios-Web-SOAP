package services;

import java.sql.SQLException;
import java.util.List;

import exception.HotelException;
import model.Hotel;
import persistence.HotelDAO;
import persistence.ManagerDAO;
import validators.HotelValidator;

public class HotelService {

	private HotelDAO dao = ManagerDAO.getInstance().getHotelDAO();
	private HotelValidator hotelValidator = new HotelValidator();

	/**
	 * M�todo para a�adir un hotel
	 * 
	 * @param hotel
	 * @return
	 * @throws SQLException
	 * @throws HotelException
	 */
	public String addHotel(Hotel hotel) throws SQLException, HotelException {
		hotelValidator.validate(hotel);
		return dao.addHotel(hotel);
	}

	/**
	 * M�todo para borrar un hotel
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 * @throws HotelException
	 */
	public String deleteHotel(Long id) throws SQLException, HotelException {
		Hotel h = dao.listHotel(id);
		if (h == null)
			throw new HotelException("El hotel que se desea eliminar no existe", "404");

		return dao.deleteHotel(id);
	}

	/**
	 * M�todo para actualizar el hotel que se pasa por par�metro
	 * 
	 * @param hotel
	 * @return
	 * @throws SQLException
	 * @throws HotelException
	 */
	public String updateHotel(Long id, Hotel hotel) throws SQLException, HotelException {
		hotelValidator.validate(hotel);
		Hotel c = dao.listHotel(id);
		if (c == null)
			throw new HotelException("El hotel que se desea eliminar no existe", "404");
		hotel.setId(id);
		return dao.updateHotel(hotel);
	}

	/**
	 * M�todo para obtener el hotel cuyo id se pasa por par�metro
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Hotel listHotel(Long id) throws SQLException {
		return dao.listHotel(id);
	}

	/**
	 * M�todo para obtener la lista de hoteles
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Hotel> listHotels() throws SQLException {
		return dao.listHotels();
	}

}
