/**
 * 
 */
package edu.franklin.secondbank;

import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import edu.franklin.secondbank.util.BankAccountLoader;



/**
 * Write a description of class Bank here.
 * 
 * @author J. David Fleig
 * @version August 2005
 */
public class SecondBank 
{
    private ArrayList<BankAccount> accounts;
    private int nextAccountNumber;
    private FileReader reader;
    private Scanner in;
    private final static String FILENAME = "secondbankaccounts.txt";
    
    /**
     * Constructor for objects of class Bank
     */
    public SecondBank()
    {
        accounts = new ArrayList<BankAccount>();
        accounts.clear();
        nextAccountNumber=0;
    }
    
    
    /**
     * Read the known accounts from a file. Clear the accounts currently in the system first
     * 
     * @return true if and only if the operation is successfull
     */
    public boolean readAccountsFromFile()
    {
        try
        {
            reader = new FileReader(FILENAME);
            in = new Scanner(reader);
            BankAccount temp = null;
            do
            {
            	if (temp!=null)
            	{
            	    accounts.add(temp);
                    if (temp.getAccountId() >= nextAccountNumber)
                        nextAccountNumber = temp.getAccountId() + 1;
            	}
            	temp = BankAccountLoader.readAccount(in);
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
            	BankAccount temp = (BankAccount) accounts.get(i);
                out.println( temp.getAccountId() );
                out.println( temp.getBalance().asDouble() );
                out.println( temp.getOwner().getFirstName() );
                out.println( temp.getOwner().getLastName() );
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
    public BankAccount getAccount(int accountId)
    {
        int i=findAccount(accountId);
        if (i>=0)
            return (BankAccount) accounts.get(i);
        else
            return null;
    }
    
    /**
     * Create a new account at the bank
     * 
     * @return The new account that has been created 
     */
    public BankAccount createAccount(String firstName, String lastName, double initialBalance, int pin)
    {
    	BankAccount newAccount = new SimpleBankAccount();
        newAccount.setPin(pin);
        
        Customer c = new BankCustomer();
        c.setFirstName(firstName);
        c.setLastName(lastName);
        c.setId("" + nextAccountNumber);
        
        newAccount.setOwner(c);
        
        Money m = new Dollar(initialBalance);
        newAccount.deposit(m);

        newAccount.setAccountId(nextAccountNumber++);
        
        
        

        accounts.add(newAccount);
        return newAccount;
    }
    
    
    /**
     * Adds an account to the bank if there is no account with that id already existing
     * 
     * @return True if and only if the account is added.
     */
    public boolean addAccount(BankAccount a)
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
    public boolean accountExists(BankAccount a)
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
    private int findAccount(BankAccount a)
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
        	BankAccount temp = (BankAccount) accounts.get(i);
            if (temp.getAccountId()==accountId)
                return i;
        }
        return -1;
    }

}
