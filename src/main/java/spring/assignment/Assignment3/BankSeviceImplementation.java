package spring.assignment.Assignment3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class BankSeviceImplementation implements BankServices {

	Map<String, Bank> bankMap = new HashMap<>();

	@Override
	public List<String> getAllBranchs(String bankName) {
		List<String> branches = null;
		if (isBankExists(bankName)) {
			branches = new ArrayList<String>();
			Bank bank = bankMap.get(bankName);
			branches = bank.getBankBranchs();
		}
		return branches;
	}

	@Override
	public List<String> getAllServices(String bankName) {
		List<String> services = null;
		if (isBankExists(bankName)) {
			services = new ArrayList<String>();
			Bank bank = bankMap.get(bankName);
			services = bank.getBankServices();
		}
		return services;
	}

	@Override
	public void addBank(Bank bank) {
		String bankName = bank.getBankName();
		bankMap.put(bankName, bank);
	}

	public boolean isBankExists(String bankName) {
		return (bankMap.containsKey(bankName)) ? true : false;
	}

	@Override
	public Bank bankDetail(String bankName) {
		return (isBankExists(bankName))?bankMap.get(bankName):null;
	}

}
