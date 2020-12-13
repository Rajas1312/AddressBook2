package addressbook;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class AddressBook {

	Scanner sc = new Scanner(System.in);
	List<Person> personList = new ArrayList<Person>();
	public static void main(String[] args) {
		System.out.println("Welcome to address book ");
		AddressBook addressBook=new AddressBook();
		int command;
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
        
        do {
        	System.out.print("Enter command: \n");
        	System.out.print("Exit : 0 \n");
        	System.out.print("Add command: 1 \n");
        	System.out.print("Edit command: 2 \n");
        	System.out.print("Delete: 3 \n");
        	System.out.print("Sort by first name: 4 \n");
        	command = addressBook.sc.nextInt();
        	
        	switch(command) {
        	  case 1:
        		  addressBook.sc.nextLine();
        		  addressBook.addPerson();
        	    break;    
        	  case 2:
        		  addressBook.sc.nextLine();
        		  addressBook.editPerson();        		  
        	    break;
        	  case 3:
        		  addressBook.sc.nextLine();
        		  System.out.print("Enter first name to delete");
        		  addressBook.deletePersonFirstName(addressBook.sc.nextLine());
          	    break;
        	  case 4:
        		  System.out.print("Sorted list by first name: ");
        		  System.out.println(addressBook.sortByFirstName());
          	    break;
        	 
        	  default:
        		  System.out.print("Wrong Command!! ");
        	    
        	}
        	
        }while(command != 0);

	}
	
	public boolean personExistsCheckByFirstName (String firstName) {		
		return this.personList.stream().anyMatch(Person -> Person.equals(firstName));
	}
	
	public void addPerson () {

		  System.out.println("Enter first name:");
		  String firstName = sc.nextLine(); 
	      if (!this.personExistsCheckByFirstName(firstName)) {  
	    	  System.out.print("Enter last name:");
	          String lastName = sc.nextLine();
	          System.out.print("Enter city:");
	          String city = sc.nextLine();
	          System.out.print("Enter state:");
	          String state = sc.nextLine();
	          System.out.print("Enter zip:");
	          String zip = sc.nextLine();
	          System.out.print("Enter phoennumber:");
	          String phone = sc.nextLine();
	          Person person=new Person(firstName,lastName,city,state,zip,phone);
	          this.personList.add(person);
	      }
	      else {
	    	  System.out.println("Person with first name : "+firstName+" already exists.");
	      }  
	}
	
	public Person getPersonByFirstName (String firstName) {
		return this.personList.stream().filter(Person -> Person.equals(firstName)).findFirst().get();
	}
	
	 public void editPerson () {

		  System.out.println("Enter first name:");
		  String firstName = sc.nextLine(); 
	      if (this.personExistsCheckByFirstName(firstName)) {  
	    	  Person editPerson = this.getPersonByFirstName(firstName);
	    	  System.out.print("Enter last name:");
	          String lastName = sc.nextLine();
	          editPerson.setLastName(lastName);
	          
	          System.out.print("Enter city:");
	          String city = sc.nextLine();
	          editPerson.setCity(city);
	          
	          System.out.print("Enter state:");
	          String state = sc.nextLine();
	          editPerson.setState(state);
	          
	          System.out.print("Enter zip:");
	          String zip = sc.nextLine();
	          editPerson.setZip(zip);
	          
	          System.out.print("Enter phoennumber:");
	          String phone = sc.nextLine();
	          editPerson.setPhone(phone);
	          
	          System.out.println("Edited person : " + editPerson);
	      }
	      else {
	    	  System.out.println("Person with first name : "+firstName+" does not exists.");
	      }

	}
	 
	 public void deletePersonFirstName (String firstName) {
			this.personList.removeIf(Person -> Person.equals(firstName));
		}
	 
	 public List<Person> sortByFirstName() {
			List<Person> sortedPersonList = this.personList;
			sortedPersonList.sort(Comparator.comparing(Person::getFirstName));		
			return sortedPersonList;
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
	
	@Override
	public boolean equals(Object o) {
				
		if (o == this) { 
            return true; 
        } 
        
        if (!(o instanceof String)) { 
            return false; 
        } 
        
        String firstName = (String)o;
        
		if (this.firstName.equals(firstName))
			return true;
		else 
			return false;
	}
	
}
