package validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exception.ClientException;
import model.Client;

public class ClientValidator {

	private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	private static final String PATTERN_PHONE = "^([+][0-9]{1,2}[\\s-]?)?\\"
			+ "(?[\\d]{3}\\)?[\\s-]?[\\d]{3}[\\s-]?[\\d]{3}$";

	/**
	 * Realiza la validación de los datos de una persona
	 * 
	 * @param person, la persona que se va a validar
	 * @throws ClientException, excepción lanzada en caso de erroes en sus datos
	 */
	public void validate(Client person) throws ClientException {
		if (person.getName() == null || person.getName().equals(""))
			throw new ClientException("El nombre es obligatorio", "415");

		if (person.getEmail() == null)
			throw new ClientException("El correo electrónico es obligatorio", "415");

		if (!emailValid(person.getEmail()))
			throw new ClientException("El formato del email es incorrecto", "415");

		if (person.getTelephone() == null)
			throw new ClientException("El teléfono es obligatorio", "415");

		if (!phoneValid(person.getTelephone()))
			throw new ClientException("El formato del teléfono es incorrecto", "415");

		if (person.getDni() == null)
			throw new ClientException("El DNI es obligatorio", "415");

		if (!isNifValid(person.getDni()))
			throw new ClientException("El DNI especificado no es correcto", "415");

	}

	/**
	 * Método para verificar si el email que se pasa por parámetro es correcto
	 * 
	 * @param mail
	 * @return
	 */
	private boolean emailValid(String mail) {
		Pattern pattern = Pattern.compile(PATTERN_EMAIL);
		Matcher matcher = pattern.matcher(mail);
		if (!matcher.matches())
			return false;
		return true;
	}

	/**
	 * Método para verificar si el teléfono que se pasa por parámetro es correcto
	 * 
	 * @param phone
	 * @return
	 */
	private boolean phoneValid(String phone) {
		Pattern pattern = Pattern.compile(PATTERN_PHONE);
		Matcher matcher = pattern.matcher(phone);
		if (!matcher.matches())
			return false;
		return true;
	}

	/**
	 * Método para verificar si el nif que se pasa por parámetro es correcto
	 * 
	 * @param nif
	 * @return
	 */
	private boolean isNifValid(String nif) {
		Pattern p = Pattern.compile("(\\d{1,8})([TRWAGMYFPDXBNJZSQVHLCKEtrwagmyfpdxbnjzsqvhlcke])");
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
