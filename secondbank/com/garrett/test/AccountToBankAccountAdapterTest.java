package com.garrett.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.franklin.firstbank.SimpleAccount;
import edu.franklin.secondbank.AccountToBankAccountAdapter;
import edu.franklin.secondbank.BankCustomer;
import edu.franklin.secondbank.Customer;
import edu.franklin.secondbank.Dollar;

class AccountToBankAccountAdapterTest {

	@Test
	void testAccountToBankAccountAdapter() {
		AccountToBankAccountAdapter adapter = new AccountToBankAccountAdapter(
				new SimpleAccount());
		assertNotNull(adapter);
	}

	@Test
	void testSetPin() {
		AccountToBankAccountAdapter adapter = new AccountToBankAccountAdapter(
				new SimpleAccount());
		adapter.setPin(1234);
		assertEquals(1234, adapter.getPin());
	}

	@Test
	void testGetPin() {
		AccountToBankAccountAdapter adapter = new AccountToBankAccountAdapter(
				new SimpleAccount());
		adapter.setPin(1234);
		assertEquals(1234, adapter.getPin());
	}

	@Test
	void testSetOwner() {
		AccountToBankAccountAdapter adapter = new AccountToBankAccountAdapter(
				new SimpleAccount());
		Customer bc = new BankCustomer();
		bc.setFirstName("John");
		bc.setLastName("Doe");
		adapter.setOwner(bc);
		Customer customer = adapter.getOwner();
		assertNotNull(customer);
		assertEquals("John", customer.getFirstName());
		assertEquals("Doe", customer.getLastName());
	}

	@Test
	void testGetOwner() {
		AccountToBankAccountAdapter adapter = new AccountToBankAccountAdapter(
				new SimpleAccount());
		Customer bc = new BankCustomer();
		bc.setFirstName("John");
		bc.setLastName("Doe");
		adapter.setOwner(bc);
		Customer customer = adapter.getOwner();
		assertNotNull(customer);
		assertEquals("John", customer.getFirstName());
		assertEquals("Doe", customer.getLastName());
	}

	@Test
	void testSetAccountId() {
		AccountToBankAccountAdapter adapter = new AccountToBankAccountAdapter(
				new SimpleAccount());
		adapter.setAccountId(007);
		assertEquals(007, adapter.getAccountId());
	}

	@Test
	void testGetAccountId() {
		AccountToBankAccountAdapter adapter = new AccountToBankAccountAdapter(
				new SimpleAccount());
		adapter.setAccountId(007);
		assertEquals(007, adapter.getAccountId());
	}

	@Test
	void testDeposit() {
		AccountToBankAccountAdapter adapter = new AccountToBankAccountAdapter(
				new SimpleAccount());
		assertEquals(new Dollar(0.00), adapter.getBalance());
		
		// Add positive value
		assertTrue(adapter.deposit(new Dollar(10.00)));
		assertEquals(new Dollar(10.00), adapter.getBalance());
		
		// Add negative value, balance should remain the same
		assertFalse(adapter.deposit(new Dollar(-10.00)));
		assertEquals(new Dollar(10.00), adapter.getBalance());
	}

	@Test
	void testWithdraw() {
		AccountToBankAccountAdapter adapter = new AccountToBankAccountAdapter(
				new SimpleAccount());
		assertEquals(new Dollar(0.00), adapter.getBalance());
		
		// Try withdrawing positive value, more than current balance, which leaves balance unaffected
		assertFalse(adapter.withdraw(new Dollar(10.00)));
		assertEquals(new Dollar(0.00), adapter.getBalance());
		
		// Try withdrawing negative value
		assertFalse(adapter.withdraw(new Dollar(-10.00)));
		assertEquals(new Dollar(0.00), adapter.getBalance());
		
		// try withdrawing a positive value, less than current balance, affecting balance
		adapter.deposit(new Dollar(10.00));
		assertTrue(adapter.withdraw(new Dollar(2.50)));
		assertEquals(new Dollar(7.50), adapter.getBalance());
	}

	@Test
	void testGetBalance() {
		// Test new, empty balance
		AccountToBankAccountAdapter adapter = new AccountToBankAccountAdapter(
				new SimpleAccount());
		assertEquals(new Dollar(0.00), adapter.getBalance());
	}

}
