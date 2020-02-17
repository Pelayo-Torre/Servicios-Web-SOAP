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
		
		//TODO revisar
		//if(booking.getStartDate().before(new Date()))
		Date startDate = DateUtils.convertStringToDate(booking.getStartDate()); 
		System.out.println("******" + startDate.toString());
		System.out.println("******" + DateUtils.convertDateToString(new Date()));
		if (booking.getStartDate().compareTo(DateUtils.convertDateToString(new Date())) < 0)
			throw new BookingException("La fecha de inicio no puede ser anterior a hoy", "415");
		
		//if(booking.getEndDate().before(booking.getStartDate()))
		Date endDate = DateUtils.convertStringToDate(booking.getEndDate());
		if (endDate.before(startDate))
			throw new BookingException("La fecha de finalización debe ser posterior a la de inicio", "415");
		
		if(booking.getPrice() == null)
			throw new BookingException("El precio de la reserva es obligatorio", "415");
		
		if(booking.getPrice() < 0)
			throw new BookingException("El precio de una reserva no puede ser negativo", "415");
	}
	
}
