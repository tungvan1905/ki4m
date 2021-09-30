package com.vti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vti.entity.Account;
import com.vti.service.AccountService;


@Controller
public class AccountController {
 
    @Autowired
    private AccountService accountService;
	
	@RequestMapping("/1")
	public String viewHomePage(Model model) {
	    List<Account> listAccounts = accountService.listAll();
	    model.addAttribute("listAccounts", listAccounts);
	     
	    return "index1";
	}
	@RequestMapping("/new1")
	public String showNewAccountPage(Model model) {
		Account account = new Account();
	    model.addAttribute("account", account);
	     
	    return "new_account";
	}
	
	@RequestMapping(value = "/save1", method = RequestMethod.POST)
	public String saveAccount(@ModelAttribute("account") Account account) {
		accountService.save(account);
	     
	    return "redirect:/";
	}
	
	@RequestMapping("/edit1/{id}")
	public ModelAndView showEditAccountPage(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("edit_account");
	    Account account = accountService.get(id);
	    mav.addObject("account", account);
	     
	    return mav;
	}
	
	@RequestMapping("/delete1/{id}")
	public String deleteAccount(@PathVariable(name = "id") int id) {
		accountService.delete(id);
	    return "redirect:/";       
	}
    // handler methods...
}