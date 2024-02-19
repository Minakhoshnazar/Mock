package atm.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import atm.ATM;



class TestATM {

	@Test
	void SuccessfulLogin() {
		MockHardware hardMock = new MockHardware();
		ATM atm = new ATM(hardMock, null);
		hardMock.setAccounttobereturned("555777");
		String msg = atm.login("12345");
		assertEquals("Logged in succesfully in account 555777", msg);
		hardMock.VerifyPassword("12345");
		
	}

	@Test
	void failedLogin() {
		MockHardware hardMock = new MockHardware();
		ATM atm = new ATM(hardMock, null);
		hardMock.faillogin();
		String msg = atm.login("12346");
		assertEquals("Login failed", msg);
		
	}
	
	@Test
	void getBalance() {
		MockHardware hardMock = new MockHardware();
		ATM atm = new ATM(hardMock, null);
		ServiceMock serviceMock = new ServiceMock();
		atm.setService(serviceMock);
		hardMock.setAccounttobereturned("555777");
		serviceMock.setbalancetoreturn(1000);
		String message = atm.balance("12345");
		serviceMock.verifyReceiveAccount("555777");
		assertEquals("Your balance is 1000", message);
		
	}
	
	@Test
	void withdraw() throws Exception {
		MockHardware hardMock = new MockHardware();
		ServiceMock serviceMock = new ServiceMock();
		hardMock.setAccounttobereturned("555777");
		serviceMock.setbalancetoreturn(1000);
		ATM atm = new ATM(hardMock, serviceMock);
		String withdrawvalue = atm.withdraw("12345", 100);
		hardMock.verifypayment(100);
		serviceMock.persistAcountBalance("555777", 900);
		assertEquals("successfully withdraw100.0", withdrawvalue);
		
	}
	
	@Test
	void deposit() throws Exception {
		MockHardware hardMock = new MockHardware();
		ServiceMock serviceMock = new ServiceMock();
		hardMock.setAccounttobereturned("555777");
		serviceMock.setbalancetoreturn(1000);
		ATM atm = new ATM(hardMock, serviceMock);
		String depsitvalue = atm.deposit("555777");
		hardMock.verifyreadEnvelope();
		assertEquals("successfully deposited100.0", depsitvalue);
		
	}


}
