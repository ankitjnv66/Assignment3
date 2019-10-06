package spring.assignment.Assignment3;

import java.util.List;

public interface BankServices {

	List<String> getAllBranchs(String bankName);

	List<String> getAllServices(String bankName);

	void addBank(Bank bank);

	boolean isBankExists(String bankName);
	
	Bank bankDetail(String bankName);

}
