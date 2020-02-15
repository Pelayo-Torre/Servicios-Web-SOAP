package exception;

public class PersonException extends GenericException{

	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor
	 * @param message
	 * @param faultCode
	 */
	public PersonException(String message, String faultCode) {
		super(message, faultCode);
	}

}
