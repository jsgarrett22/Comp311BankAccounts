/**
 * 
 */
package edu.franklin.firstbank;

import java.util.Scanner;

/**
 * BankSimulator.
 * 
 * @author J. David Fleig
 * @version August 2005
 */
public class BankSimulator 
{
    private Scanner in;
    private Bank bank;
    
    /**
     * Constructor for objects of class BankSimulator
     */
    public BankSimulator()
    {
        in = new Scanner(System.in);
        bank = new Bank();
        bank.readAccountsFromFile();
    }

    public void displayLoginMenu()
    {
        System.out.println();
        System.out.println();
        System.out.println("************************");
        System.out.println("** COMP 121 VirtuBank **");
        System.out.println("**                    **");
        System.out.println("** 1. New Account     **");
        System.out.println("** 2. Login           **");
        System.out.println("** 3. Exit            **");
        System.out.println("**                    **");
        System.out.println("************************");
    }
    public void displayUserMenu()
    {
        System.out.println();
        System.out.println();
        System.out.println("************************");
        System.out.println("** COMP 121 VirtuBank **");
        System.out.println("**                    **");
        System.out.println("** 1. Display Balance **");
        System.out.println("** 2. Deposit         **");
        System.out.println("** 3. Withdraw        **");
        System.out.println("** 4. Logout          **");
        System.out.println("**                    **");
        System.out.println("************************");
    }
    public void mainMenu(Account currentAccount)
    {
        while(true)
        {
           displayUserMenu();
           System.out.print("Selection: ");
           int selection = in.nextInt();
           if (selection==4)
            break;
           else if (selection==3)
            withdraw(currentAccount);
           else if (selection==2)
            deposit(currentAccount);
           else if (selection==1)
            balance(currentAccount);
        }
    }
    
    public void withdraw(Account currentAccount)
    {
        System.out.println();
        System.out.print("How much would you like to withdraw: $");
        double amnt = in.nextDouble();
        if (! currentAccount.withdraw(amnt))
        {
            System.out.println("I'm sorry that was an invalid amount.");
        }
    }
    public void deposit(Account currentAccount)
    {
        System.out.println();
        System.out.print("How much would you like to deposit: $");
        double amnt = in.nextDouble();
        if (! currentAccount.deposit(amnt))
        {
            System.out.println("I'm sorry that was an invalid amount.");
        }
    }
    public void balance(Account currentAccount)
    {
        System.out.println();
        System.out.println("Your current account balance is: $" + currentAccount.getBalance() );
        System.out.println();
    }
    
    public void newAccount()
    {
        System.out.print("Please enter your name: ");
        String name = in.next();
        System.out.print("Please enter initial balance: ");
        double amnt = in.nextDouble();
        System.out.print("Please enter your new pin: ");
        int pin = in.nextInt();
        Account currentAccount = bank.createAccount(name,amnt,pin);
        System.out.println("Your account has been made!");
        System.out.println("Your new account number is:" + currentAccount.getAccountId() );
        mainMenu(currentAccount);
    }
    
    public void login()
    {
        System.out.print("Please enter your account number: ");
        int accountId = in.nextInt();
        if (! bank.accountExists(accountId) )
        {
            System.out.println("I'm sorry, that account does not exist.");
            return;
        }
        System.out.print("Please enter your account pin: ");
        int pin = in.nextInt();
        Account currentAccount = bank.getAccount(accountId);
        if (pin!=currentAccount.getPin())
        {
            System.out.println("I'm sorry, your pin does not match that account.");
            return;
        }
        mainMenu(currentAccount);
    }
    
    public void run()
    {
       while(true)
       {
           displayLoginMenu();
           System.out.print("Selection: ");
           int selection = in.nextInt();
           if (selection==3)
            break;
           else if (selection==2)
            login();
           else if (selection==1)
            newAccount();
       }
       bank.saveAccountsToFile();
    }
    
    public static void main(String args[])
    {
        BankSimulator sim = new BankSimulator();
        sim.run();
    }

}
