package com.priceminister.account;


import static org.junit.Assert.*;

import org.junit.*;

import com.priceminister.account.implementation.*;


/**
 * Please create the business code, starting from the unit tests below.
 * Implement the first test, the develop the code that makes it pass.
 * Then focus on the second test, and so on.
 * 
 * We want to see how you "think code", and how you organize and structure a simple application.
 * 
 * When you are done, please zip the whole project (incl. source-code) and send it to recrutement-dev@priceminister.com
 * 
 */
public class CustomerAccountTest {
    
    Account customerAccount;
    AccountRule rule;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        customerAccount = new CustomerAccount();
    }
    
     @Test
     public void testAccountWithoutMoneyHasZeroBalance() {
        Double balance = customerAccount.getBalance();
        Assert.assertEquals("0.0",balance);
        Assert.assertNotNull(balance);
     }
     

     @Test
     public void testAddPositiveAmount() {

        Double formerAccount = customerAccount.getBalance();
        Double addAmount = 50.0;
        customerAccount.add(addAmount);
        Double somme = formerAccount+addAmount;
        Assert.assertEquals(somme,customerAccount.getBalance());
     }
     

     @Test
     public void testWithdrawAndReportBalanceIllegalBalance() {
        customerAccount.add(50.0);
        try {
			customerAccount.withdrawAndReportBalance(70.0,rule);
			fail("IllegalBalanceException");
		} catch (IllegalBalanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}       
     }
     
     // Also implement missing unit tests for the above functionalities.
}
