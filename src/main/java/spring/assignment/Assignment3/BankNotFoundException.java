package spring.assignment.Assignment3;

public class BankNotFoundException extends RuntimeException{

	public BankNotFoundException(String bankName) {
		super(bankName+" does not exist!");
	}
}
