package spring.assignment.Assignment3;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Bank {

	String bankName;
	List<String> bankServices;
	List<String> bankBranchs;

	public Bank() {

	}

	public Bank(String bankName, List<String> bankServices, List<String> bankBranchs) {
		super();
		this.bankName = bankName;
		this.bankServices = bankServices;
		this.bankBranchs = bankBranchs;
	}

	public String getBankName() {
		return bankName;
	}

	public List<String> getBankServices() {
		return bankServices;
	}

	public List<String> getBankBranchs() {
		return bankBranchs;
	}

	@Override
	public String toString() {
		return "Bank [bankName=" + bankName + ", bankServices=" + bankServices + ", bankBranchs=" + bankBranchs + "]";
	}

	


}
