package validators;

import java.util.Date;

import exception.BookingException;
import model.Booking;

public class BookingValidator {

	public void validate(Booking booking) throws BookingException {
		if(booking.getStartDate() == null)
			throw new BookingException("La fecha de inicio de reserva es obligatoria", "415");
		
		if(booking.getEndDate() == null)
			throw new BookingException("La fecha de finalización es obligatoria", "415");
		
		if(booking.getStartDate().before(new Date()))
			throw new BookingException("La fecha de inicio debe ser posterior a hoy", "415");
		
		if(booking.getEndDate().before(booking.getStartDate()))
			throw new BookingException("La fecha de finalización debe ser posterior a la de inicio", "415");
		
		if(booking.getPrice() == null)
			throw new BookingException("El precio de la reserva es obligatorio", "415");
		
		if(booking.getPrice() < 0)
			throw new BookingException("El precio de una reserva no puede ser negativo", "415");
	}
	
}
