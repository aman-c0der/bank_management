package bank_management;

public class Address {
	final String country = "India";
	String state;
	String city;
	int pin;
	public Address(String state, String city, int pin) {
		this.state = state;
		this.city = city;
		this.pin = pin;
	}
}
