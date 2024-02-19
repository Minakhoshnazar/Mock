package atm;

import atm.test.ServiceMock;

public class ATM {
	
	Hardware hardware;
    Service service;


	public ATM(Hardware hardware, Service service) {
		this.hardware = hardware;
		this.service = service;
	
	}

	public String login(String password) {
	  
		String accountNumber;
		try {
			accountNumber = hardware.getAccountNumberFromCard(password);
		} catch (Exception e) {
			return "Login failed";
		}
	   return "Logged in succesfully in account " + accountNumber;
		
	}

	public void setService(Service service) {
		this.service = service;
		
	}

	public String balance(String password) {
		String accountNumber = hardware.getAccountNumberFromCard(password);
		int balance = service.getAccountBalance(accountNumber);
		return "Your balance is " + balance;
	}

	public String withdraw(String password, double withdrawvalue) throws Exception {
		String accountNumber = hardware.getAccountNumberFromCard(password);
		int balance = service.getAccountBalance(accountNumber);
		if (balance > 0) {
		hardware.pay(withdrawvalue);
		}
		service.persistAcountBalance(accountNumber, balance-withdrawvalue);
		return "successfully withdraw" + withdrawvalue;
	}

	public String deposit(String accountNumber) throws Exception {
		int balance = service.getAccountBalance(accountNumber);
		double depositvalue = 100.0;
		hardware.readEnvelope(depositvalue);
		service.persistAcountBalance(accountNumber, balance+depositvalue);
		return "successfully deposited" + depositvalue;
	}




}
