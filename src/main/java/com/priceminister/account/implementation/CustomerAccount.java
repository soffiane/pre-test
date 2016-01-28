package com.priceminister.account.implementation;

import com.priceminister.account.*;


public class CustomerAccount implements Account {
	
	Double balance;
	
	public CustomerAccount(){
		balance = 0.0;
	}
	

    public void add(Double addedAmount) {
        this.balance += addedAmount;
    }

    public Double getBalance() {
        return balance;
    }

    public Double withdrawAndReportBalance(Double withdrawnAmount, AccountRule rule) 
    		throws IllegalBalanceException {
    	Double resultingAccountBalance = balance-withdrawnAmount;
        boolean newBalance = rule.withdrawPermitted(resultingAccountBalance);
        if(!newBalance){
        	throw new IllegalBalanceException(resultingAccountBalance);
        }
        return resultingAccountBalance;
    }

}
