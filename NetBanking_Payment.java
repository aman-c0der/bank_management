package bank_management;

import java.util.Scanner;

public class NetBanking_Payment {
    void pay(Bank bank, NetBanking netbanking, Scanner sc) {
        int i;

        System.out.print("\n1.Fund Transfer(press 1) \n2.Check Bank Balance(press 2) \nEnter your choice: ");
        i = sc.nextInt();
        sc.nextLine();

        switch (i) {
        	case 1:
        		netbanking.fund_Transfer(bank, sc);
            	break;

            case 2:
                netbanking.bank_Balance_Check(bank, sc);
                break;

            default:
                System.out.println("Sorry! This choice is out of facility.");
                break;
         }
    }
}
