package exception;

public class BookingException extends GenericException {

	private static final long serialVersionUID = 1L;

	public BookingException(String message, String faultCode) {
		super(message, faultCode);
	}

}
