package ch4;

import java.util.HashSet;
import java.util.Set;

public class PersionSet {
	private final Set<Person> mySet = new HashSet<>();
	
	public synchronized void addPerson(Person person) {
		mySet.add(person);
	}
	
	public synchronized boolean containsPerson(Person person) {
		return mySet.contains(person);
	}
}

class Person {
	private String firstName;
	private String lastName;
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}