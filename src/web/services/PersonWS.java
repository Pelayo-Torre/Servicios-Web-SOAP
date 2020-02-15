package web.services;

import java.util.ArrayList;

import javax.jws.WebService;

import exception.PersonException;
import modelo.Person;
import utils.Constantes;
import validators.PersonValidator;


@WebService(endpointInterface = "web.services.IPersonWS")
public class PersonWS implements IPersonWS{
	
	private ArrayList<Person> personas = new ArrayList<Person>();
	private PersonValidator personValidator = new PersonValidator();

	@Override
	public String add(Person person) throws PersonException {
		personValidator.validate(person);
		personas.add(person);
		return Constantes.RESPONSE_OK;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String update(Person person) throws PersonException {
		personValidator.validate(person);
		personas.add(person);
		return Constantes.RESPONSE_OK;
	}

	@Override
	public void getPerson(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Person[] getList() {
		Person [] array = new Person [personas.size()];
		array = (Person[]) personas.toArray();
		return array;
	}

}
