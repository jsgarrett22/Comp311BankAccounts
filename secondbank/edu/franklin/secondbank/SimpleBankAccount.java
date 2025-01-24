/**
 * 
 */
package edu.franklin.secondbank;

/**
 * SimpleAccount.
 * 
 * @author J. David Fleig 
 * @version August 2005
 */
public class SimpleBankAccount implements BankAccount 
{
    private Customer _owner;
    private int _accountId;
    private Money _balance;
    private int _pin;

    /**
     * Constructor for objects of class Account
     */
    public SimpleBankAccount()
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
    public void setOwner(Customer owner)
    {
        _owner = owner;
    }
    public Customer getOwner()
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
    public boolean deposit(Money amount)
    {
        if (amount.asDouble() > 0.0)
        {
            _balance = _balance.add(amount);
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
    public boolean withdraw(Money amount)
    {
        if (amount.asDouble() < 0.0)
            return false;
        
        if (_balance.compareTo(amount) < 0)
            return false;
       
        _balance = _balance.sub(amount);
        return true;
    }
    /**
     * Gets the balance of the account
     * 
     * @return The current balance
     */
    public Money getBalance()
    {
        return _balance;
    }

}
