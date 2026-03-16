package main;

import dao.AccountDAO;
import model.Account;

import java.util.Scanner;

public class BankAPP {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AccountDAO dao = new AccountDAO();

        while (true) {

            System.out.println("\n--- BANK SYSTEM ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Account Number: ");
                    int accNo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Holder Name: ");
                    String name = sc.nextLine();

                    System.out.print("Initial Balance: ");
                    double balance = sc.nextDouble();

                    Account acc = new Account(accNo, name, balance);

                    dao.createAccount(acc);
                    break;

                case 2:
                    System.out.print("Account Number: ");
                    accNo = sc.nextInt();

                    System.out.print("Amount: ");
                    double deposit = sc.nextDouble();

                    dao.deposit(accNo, deposit);
                    break;

                case 3:
                    System.out.print("Account Number: ");
                    accNo = sc.nextInt();

                    System.out.print("Amount: ");
                    double withdraw = sc.nextDouble();

                    dao.withdraw(accNo, withdraw);
                    break;

                case 4:
                    System.out.print("Account Number: ");
                    accNo = sc.nextInt();

                    dao.checkBalance(accNo);
                    break;

                case 5:
                    System.out.println("Thank you!");
                    System.exit(0);
            }
        }
    }
}