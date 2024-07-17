package bank_management;

public class User {
	String name;
	Address address;
	String phn_no;
	DateOfBirth dob;
	int age;
	String email;
	private String adhaar_no;
	
	public User(String name, Address address, String phn_no, DateOfBirth dob, int age, String adhaar_no) {
		super();
		this.name = name;
		this.address = address;
		this.phn_no = phn_no;
		this.dob = dob;
		this.age = age;
		this.adhaar_no = adhaar_no;
	}
}