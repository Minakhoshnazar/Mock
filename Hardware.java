package atm;

public interface Hardware {

	String getAccountNumberFromCard(String password);



	void pay(double withdrawvalue);



	double readEnvelope(double depositvalue);



	double readEnvelope();






	




	

}