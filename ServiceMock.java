package atm.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import atm.Service;

public class ServiceMock implements Service {

	private int balance;
	private String account;
	private double newvalue;
	private double updatevalue = balance + newvalue;
	
	@Override
	public int getAccountBalance(String account) {
		this.account = account;
		return balance;
	}

	public void setbalancetoreturn(int balance) {
		this.balance = balance;
		
	}

	public void verifyReceiveAccount(String account) {
		assertEquals(this.account, account);
		
	}

	public void persistAcountBalance(String account, double newvalue) throws Exception {
		if (newvalue < 0) {
			throw new Exception();
		}
		this.account = account;
		this.newvalue = newvalue;
		
		
	}


	public void verifypersistAcountBalance(String account, double newvalue) {
		assertEquals(account, this.account);
		assertEquals(newvalue, this.newvalue);
	}
	
	public void persistnewBalance(String account, double updatevalue) throws Exception {
		this.account = account;
		this.updatevalue = updatevalue;
		
		
	}
	
	public void updatepersistAcountBalance(String account, double updatevalue) {
		assertEquals(account, this.account);
		assertEquals(updatevalue, this.updatevalue);
	}

}
