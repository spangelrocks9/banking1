package com.project.banking;

import java.util.Scanner;

import com.project.banking.controller.AccountController;
import com.project.banking.controller.BalanceController;

public class App 
{
    public static void main( String[] args )
    {
		AccountController ac = new AccountController();
		BalanceController bc = new BalanceController();
		String choice;
		String decision = "";
		Scanner input = new Scanner(System.in);
		
		do {

			System.out.println("Welcome to Java Global Bank. Pick one of the option.");
			System.out
					.println("\t 1. Open Bank Account \t 2. Deposit Amount \t 3. Withdraw Amount \t 4. Check Balance");
			choice = input.next();

			switch (choice) {
			case "1":
				ac.createAccount(input);
				break;

			case "2":
				bc.depositAmount(input);
				break;

			case "3":
				bc.withdrawAmount(input);
				break;

			case "4":
				bc.getBalance(input);
				break;

			default:
				System.out.println("Wrong choice!");
				break;
			}

			System.out.println("y/n to coninue?");
			decision = input.next();

		} while (decision.equalsIgnoreCase("y"));

		System.out.println("Thank you for using our service. GoodBye!");
    }
}
