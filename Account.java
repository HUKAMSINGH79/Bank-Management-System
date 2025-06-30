package com.elevatelabs;

import java.util.ArrayList;
import java.util.Scanner;

public class Account {
	String name;
	double balance;
	ArrayList<String> transactions;

	public Account(String name, double initialbalance) {
		super();
		this.name = name;
		this.balance = initialbalance;
		this.transactions = new ArrayList<>();
	}

	void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
			transactions.add("Deposited ₹ " + amount);
			System.out.println("Deposited ₹ " + amount);
		} else {
			System.out.println("Enter a valid amount");
		}
	}

	void withdraw(double amount) {
		if (amount > 0 && amount <= balance) {
			balance -= amount;

			transactions.add("Withdrew ₹" + amount);
			System.out.println("Withdrew ₹" + amount);
		} else {
			System.out.println("Invalid amount of insuficient balance");
		}
	}

	void showBalance() {
		System.out.println("Balance: ₹" + balance);

	}

	void showTransaction() {
		System.out.println("Trancsaction History: ");
		if (transactions.isEmpty()) {
			System.out.println("No transactions yet.");
		} else {
			for (String t : transactions) {
				System.out.println("- " + t);
			}
		}
	}

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter your Name: ");
		String name = sc.nextLine();

		System.out.println("Enter opening balance: ₹");
		double balance = sc.nextDouble();

		Account account = new Account(name, balance);

		int choice;
		do {
			System.out.println("\n-----------Bank Account Management---------------");
			System.out.println("\n1. Deposit.\n2. Withdraw\n3. Check Balance.\n4. View Transactions\n5. Exit");
			System.out.println("Enter your choice: ");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Enter deposit amount: ₹");
				account.deposit(sc.nextDouble());
				break;

			case 2:
				System.out.println("Enter withdraw amount: ₹");
				account.withdraw(sc.nextDouble());
				break;

			case 3:
				account.showBalance();
				break;

			case 4:
				account.showTransaction();
				break;

			case 5:
				System.out.println("Goodbye!");
				break;

			default:
				System.out.println("Invalid option.");
			}
		} while (choice != 5);

		sc.close();
	}
}
