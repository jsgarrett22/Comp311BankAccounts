/**
 * 
 */
package edu.franklin.firstbank.util;

import java.util.Scanner;

import edu.franklin.firstbank.Account;
import edu.franklin.firstbank.SimpleAccount;

/**
 * @author fleigd
 *
 */
public class AccountLoader 
{
    public static Account readAccount(Scanner in)
    {
        Account temp = null;
        if (in.hasNextInt())
        {              
            int accountId = in.nextInt();
            double accountBal = in.nextDouble();
            String accountOwner = in.next();
            int accountPin = in.nextInt();
            temp = new SimpleAccount();
            temp.setAccountId(accountId);
            temp.setOwner(accountOwner);
            temp.setPin(accountPin);
            temp.deposit(accountBal);
        }
        return temp;
    }
}
