package src;

import java.util.Scanner;

public class Bank {

    static int tries = 3;   // This is the total number of tries you have before being temporarily locked out of your account.
    static double balance = 0; // This is your starting account balance.

    public static void main(String[] args) { // This is the creation of your account.

        System.out.println("Welcome user, what is your name?");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();

        System.out.println("\nWelcome " + name + ". Please set up an account username and password: ");
        System.out.print("Username: ");
        Scanner user = new Scanner(System.in);
        String username = user.nextLine();

        System.out.print("Password: ");
        Scanner pass = new Scanner(System.in);
        String password = pass.nextLine();

        Login(name, username, password);
        input.close();
        user.close();
        pass.close();
    }

    static void Login(String name, String username, String password) { // This is the secure login page before accessing your account details.

        System.out.println("\n---LOGIN PAGE--- ");
        System.out.println("Please enter your username: ");
        Scanner check1 = new Scanner(System.in);
        String check11 = check1.nextLine();

        System.out.println("Please enter your password: ");
        Scanner check2 = new Scanner(System.in);
        String check22 = check2.nextLine();

        if (check11.equals(username) && check22.equals(password)) { // If the username and password of your account match your response, it will bring you to your account page.
            Account(name, username, password);
        }else { // If account credentials are incorrect, this nested if statement will run.
            tries--;
            if (tries == 0) { // If the tries variable matches 0, the account will go into lockdown.
                lockdown(name, username, password);
            }else { // If the user still has attempts to login, it will prompt them the login page again.
                
                System.out.println("\nIncorrect username and/or password, you have " + tries + " attempt(s) left.");

                try {
                    Thread.sleep(6 * 1000);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                
                }
                Login(name, username, password);
            }
        }
        check1.close();
        check2.close();
    }

    static void lockdown(String name, String username, String password) { // This is the lockdown method. Pauses program for 30 seconds.
        System.out.println("\n--------------------------------------");
        System.out.println("You're account has been locked for 30 seconds due to a multitude of incorrect loggin tries.\n");
        System.out.println("Please wait until the lockdown period is over before logging in again.");
        System.out.println("--------------------------------------");
        try {
            Thread.sleep(30 * 1000);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        
        }
        Login(name, username, password);
    }

        static void Account(String name, String username, String password) { // If the login information is correct, this is the account page the user will be brought to.

        System.out.println("\n--------------------------------------");
        System.out.println("Welcome " + name +  "! Please choose an option:\n");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Quit");
        System.out.println("--------------------------------------");

        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();

        if (choice == 1) {
            balance(name, username, password);
        }else if (choice == 2) {
            deposit(name, username, password);
        }else if (choice == 3) {
            withdraw(name, username, password);
        }else {
            quit(name, username, password);
        }
        input.close();
    }

    static void balance(String name, String username, String password) { // Here, the user can check their account balance without doing anything to their account.

        System.out.println("\n--------------------------------------");
        System.out.println("Welcome " + name + ". Here is your total account balance: $" + balance);

        System.out.println("\nGo back to main menu?");
        System.out.println("1. Yes");
        System.out.println("--------------------------------------");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();

        if (choice == 1) {
            Account(name, username, password);
        }
        input.close();
    }


    static void deposit(String name, String username, String password) { // Here, the user can add money to their account.

        System.out.println("\n--------------------------------------");
        System.out.println("How much would you like to add to your current balance of $" + balance + "?");
        Scanner add = new Scanner(System.in);
        double adding = add.nextDouble();

        balance = balance + adding;

        System.out.println("\nYour funds have been added! Your new balance is $" + balance);

        System.out.println("\nGo back to main menu?");
        System.out.println("1. Yes");
        System.out.println("2. Add more");
        System.out.println("--------------------------------------");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();

        if (choice == 1) {
            Account(name, username, password);
        }else {
            deposit(name, username, password);
        }
        input.close();
        add.close();
    }

    static void withdraw(String name, String username, String password) { // Here, the user can remove money to their account.

        System.out.println("\n--------------------------------------");
        System.out.println("How much would you like to withdraw from your current balance of $" + balance + "?");
        Scanner remove = new Scanner(System.in);
        double removing = remove.nextDouble();

        balance = balance - removing;

        System.out.println("\nYour funds have been withdrawed! Your new balance is $" + balance);

        System.out.println("\nGo back to main menu?");
        System.out.println("1. Yes");
        System.out.println("2. Withdraw more");
        System.out.println("--------------------------------------");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();

        if (choice == 1) {
            Account(name, username, password);
        }else {
            withdraw(name, username, password);
        }
        input.close();
        remove.close();
    }

    static void quit(String name, String username, String password) { // This brings the user back to the login page.

        System.out.println("Logging out!");

        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        
        }
        Login(name, username, password);
    }

}
