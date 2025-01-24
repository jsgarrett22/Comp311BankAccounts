/**
 * 
 */
package edu.franklin.firstbank;

/**
 * SimpleAccount.
 * 
 * @author J. David Fleig 
 * @version August 2005
 */
public class SimpleAccount implements Account 
{
    private String _owner;
    private int _accountId;
    private double _balance;
    private int _pin;

    /**
     * Constructor for objects of class Account
     */
    public SimpleAccount()
    {

    }

    public String toString()
    {
        return "" + _accountId + ":" + _owner + ":" + _balance;
    }
    /**
     * Sets the pin for the Account
     * 
     * @param pin - The new pin
     */
    public void setPin(int pin)
    {
        _pin = pin;
    }
   /**
     * Gets the pin
     * 
     * @return The pin for the account
     */
    public int getPin()
    {
        return _pin;
    }
    /**
     * Sets the owner for the Account
     * 
     * @param owner - The owner
     */
    public void setOwner(String owner)
    {
        _owner = owner;
    }
    public String getOwner()
    {
        return _owner;
    }
    /**
     * Sets the accountId for the Account
     * 
     * @param accountId - The account id
     */
    public void setAccountId(int accountId)
    {
        _accountId = accountId;
    }
   /**
     * Gets the account id
     * 
     * @return The account id
     */
    public int getAccountId()
    {
        return _accountId;
    }
    /**
     * Deposits money into the account
     * 
     * @param amount - The new amount to deposit
     * @return true if and only if (amount>0)
     */
    public boolean deposit(double amount)
    {
        if (amount>0)
        {
            _balance += amount;
            return true;
        }
        return false;
    }
    /**
     * Withdraws money into the account
     * 
     * @param amount - The new amount to withdraw
     * @return true if and only if (amount>0) and (balance >= amount)
     */
    public boolean withdraw(double amount)
    {
        if (amount<0)
            return false;
        if (_balance < amount)
            return false;
       
        _balance -= amount;
        return true;
    }
    /**
     * Gets the balance of the account
     * 
     * @return The current balance
     */
    public double getBalance()
    {
        return _balance;
    }

}
