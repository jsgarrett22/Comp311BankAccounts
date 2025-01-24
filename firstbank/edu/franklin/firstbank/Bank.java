/**
 * 
 */
package edu.franklin.firstbank;

import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import edu.franklin.firstbank.util.AccountLoader;



/**
 * Write a description of class Bank here.
 * 
 * @author J. David Fleig
 * @version August 2005
 */
public class Bank 
{
    private ArrayList<Account> accounts;
    private int nextAccountNumber;
    private FileReader reader;
    private Scanner in;
    private final static String FILENAME = "bankaccounts.txt";
    
    /**
     * Constructor for objects of class Bank
     */
    public Bank()
    {
        accounts = new ArrayList<Account>();
        nextAccountNumber=0;
    }
    
    /**
     * Read the known accounts from a file. Clear the accounts currently in the system first
     * 
     * @return true if and only if the operation is successfull
     */
    public boolean readAccountsFromFile()
    {
    	accounts.clear();
        
        try
        {
            reader = new FileReader(FILENAME);
            in = new Scanner(reader);
            Account temp = null;
            do
            {
            	if (temp!=null)
            	{
            		 accounts.add(temp);
                     if (temp.getAccountId() >= nextAccountNumber)
                         nextAccountNumber = temp.getAccountId() + 1;
            	}
            	temp = AccountLoader.readAccount(in);
            }
            while (temp!=null);
            
           
            reader.close();
        }
        catch(Exception fnf)
        {
            fnf.printStackTrace();
            return false;
        }
        
        
        return true;

    }
    /**
     * Write the current accounts out to a file
     * 
     * @return true if and only if the operation is successfull
     */
    public boolean saveAccountsToFile()
    {
        //TODO: To be filled in
    	try
        {
            PrintWriter out = new PrintWriter(FILENAME);
            for (int i=0; i < accounts.size() ; i++)
            {
                Account temp = (Account) accounts.get(i);
                out.println( temp.getAccountId() );
                out.println( temp.getBalance() );
                out.println( temp.getOwner() );
                out.println( temp.getPin() );
            }       
            out.close();
        }
        catch(Exception fnf)
        {
            fnf.printStackTrace();
            return false;
        }
        return true;

    }
    
    
   /**
     * Get the account corresponding to the given accountId
     * 
     * @return The account if it is exists, null if it cannot be found
     */
    public Account getAccount(int accountId)
    {
        int i=findAccount(accountId);
        if (i>=0)
            return (Account) accounts.get(i);
        else
            return null;
    }
    
    /**
     * Create a new account at the bank
     * 
     * @return The new account that has been created 
     */
    public Account createAccount(String name, double initialBalance, int pin)
    {
        Account newAccount = new SimpleAccount();
        newAccount.setPin(pin);
        newAccount.setOwner(name);
        newAccount.deposit(initialBalance);
        newAccount.setAccountId(nextAccountNumber++);
        accounts.add(newAccount);
        return newAccount;
    }
    
    
    /**
     * Adds an account to the bank if there is no account with that id already existing
     * 
     * @return True if and only if the account is added.
     */
    public boolean addAccount(Account a)
    {
        if (a==null)
            return false;
        if (findAccount(a)>=0)
            return false;
        accounts.add(a);
        return true;
    }
    
    /**
     * Checks to see if an account already exists.
     * 
     * @param a - the Account
     * @return true if and only if the account exists
     */
    public boolean accountExists(Account a)
    {
        return (findAccount(a)>=0);
    }
   /**
     * Checks to see if an account already exists.
     * 
     * @param id - the id of the account
     * @return true if and only if the account exists
     */
    public boolean accountExists(int id)
    {
        return (findAccount(id)>=0);
    }
    /**
     * Finds the position of the account in the bank
     * 
     * @param a - the account to look up
     * @return The position in the ArrayList if the account exists. -1 if it does not
     */
    private int findAccount(Account a)
    {
       if (a==null)
        return -1;
       else
        return findAccount(a.getAccountId());
    }
    
    /**
     * Finds the position of the account in the bank
     * 
     * @param accountId - The account id to look up
     * @return The position in the ArrayList if the account exists. -1 if it does not
     */
    private int findAccount(int accountId)
    {
        for (int i=0; i < accounts.size() ; i++)
        {
            Account temp = (Account) accounts.get(i);
            if (temp.getAccountId()==accountId)
                return i;
        }
        return -1;
    }

}
