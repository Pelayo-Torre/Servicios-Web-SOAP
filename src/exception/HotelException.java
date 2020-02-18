package exception;

public class HotelException extends GenericException {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * 
	 * @param message
	 * @param faultCode
	 */
	public HotelException(String message, String faultCode) {
		super(message, faultCode);
	}

}
