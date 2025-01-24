/**
 * 
 */
package edu.franklin.secondbank;

/**
 * @author fleigd
 *
 */
public interface BankAccount 
{
/**
     * Sets the pin for the Account
     * 
     * @param pin - The new pin
     */
    void setPin(int pin);
    
   /**
     * Gets the pin
     * 
     * @return The pin for the account
     */
    int getPin();
    
    /**
     * Sets the owner for the Account
     * 
     * @param owner - The owner
     */
    void setOwner(Customer owner);

    /**
     * Gets the owner for the Account
     * 
     * @return The owner
     */
    Customer getOwner();
    
    /**
     * Sets the accountId for the Account
     * 
     * @param accountId - The account id
     */
    void setAccountId(int accountId);
    
   /**
     * Gets the account id
     * 
     * @return The account id
     */
    int getAccountId();
    
    /**
     * Deposits money into the account
     * 
     * @param amount - The new amount to deposit
     * @return true if and only if (amount>0)
     */
    boolean deposit(Money amount);
    
    /**
     * Withdraws money into the account
     * 
     * @param amount - The new amount to withdraw
     * @return true if and only if (amount>0) and (balance >= amount)
     */
    boolean withdraw(Money amount);
    
    /**
     * Gets the balance of the account
     * 
     * @return The current balance
     */
    Money getBalance();
}
