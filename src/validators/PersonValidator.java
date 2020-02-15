package validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exception.PersonException;
import model.Client;

public class PersonValidator {
	
	private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	private static final String PATTERN_PHONE = "^([+][0-9]{1,2}[\\s-]?)?\\"
			+ "(?[\\d]{3}\\)?[\\s-]?[\\d]{3}[\\s-]?[\\d]{3}$";
	
	/**
	 * Realiza la validación de los datos de una persona
	 * @param person, la persona que se va a validar
	 * @throws PersonException, excepción lanzada en caso de erroes en sus datos
	 */
	public void validate(Client person) throws PersonException {
		if(person.getName() == null || person.getName().equals(""))
			throw new PersonException("El nombre es obligatorio", "415");
		
		if(person.getMail() == null)
			throw new PersonException("El correo electrónico es obligatorio", "415");
		
		if(!emailValid(person.getMail()))
			throw new PersonException("El formato del email es incorrecto", "415");
		
		if(person.getAge() == null)
			throw new PersonException("La edad es obligatoria", "415");
		
		if(person.getAge() < 0 || person.getAge() > 120)
			throw new PersonException("La edad debe estar comprendida entre 0 y 120", "415");
		
		if(person.getPhone() == null) 
			throw new PersonException("El teléfono es obligatorio", "415");
		
		if(!phoneValid(person.getPhone()))
			throw new PersonException("El formato del teléfono es incorrecto", "415");
		
		if(person.getDni() == null)
			throw new PersonException("El DNI es obligatorio", "415");
		
		if(!isNifValid(person.getDni()))
			throw new PersonException("El DNI especificado no existe", "415");
		
	}
	
	private boolean emailValid(String mail) {
		Pattern pattern = Pattern.compile(PATTERN_EMAIL);
		Matcher matcher = pattern.matcher(mail);
		if (!matcher.matches()) 
			return false;
		return true;
	}
	
	private boolean phoneValid(String mail) {
		Pattern pattern = Pattern.compile(PATTERN_PHONE);
		Matcher matcher = pattern.matcher(mail);
		if (!matcher.matches()) 
			return false;
		return true;
	}
	
	private boolean isNifValid(String nif) {
		Pattern p = Pattern.compile(
				"(\\d{1,8})([TRWAGMYFPDXBNJZSQVHLCKEtrwagmyfpdxbnjzsqvhlcke])");
		Matcher m = p.matcher(nif);
		boolean correct = false;
		if (m.matches()) {
			String lettersPossibles = "TRWAGMYFPDXBNJZSQVHLCKE";
			String letter = m.group(2);
			int pos = Integer.parseInt(m.group(1));
			pos = pos % 23;
			String r = lettersPossibles.substring(pos, pos + 1);
			if (r.equalsIgnoreCase(letter)) {
				correct = true;
			} else {
				correct = false;
			}
		} else {
			correct = false;
		}
		return correct;
	}

}
