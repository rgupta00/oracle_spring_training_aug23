package com.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



//@Controller // vs @Controller
//@ResponseBody
/*
 * @RestController=	@Controller+	@ResponseBody(trigger the passer to convert java object to json
 */
@RestController
public class AccountController {

	@GetMapping(path = "accounts")
	public List<Account> getAll(){
		List<Account> accounts=new ArrayList<>();
		accounts.add(new Account(1, "raj", 1000));
		accounts.add(new Account(2, "ekta", 1000));
		
		return accounts;
	}
}
