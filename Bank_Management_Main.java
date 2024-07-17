package bank_management;

import java.util.Scanner;

public class Bank_Management_Main {
	public static void main(String[] args) {
		Bank bank = null;
		User user = null;
		int i;
		String s;
		String password;
		
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		
		do {
			System.out.print("\n1.Create Account(Press 1) \n2.LogIn to your Account(Press 2) \nEnter your choice: ");
			i = sc2.nextInt();
			
			switch(i) {
				case 1:
					Account_Creation acc = new Account_Creation();
					
					user = acc.enter_User_Details(sc);
					bank = acc.create_Account(user, sc);
					
					break;
					
				case 2:
					if(bank == null || user == null) {
						System.out.println("Ops! Looks like you don't have any Bank Account. Please Create a bank account first");
					}
					else {
						do {
							System.out.print("Enter your profile password: ");
							password = sc1.nextLine();
							
							if(password.equals(bank.getP_password())) {
								new LogIn().operation(bank,user);
								break;
							}
							else
								System.out.println("\nPlease enter your correct password.");
						}while(password.equals(bank.getP_password()) != true);
					}
					break;
				default:
					System.out.println("Sorry! Wrong choice given");
					break;
			}
			
			System.out.print("Do you want to proceed again?(y/n): ");
			s = sc1.nextLine(); 
		}while(s.equalsIgnoreCase("y"));
		
		sc1.close();
		sc2.close();
	}

}
