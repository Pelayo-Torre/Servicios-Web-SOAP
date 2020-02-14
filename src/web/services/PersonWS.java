package web.services;

import java.util.ArrayList;

import javax.jws.WebService;

import modelo.Person;

@WebService(endpointInterface = "web.services.IPersonWS")
public class PersonWS implements IPersonWS{
	
	private ArrayList<Person> personas = new ArrayList<Person>();

	@Override
	public String add(String name, String surname, String mail, String phone, int age) {
		Person p = new Person();
		
		p.setAge(age);
		p.setMail(mail);
		p.setName(name);
		p.setPhone(phone);
		p.setSurname(surname);
		
		personas.add(p);
		
		return p.toString();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String update(Person p) {
		
		////////////////////////
		
		//Funciona, se puede pasar el objeto Person pero debe implementar de Serializable
		
		/////////////////////////
		return p.toString();
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
