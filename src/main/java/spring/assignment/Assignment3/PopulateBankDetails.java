package spring.assignment.Assignment3;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PopulateBankDetails implements CommandLineRunner {

	@Autowired
	BankServices bankSvcs; 
	
	private final Logger log = LoggerFactory.getLogger(PopulateBankDetails.class);
	
	@Override
	public void run(String... args) throws Exception {
		String bankName = "HDFC";
		
		//Branchs
		List<String> bankBranches = new ArrayList<>();
		bankBranches.add("EC");
		bankBranches.add("SJP");
		bankBranches.add("BTM");
		bankBranches.add("WHITE FIELD");
		bankBranches.add("BELANDUR");
		bankBranches.add("JAI NAGAR");
		
		//Bank Services
		List<String> bankServices = new ArrayList<>();
		bankServices.add("Home Loan");
		bankServices.add("No cost EMI");
		bankServices.add("Education Loan");
		bankServices.add("Life encuarence");
		
		Bank bank1 = new Bank(bankName, bankServices, bankBranches);
		bankSvcs.addBank(bank1);
		log.info("-----------------------------------");
		log.info(bank1+"");
		
	}

	
	
}
