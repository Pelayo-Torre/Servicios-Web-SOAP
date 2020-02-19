package validators;

import exception.RoomException;
import model.Room;

public class RoomValidator {
	
	public void validate(Room room) throws RoomException {
		
		if(room.getPrice() == null)
			throw new RoomException("El precio de la habitación es obligatorio", "415");
		
		if(room.getPrice() < 0)
			throw new RoomException("El precio de la habitación no puede ser negativo", "415");
		
		if(room.getRoomType() == null)
			throw new RoomException("El tipo de habitación es obligatorio", "415");
		
	}

}
