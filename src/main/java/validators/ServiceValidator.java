package validators;

import exception.ServiceException;
import model.Service;

public class ServiceValidator {
	
	public void validate(Service service) throws ServiceException {
		
		if(service.getName() == null || "".equals(service.getName()))
			throw new ServiceException("El nombre del servicio es obligatorio", "415");
		
		if(service.getPrice() == null)
			throw new ServiceException("El precio del servicio es obligatorio", "415");
		
		if(service.getPrice() < 0)
			throw new ServiceException("El precio del servicio no puede ser negativo", "415");
	}

}
