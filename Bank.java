package bank_management;

import java.util.Scanner;

public class Bank {
	User user;
    String bank_name;
    private int holder_id;
    String ifsc_no;
    private int acc_no;
    String branch_name;
    String acc_type;
    private String p_password;
    int amount;

    ATM atm;
    NetBanking netbanking;

    public Bank(String bank_name, int holder_id, String ifsc_no, int acc_no, String branch_name, String acc_type,
                String p_password, int amount, User user) {
        this.bank_name = bank_name;
        this.holder_id = holder_id;
        this.ifsc_no = ifsc_no;
        this.acc_no = acc_no;
        this.branch_name = branch_name;
        this.acc_type = acc_type;
        this.p_password = p_password;
        this.amount = amount;
        this.user = user;
    }

    ATM apply_ATM_Card(Scanner sc) {
    	int pin;
    	int cvv;
        if(atm == null) {
        	do {
		    	System.out.print("\nEnter a 4 digit no to secure your card: ");
		        pin = sc.nextInt();
		        if(new Password_Checks().check_4digit(pin) == false)
		        	System.out.println("\nPin should be of 4 digit");
        	}while(new Password_Checks().check_4digit(pin) == false);
        	sc.nextLine();
	
	        DateOfBirth expr = enter_issue_date(sc);
	        
	        do {
	        	cvv = (int) (Math.random() * 1000);
	        }while(new Password_Checks().check_3digit(cvv) == false);
	
	        return new ATM((int) (Math.random() * 100000000), pin, cvv, expr);
        }
        else {
    		System.out.println("\nNet Banking service for your bank account is available");
    		return atm;
    	}
    }

    DateOfBirth enter_issue_date(Scanner sc) {
        System.out.print("\nEnter issue date: ");
        int date = sc.nextInt();

        System.out.print("\nEnter issue month: ");
        int month = sc.nextInt();

        System.out.print("\nEnter issue year: ");
        int year = sc.nextInt();
        sc.nextLine();

        return new DateOfBirth(date, month, year + 3);
    }

    NetBanking enable_NetBanking(Scanner sc, User u) {
    	String password;
    	int pin;
    	if(netbanking == null) {
	        System.out.print("\nEnter your valid email id: ");
	        u.email = sc.nextLine();
	
	        System.out.print("\nSet a user id for net banking: ");
	        String id = sc.nextLine();
	
	        do {
	        	System.out.println("\nPlease remember your given password should be a Strong Password. \nA Strong Password should contain - \n1.Minimum 8 characters \n2.Minimum 1 Lower case \n3.Minimum 1 Upper case \n4.Minimum 1 Numeric digit \n5.Minimum 1 Special Character");
	        	System.out.print("\nSet a user password for net banking account: ");
	        	password = sc.nextLine();
	        	if(new Password_Checks().check_Strong_Password(password) == false)
	        		System.out.println("\nSorry! This is not a Strong password.");
	        }while(new Password_Checks().check_Strong_Password(password) == false);
	
	        do {
		    	System.out.print("\nSet a 6-digit pin code to secure net banking transaction: ");
		        pin = sc.nextInt();
		        if(new Password_Checks().check_6digit(pin) == false)
		        	System.out.println("\nPin should be of 6 digit");
	        }while(new Password_Checks().check_6digit(pin) == false);
	        sc.nextLine();
	
	        return new NetBanking(id, pin, password);
    	}
    	else {
    		System.out.println("\nNet Banking service for your bank account is available");
    		return netbanking;
    	}
    }

    void show_Profile_Details(Scanner sc) {
        String password;

        do {
            System.out.print("Enter your profile password: ");
            password = sc.nextLine();

            if (password.equals(p_password)) {
                System.out.println("\nThe Account Holder is: " + user.name);
                System.out.println("\nThe Account Holder Id is: " + holder_id);
                System.out.println("\nThe Address details of the Account holder is: \nCountry: " + user.address.country +
                        "\nState: " + user.address.state + "\nCity: " + user.address.city + "\nPin Code: " + user.address.pin);
                System.out.println("\nPhone No: " + user.phn_no);
                System.out.println("\nThe Date of Birth is: " + user.dob.date + "." + user.dob.month + "." + user.dob.year);
                System.out.println("\nThe bank name is: " + bank_name + "(Branch: " + branch_name + ")");
                System.out.println("\nIFSC No: " + ifsc_no);
                System.out.println("\nAccount No: " + acc_no);
                System.out.println("\nAccount Type: " + acc_type);

                if (atm == null)
                    System.out.println("\nATM Facility: unavailable");
                else
                    System.out.println("\nATM Facility: available");

                if (netbanking == null)
                    System.out.println("\nNet Banking Facility: unavailable");
                else
                    System.out.println("\nNet Banking Facility: available");
            } else {
                System.out.println("\nSorry! Wrong password given.");
            }
        } while (!password.equals(p_password));
    }

    void show_ATM_Details(Scanner sc) {
        String password;

        do {
            System.out.print("Enter your profile password: ");
            password = sc.nextLine();

            if (password.equals(p_password)) {
                System.out.println("The ATM card no is: " + atm.card_no);
                System.out.println("The ATM card cvv no is: " + atm.cvv);
                System.out.println("The Expire date of this card is: " + atm.expr.date + "." + atm.expr.month + "." + atm.expr.year);
            } else {
                System.out.println("\nSorry! Wrong password given.");
            }
        } while (!password.equals(p_password));
    }

    void change_Password(Scanner sc) {
        int h_id;
        int account_no;
        String passcode;

        do {
            System.out.print("\nEnter Bank Account Holder Id: ");
            h_id = sc.nextInt();

            System.out.print("\nEnter Bank Account no: ");
            account_no = sc.nextInt();
            sc.nextLine();

            if (h_id == holder_id && account_no == acc_no) {
            	do {
                	System.out.println("\nPlease remember your given password should be a Strong Password. \nA Strong Password should contain - \n1.Minimum 8 characters \n2.Minimum 1 Lower case \n3.Minimum 1 Upper case \n4.Minimum 1 Numeric digit \n5.Minimum 1 Special Character");
                	System.out.print("\nEnter your new password: ");
                	passcode = sc.nextLine();
                	if(new Password_Checks().check_Strong_Password(passcode) == false)
                		System.out.println("\nSorry! This is not a Strong password.");
                	if(passcode == this.p_password)
                		System.out.println("\nPlease enter a new password.");
                }while(new Password_Checks().check_Strong_Password(passcode) == false || passcode == this.p_password);
            	
            	this.p_password = passcode;
                System.out.println("\nYAY! Password has changed for your Bank Account");
            } else {
                System.out.println("Sorry! Wrong details given.");
            }
        } while (h_id != holder_id || account_no != acc_no);
    }

    public String getP_password() {
        return p_password;
    }

    public void setP_password(String p_password) {
        this.p_password = p_password;
    }
}
