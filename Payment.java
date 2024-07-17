package bank_management;

import java.util.Scanner;

public class Payment {
    void pay(Bank bank, ATM atm, NetBanking netbanking, Scanner sc) {
        int i;
        String s;

        do {
            System.out.print("\n1.ATM(press 1) \n2.Net Banking(press 2) \nEnter your transaction mode: ");
            i = sc.nextInt();
            sc.nextLine();

            switch (i) {
                case 1:
                	if(atm == null)
                		System.out.println("Please enable ATM service.");
                	else
                		new ATM_Payment().pay(bank, atm, sc);
                    break;

                case 2:
                	if(netbanking == null)
                		System.out.println("Please enable Net banking service.");
                	else
                		new NetBanking_Payment().pay(bank, netbanking, sc);
                    break;

                default:
                    System.out.println("\nSorry! This choice is out of facility.");
                    break;
            }

            System.out.print("\nDo you want to proceed payments?(y/n): ");
            s = sc.nextLine();

        } while (s.equalsIgnoreCase("y"));
    }
}
