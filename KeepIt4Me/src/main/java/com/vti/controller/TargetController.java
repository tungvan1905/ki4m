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

import com.vti.entity.Target;
import com.vti.service.TargetService;


@Controller
public class TargetController {
 
    @Autowired
    private TargetService targetservice;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
	    List<Target> listTargets = targetservice.listAll();
	    model.addAttribute("listTargets", listTargets);
	     
	    return "index";
	}
	@RequestMapping("/new")
	public String showNewTargetPage(Model model) {
		Target target = new Target();
	    model.addAttribute("target", target);
	     
	    return "new_target";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveTarget(@ModelAttribute("target") Target target) {
		targetservice.save(target);
	     
	    return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditTargetPage(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("edit_target");
	    Target target = targetservice.get(id);
	    mav.addObject("target", target);
	     
	    return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteTarget(@PathVariable(name = "id") int id) {
		targetservice.delete(id);
	    return "redirect:/";       
	}
    // handler methods...
}