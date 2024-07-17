package bank_management;

import java.util.Scanner;

public class Account_Creation {
	static Address enter_Address_Details(Scanner sc) {
        System.out.print("\nEnter your state: ");
        String state = sc.nextLine();
        
        System.out.print("\nEnter your city: ");
        String city = sc.nextLine();
        
        System.out.print("\nEnter your pin code: ");
        int pin = sc.nextInt();
        sc.nextLine(); 
        
        return new Address(state, city, pin);
    }
    
    static DateOfBirth enter_DOB_Details(Scanner sc) {
        System.out.print("\nEnter your date: ");
        int date = sc.nextInt();
        
        System.out.print("\nEnter your month: ");
        int month = sc.nextInt();
        
        System.out.print("\nEnter your year: ");
        int year = sc.nextInt();
        sc.nextLine();
        
        return new DateOfBirth(date, month, year);
    }
    
    User enter_User_Details(Scanner sc) {
    	String phn_no;
    	String adhaar;
    	int j;
    	boolean flag = true;
    	
        System.out.print("\nEnter your name: ");
        String name = sc.nextLine();
        
        do {
	        System.out.print("\nEnter your phone no: ");
	        phn_no = sc.nextLine();
	        
	        if(phn_no.length() != 10)
	        	System.out.println("\nPlease maintain a valid Phone no. should have 10 digit");
	        
	        for(j = 0; j < phn_no.length(); j++) {
	        	flag = true;
	        	if(phn_no.charAt(j) < 48 || phn_no.charAt(j) > 57) {
	        		System.out.println("\nA Phone no. should contain numeric digit only.");
	        		System.out.println("\nPlease enter a valid Phone no.");
	        		flag = false;
	        		break;
	        	}
	        }        
	        
        }while(phn_no.length() != 10 || flag == false);
        
        System.out.print("\nEnter your age: ");
        int age = sc.nextInt();
        sc.nextLine();
        
        System.out.print("\nEnter your address: ");
        Address ad = enter_Address_Details(sc);
        
        System.out.print("\nEnter your date of birth: ");
        DateOfBirth dob = enter_DOB_Details(sc);
        
        do {
	        System.out.print("\nEnter your Adhaar card no: ");
	        adhaar = sc.nextLine();
	        
	        if(adhaar.length() != 12)
	        	System.out.println("\nPlease maintain a valid Adhaar card no. should have 12 digit");
	        	
	        for(j = 0; j < adhaar.length(); j++) {
	        	flag = true;
	        	if(adhaar.charAt(j) < 48 || adhaar.charAt(j) > 57) {
	        		System.out.println("\nA Adhaar card no. should contain numeric digit only.");
	        		System.out.println("\nPlease enter a valid Adhaar card no.");
	        		flag = false;
	        		break;
	        	}
	        }
        }while(adhaar.length() != 12 || flag == false);
        
        return new User(name, ad, phn_no, dob, age, adhaar);
    }
    
    Bank create_Account(User user, Scanner sc) {
    	String password;
        System.out.print("\nAvailable banks are: \n1. SBI Bank(To choose press 1) \n2. PNB Bank(To choose press 2) \n3. Axis Bank(To choose press 3) \n4. Canara Bank(To choose press 4)");
        System.out.print("\nEnter your choice: ");
        int i = sc.nextInt();
        sc.nextLine();
        
        System.out.print("\nEnter your bank branch: ");
        String branch = sc.nextLine();
        
        System.out.print("\nEnter your bank account type: ");
        String acc_type = sc.nextLine();
        
        do {
        	System.out.println("\nPlease remember your given password should be a Strong Password. \nA Strong Password should contain - \n1.Minimum 8 characters \n2.Minimum 1 Lower case \n3.Minimum 1 Upper case \n4.Minimum 1 Numeric digit \n5.Minimum 1 Special Character");
        	System.out.print("\nEnter your bank account password: ");
        	password = sc.nextLine();
        	if(new Password_Checks().check_Strong_Password(password) == false)
        		System.out.println("\nSorry! This is not a Strong password.");
        }while(new Password_Checks().check_Strong_Password(password) == false);
        
        switch(i) {
            case 1:
                return new SBI_Bank("SBI Bank", (int) (Math.random() * 100000000), "sbin0036789", (int) (Math.random() * 1000000000), branch, acc_type, password, 2000, user);
                    
            case 2:
                return new PNB_Bank("PNB Bank", (int) (Math.random() * 100000000), "pnbi0036789", (int) (Math.random() * 1000000000), branch, acc_type, password, 500, user);
                
            case 3:
                return new Axis_Bank("Axis Bank", (int) (Math.random() * 100000000), "axisa0036789", (int) (Math.random() * 1000000000), branch, acc_type, password, 1000, user);
                
            case 4:
                return new SBI_Bank("Canara Bank", (int) (Math.random() * 100000000), "canarar0036789", (int) (Math.random() * 1000000000), branch, acc_type, password, 500, user);
                
            default:
                System.out.println("Chosen bank account creation facility is currently unavailable");
                return null;
        }
    }
}
