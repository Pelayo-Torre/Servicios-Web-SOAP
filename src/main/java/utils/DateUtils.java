package utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	private final static String dateString = "dd-MM-yyyy";

	/**
	 * Método para convertir la fecha que se pasa por parámetro a string
	 * 
	 * @param date
	 * @return
	 */
	public static String convertDateToString(Date date) {
		DateFormat dateFormat = new SimpleDateFormat(dateString);
		return dateFormat.format(date);
	}

	/**
	 * Método para convertir la cadena que se pasa por parámetro a fecha
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date convertStringToDate(String date) throws ParseException {
		DateFormat format = new SimpleDateFormat(dateString);
		try {
			return format.parse(date);
		} catch (ParseException e) {
			throw new ParseException("Formato de fecha no válido", 0);
		}
	}
}
