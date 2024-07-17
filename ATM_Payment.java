package bank_management;

import java.util.Scanner;

public class ATM_Payment {
    void pay(Bank bank, ATM atm, Scanner sc) {
        int i;
        String s;

        do {
            System.out.print("\n1. Money Deposit (press 1) \n2. Money Withdrawal (press 2) \nEnter your choice: ");
            i = sc.nextInt();
            sc.nextLine();
            switch (i) {
                case 1:
                    atm.money_Deposit(bank, sc);
                    break;

                case 2:
                    atm.money_Withdrawal(bank, sc);
                    break;

                default:
                    System.out.println("\nSorry! This choice is out of facility.");
                    break;
            }

            System.out.print("");
            s = sc.nextLine();

        } while (s.equalsIgnoreCase("y"));
    }
}
