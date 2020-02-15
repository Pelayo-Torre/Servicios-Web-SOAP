package exception;

public class GenericException extends Exception{

	private static final long serialVersionUID = 1L;
	
	private String faultCode;
	private String faultString;
	
	public String getFaultCode() {
		return faultCode;
	}

	public String getFaultString() {
		return faultString;
	}
	
	/**
	 * Constructor
	 * @param message
	 * @param faultCode
	 */
	public GenericException(String message, String faultCode) {
		super(message);
		this.faultString = getMessage();
		this.faultCode = faultCode;
	}

}
