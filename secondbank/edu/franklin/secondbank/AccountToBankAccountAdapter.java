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
		parent.setOwner(owner.getFirstName() + " " + owner.getLastName());
	}

	@Override
	public Customer getOwner() {
		// split owner name into first and last
		String temp = "\s";
		String[] names = parent.getOwner().split(temp);
		
		// create a new customer and set first and last names
		Customer customer = new BankCustomer();
		customer.setFirstName(names[0]);
		customer.setLastName(names[1]);
		return customer;
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
