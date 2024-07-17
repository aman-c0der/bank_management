package bank_management;

import java.util.Scanner;

public class NetBanking {
    String user_id;
    private int pin_code;
    private String password;

    public NetBanking(String user_id, int pin_code, String password) {
        this.user_id = user_id;
        this.pin_code = pin_code;
        this.password = password;
    }

    void bank_Balance_Check(Bank bank, Scanner sc) {
        String id;
        String passcode;

        do {
            System.out.print("\nEnter your user id: ");
            id = sc.nextLine();

            System.out.print("\nEnter your user password: ");
            passcode = sc.nextLine();

            if (id.equals(user_id) && passcode.equals(password)) {
                System.out.println("The Bank Balance is: " + bank.amount);
            } else {
                System.out.println("Sorry! Wrong User Id or Password Given.");
            }
        } while (!id.equals(user_id) || !passcode.equals(password));
    }

    void fund_Transfer(Bank bank, Scanner sc) {
        String id;
        String passcode;
        int pin;
        int transfer_amount;

        do {
            System.out.print("\nEnter your user id: ");
            id = sc.nextLine();

            System.out.print("\nEnter your user password: ");
            passcode = sc.nextLine();

            if (id.equals(user_id) && passcode.equals(password)) {
                System.out.print("\nEnter amount to transfer: ");
                transfer_amount = sc.nextInt();
                sc.nextLine();

                if (bank.amount < transfer_amount) {
                    System.out.println("Sorry! You do not have enough money to transfer from your account");
                } else {
                    do {
                        System.out.print("\nEnter your net banking pin code: ");
                        pin = sc.nextInt();
                        sc.nextLine();

                        if (pin == pin_code) {
                            bank.amount = bank.amount - transfer_amount;
                            System.out.println(transfer_amount + " rupees debited from your bank balance");
                            System.err.println("The Transaction id is: " + (int) (Math.random() * 100000000));
                        } else {
                            System.out.println("\nSorry! Wrong pin code given.");
                        }
                    } while (pin != pin_code);
                }
            } else {
                System.out.println("Sorry! Wrong User Id or Password Given.");
            }
        } while (!id.equals(user_id) || !passcode.equals(password));
    }
    
    void change_Pin(Bank bank, Scanner sc) {
        String passcode;
        int pincode;

        do {
        	System.out.print("\nEnter your Bank Account Profile Password: ");
        	passcode = sc.nextLine();
        	
            if (passcode.equals(bank.getP_password())) {
            	do {
                	System.out.print("\nEnter your new pin: ");
                	pincode = sc.nextInt();
                	if(new Password_Checks().check_6digit(pincode) == false)
                		System.out.println("\nPin should be of 6 digit");
                	if(pincode == this.pin_code)
                		System.out.println("\nPlease enter a new pin.");
                }while(new Password_Checks().check_6digit(pincode) == false || pincode == this.pin_code);
            	sc.nextLine();
            	
            	this.pin_code = pincode;
                System.out.println("\nYAY! Pin has changed for Net Banking");
            } else {
                System.out.println("Sorry! Wrong details given.");
            }
        } while (passcode.equals(bank.getP_password()) == false);
    }
    
    void change_Password(Bank bank, Scanner sc) {
    	String password;
        String passcode;
        String id;

        do {
        	System.out.print("\nEnter your Bank Account Profile Password: ");
        	password = sc.nextLine();

            if (password.equals(bank.getP_password())) {
            	do {
            		System.out.print("\nSet a new user id for net banking: ");
        	        id = sc.nextLine();
        	        if(id == this.user_id)
        	        	System.out.println("\nPlease enter a new User Id.");
            	}while(id == this.user_id);
            	
            	this.user_id = id;
            	
            	do {
                	System.out.println("\nPlease remember your given password should be a Strong Password. \nA Strong Password should contain - \n1.Minimum 8 characters \n2.Minimum 1 Lower case \n3.Minimum 1 Upper case \n4.Minimum 1 Numeric digit \n5.Minimum 1 Special Character");
                	System.out.print("\nEnter your new password: ");
                	passcode = sc.nextLine();
                	if(new Password_Checks().check_Strong_Password(passcode) == false)
                		System.out.println("\nSorry! This is not a Strong password.");
                	if(passcode == this.password)
                		System.out.println("\nPlease enter a new Password.");
                }while(new Password_Checks().check_Strong_Password(passcode) == false || passcode == this.password);
            	
            	this.password = passcode;
                System.out.println("\nYAY! User Id & Password has changed for Net Banking");
            } else {
                System.out.println("Sorry! Wrong Profile Password given.");
            }
        } while (password.equals(bank.getP_password()) == false);
    }
}
