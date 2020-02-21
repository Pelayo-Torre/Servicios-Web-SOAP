package validators;

import java.text.ParseException;
import java.util.Date;

import exception.BookingException;
import model.Booking;
import utils.DateUtils;

public class BookingValidator {

	public void validate(Booking booking) throws BookingException, ParseException {
		if(booking.getStartDate() == null || booking.getStartDate().isEmpty())
			throw new BookingException("La fecha de inicio de reserva es obligatoria", "415");
		
		if(booking.getEndDate() == null || booking.getEndDate().isEmpty())
			throw new BookingException("La fecha de finalización es obligatoria", "415");
		
		Date startDate = DateUtils.convertStringToDate(booking.getStartDate()); 
		Date endDate = DateUtils.convertStringToDate(booking.getEndDate());
		Date now = DateUtils.convertStringToDate(DateUtils.convertDateToString(new Date()));
		if (startDate.compareTo(now) < 0)
			throw new BookingException("La fecha de inicio no puede ser anterior a hoy", "415");
		else if (startDate.compareTo(endDate) > 0)
			throw new BookingException("La fecha de inicio no puede ser posterior a la fecha de finalización", "415");
		
		
		if(booking.getPrice() == null)
			throw new BookingException("El precio de la reserva es obligatorio", "415");
		
		if(booking.getPrice() < 0)
			throw new BookingException("El precio de una reserva no puede ser negativo", "415");
	}
	
}
