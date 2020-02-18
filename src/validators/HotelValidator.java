package validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exception.HotelException;
import model.Hotel;

public class HotelValidator {

	private static final String PATTERN_PHONE = "^([+][0-9]{1,2}[\\s-]?)?\\"
			+ "(?[\\d]{3}\\)?[\\s-]?[\\d]{3}[\\s-]?[\\d]{3}$";

	public void validate(Hotel hotel) throws HotelException {
		if (hotel.getName() == null || hotel.getName().isEmpty())
			throw new HotelException("El nombre es obligatorio", "415");

		if (hotel.getCountry() == null || hotel.getCountry().isEmpty())
			throw new HotelException("El país es obligatorio", "415");

		if (!phoneValid(hotel.getTelephone()))
			throw new HotelException("El formato del teléfono es incorrecto", "415");

		if (hotel.getAddress() == null)
			throw new HotelException("La dirección es obligatoria", "415");
	}

	/**
	 * Método para verificar si el teléfono que se pasa por parámetro es correcto
	 * 
	 * @param phone
	 * @return
	 */
	private boolean phoneValid(String phone) {
		Pattern pattern = Pattern.compile(PATTERN_PHONE);
		Matcher matcher = pattern.matcher(phone);
		if (!matcher.matches())
			return false;
		return true;
	}

}
