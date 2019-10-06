package spring.assignment.Assignment3;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/bank")
public class BankController {

	@Autowired
	BankServices bankSvcs;

	@RequestMapping(value = "/getBranchs/{bankName}")
	public ModelAndView getBankBranches(@PathVariable String bankName) {

		ModelAndView mav = new ModelAndView();
		List<String> branches = new ArrayList<String>();
		branches = bankSvcs.getAllBranchs(bankName);
		mav.setViewName("branches");
		mav.addObject("bankName", bankSvcs.bankDetail(bankName).getBankName());
		mav.addObject("branches", branches);
		return mav;
	}

	@RequestMapping(value = "/getServices/{bankName}")
	@ResponseBody
	public ModelAndView getAllServices(@PathVariable String bankName) {
		ModelAndView mav = new ModelAndView();
		List<String> services = new ArrayList<String>();
		if (bankSvcs.getAllServices(bankName) != null) {
			services = bankSvcs.getAllServices(bankName);
			mav.setViewName("services");
			mav.addObject("bankName", bankSvcs.bankDetail(bankName).getBankName());
			mav.addObject("services", services);
			return mav;
		} else {
			throw new BankNotFoundException(bankName);
		}
	}

	@RequestMapping("/bankDetail/{bankName}")
	@ResponseBody
	public Bank getBankDetail(@PathVariable String bankName) {
		if (bankSvcs.bankDetail(bankName) != null)
			return bankSvcs.bankDetail(bankName);
		throw new BankNotFoundException(bankName);
	}
}
