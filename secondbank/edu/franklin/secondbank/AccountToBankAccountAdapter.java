package edu.franklin.secondbank;

import edu.franklin.firstbank.Account;

/**
 * Adapter class that allows the legacy Account interface to be compatible with
 * the BankAccount interface utilizing the Adapter design pattern. This is my representation
 * of this implementation.
 * @author Joshua S. Garrett
 */
public class AccountToBankAccountAdapter implements BankAccount {

	/*
	 * Adaptee interface reference
	 */
    private Account parent;
    
    /*
     * Default Constructor
     */
    public AccountToBankAccountAdapter(Account parent) {
    	this.parent = parent;
    }

	@Override
	public void setPin(int pin) {
		parent.setPin(pin);
	}

	@Override
	public int getPin() {
		return parent.getPin();
	}

	@Override
	public void setOwner(Customer owner) {
		parent.setOwner(owner);
	}

	@Override
	public Customer getOwner() {
		// return owner (String)
		Customer cust = new Customer(parent.getOwner());
		return null;
	}

	@Override
	public void setAccountId(int accountId) {
		parent.setAccountId(accountId);
	}

	@Override
	public int getAccountId() {
		return parent.getAccountId();
	}

	@Override
	public boolean deposit(Money amount) {
		// if amount > 0
			// balance += amount
			// return true
		return false;
	}

	@Override
	public boolean withdraw(Money amount) {
		// if amount < 0
			// return false
		// if balance < amount
			// return false
		// balance -= amount
		// return true
		return false;
	}

	@Override
	public Money getBalance() {
		// return balance (double)
		return null;
	}
}
