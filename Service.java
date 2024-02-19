package atm;

public interface Service {

	int getAccountBalance(String account);

	void persistAcountBalance(String accountNumber, double updatevalue) throws Exception;

	

}