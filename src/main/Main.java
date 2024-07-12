package main;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Main {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("Enter account data:");
			System.out.print("Number: ");
			int number = sc.nextInt();
			sc.nextLine();
			System.out.print("Holder: ");
			String holder = sc.nextLine();
			System.out.print("Initial balance: ");
			double initial = sc.nextDouble();
			sc.nextLine();
			System.out.print("Withdraw limit: ");
			double limit = sc.nextDouble();
			sc.nextLine();

			Account acc = new Account(number, holder, initial, limit);

			System.out.println();
			System.out.print("Enter amount for withdraw: ");
			double amount = sc.nextDouble();
			acc.withdraw(amount);

			System.out.println("New balance: " + String.format("%.2f", acc.getBalance()));

		} catch (DomainException e) {
			System.out.println(e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Wrong action.");
		}
		sc.close();
	}

}


