package exception;

public class ClientException extends GenericException {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * 
	 * @param message
	 * @param faultCode
	 */
	public ClientException(String message, String faultCode) {
		super(message, faultCode);
	}

}
