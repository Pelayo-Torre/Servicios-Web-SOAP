package exception;

public class RoomException extends BookingException{

	private static final long serialVersionUID = 1L;

	public RoomException(String message, String faultCode) {
		super(message, faultCode);
	}

}
