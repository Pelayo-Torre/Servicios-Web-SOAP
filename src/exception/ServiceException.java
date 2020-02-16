package exception;

public class ServiceException extends GenericException{

	private static final long serialVersionUID = 1L;

	public ServiceException(String message, String faultCode) {
		super(message, faultCode);
	}

}
