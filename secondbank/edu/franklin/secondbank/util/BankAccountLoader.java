/**
 * 
 */
package edu.franklin.secondbank.util;

import java.util.Scanner;

import edu.franklin.secondbank.BankAccount;
import edu.franklin.secondbank.BankCustomer;
import edu.franklin.secondbank.Customer;
import edu.franklin.secondbank.Dollar;
import edu.franklin.secondbank.Money;
import edu.franklin.secondbank.SimpleBankAccount;

/**
 * @author fleigd
 *
 */
public class BankAccountLoader 
{
    public static BankAccount readAccount(Scanner in)
    {
        BankAccount temp = null;
        if (in.hasNextInt())
        {              
            int accountId = in.nextInt();
            double accountBal = in.nextDouble();
            String accountOwnerFirst = in.next();
            String accountOwnerLast = in.next();
            int accountPin = in.nextInt();
            temp = new SimpleBankAccount();
            temp.setAccountId(accountId);
            
            Customer c = new BankCustomer();
            c.setFirstName(accountOwnerFirst);
            c.setLastName(accountOwnerLast);
            c.setId("" + accountId);
            temp.setOwner(c);
            
            temp.setPin(accountPin);
            
            Money m = new Dollar(accountBal);
            temp.deposit(m);
        }
        return temp;
    }
    
}
