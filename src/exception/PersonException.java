package exception;

public class PersonException extends Exception{

	private static final long serialVersionUID = 1L;
	
	private String faultCode;
	private String faultString;
		
	public PersonException(String message, String faultCode) {
		super(message);
		this.faultString = getMessage();
		this.faultCode = faultCode;
	}

	public String getFaultCode() {
		return faultCode;
	}

	public String getFaultString() {
		return faultString;
	}
	
	

}
