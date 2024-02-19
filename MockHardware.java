package atm.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import atm.Hardware;

public class MockHardware implements Hardware {
	
	private String account;
	private String password;
	public boolean shouldFail = false;
	private double withdrawvalue;
	private double depositvalue;

	public void setAccounttobereturned(String inputAccount) {
		this.account = inputAccount;
		
	}

	public void VerifyPassword(String expectedPassword) {
		assertEquals(expectedPassword, this.password, "The password inserted is not" + expectedPassword);
	}
	
	@Override
	public String getAccountNumberFromCard(String password) {
		if (shouldFail) {
			throw new RuntimeException();
		}
		this.password = password;
		
		return account;
	}

	public void faillogin() {
		shouldFail = true;
		
	}


	@Override
	public void pay(double withdrawvalue) {
		this.withdrawvalue = withdrawvalue;
	}
		

	
    public void verifypayment(double withdrawvalue) {
    	assertEquals(withdrawvalue, this.withdrawvalue);
    }
    
    @Override
	public double readEnvelope() {
		return depositvalue;
	}
    
    public void verifyreadEnvelope() {
		assertEquals(this.depositvalue,depositvalue);
		
	}

	@Override
	public double readEnvelope(double depositvalue) {
		return 0;
	}

	
}
