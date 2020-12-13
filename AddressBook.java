package addressbook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {

	Scanner sc = new Scanner(System.in);
	List<Person> personList = new ArrayList<Person>();
	public static void main(String[] args) {
		System.out.println("Welcome to address book ");
		AddressBook addressBook=new AddressBook();
		Person person = new Person("Sagar","Maharaj","Mumbai","MH","40051","989"); 
        addressBook.personList.add(person);
        person = new Person("Rajas","Dongre","Mumbai","MH","40051","989");
        addressBook.personList.add(person);
        person = new Person("Aditya","Surpriya","Andheri","MH","40051","989");
        addressBook.personList.add(person);
        person = new Person("Misbah","Female","Mumbai","MW","40051","989");
        addressBook.personList.add(person);
        person = new Person("Shreya","Shreeshail","Pune","MH","40051","989"); 
        addressBook.personList.add(person);
        person = new Person("Uzair","Chhapra","Thane","MH","40051","989"); 
        addressBook.personList.add(person);
        System.out.println(addressBook.personList);

	}

}
class Person{
	
	String firstName;
	String lastName;
	String city;
	String state;
	String zip;
	String phone;
	
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Person(String firstName,String lastName,String city,String state,String zip,String phone) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.city=city;
		this.state=state;
		this.zip=zip;
		this.phone=phone;
		
	}
	
	@Override
	public String toString() {
		return "[firstName=" + firstName + ", lastName=" + lastName + ", city=" + city + ", state=" + state
				+ ", zip=" + zip + ", phone=" + phone + "]\n";
	}
	
}
