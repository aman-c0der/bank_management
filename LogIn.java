package bank_management;

import java.util.Scanner;

public class LogIn {
    void operation(Bank bank, User user) {
        int i;
        String s;

        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("\n1. Show Profile Details (press 1) \n2. Check bank Balance (press 2) \n3. ATM card issue (press 3) \n4. Enabling NetBanking (press 4) \n5. Show ATM card details (press 5) \n6. Make payment (press 6) \n7. Change Profile Password (press 7) \n8. Change ATM Pin (press 8) \n9. Change Net Banking Pin (press 9) \n10. Change Net Banking Password (press 10) \nEnter your choice: ");
            i = sc.nextInt();
            sc.nextLine();

            switch (i) {
                case 1:
                    bank.show_Profile_Details(sc);
                    break;

                case 2:
                    if (bank.netbanking == null)
                        System.out.println("\nUnavailable to check bank balance. Please enable net banking service for your bank account.");
                    else
                        bank.netbanking.bank_Balance_Check(bank, sc);
                    break;

                case 3:
                    bank.atm = bank.apply_ATM_Card(sc);
                    break;

                case 4:
                    bank.netbanking = bank.enable_NetBanking(sc, user);
                    break;

                case 5:
                    bank.show_ATM_Details(sc);
                    break;

                case 6:
                    new Payment().pay(bank, bank.atm, bank.netbanking, sc);
                    break;

                case 7:
                    bank.change_Password(sc);
                    break;
                    
                case 8:
                	if(bank.atm == null)
                		System.out.println("\nSorry! You don't have any ATM service for your Bank Account");
                	else 
                		bank.atm.change_Pin(bank, sc);
                	break;
                	
                case 9:
                	if(bank.netbanking == null)
                		System.out.println("\nSorry! You don't have any Net Banking service for your Bank Account");
                	else 
                		bank.netbanking.change_Pin(bank, sc);
                	break;
                	
                case 10:
                	if(bank.netbanking == null)
                		System.out.println("\nSorry! You don't have any Net Banking service for your Bank Account");
                	else {
                		bank.netbanking.change_Password(bank, sc);
                		System.out.println("\nNow you have to change your Net Banking Pin.");
                		bank.netbanking.change_Pin(bank, sc);
                	}
                	break;
                	
                default:
                    System.out.println("\nSorry! This choice is out of facility.");
                    break;
            }

            System.out.print("\nDo you want to proceed in Login? (y/n): ");
            s = sc.nextLine();

        } while (s.equalsIgnoreCase("y"));
    }
}
