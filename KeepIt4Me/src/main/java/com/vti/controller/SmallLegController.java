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

import com.vti.entity.SmallLeg;
import com.vti.service.SmallLegService;


@Controller
public class SmallLegController {
 
    @Autowired
    private SmallLegService smallLegService;
	
	@RequestMapping("/2")
	public String viewHomePage(Model model) {
	    List<SmallLeg> listSmallLegs = smallLegService.listAll();
	    model.addAttribute("listSmallLegs", listSmallLegs);
	     
	    return "index2";
	}
	@RequestMapping("/new2")
	public String showNewSmallLegPage(Model model) {
		SmallLeg smallLeg = new SmallLeg();
	    model.addAttribute("smallLeg", smallLeg);
	     
	    return "new_smallLeg";
	}
	
	@RequestMapping(value = "/save2", method = RequestMethod.POST)
	public String saveSmallLeg(@ModelAttribute("target") SmallLeg smallLeg) {
		smallLegService.save(smallLeg);
	     
	    return "redirect:/";
	}
	
	@RequestMapping("/edit2/{id}")
	public ModelAndView showEditSmallLegPage(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("edit_smallLeg");
	    SmallLeg smallLeg = smallLegService.get(id);
	    mav.addObject("smallLeg", smallLeg);
	     
	    return mav;
	}
	
	@RequestMapping("/delete2/{id}")
	public String deleteSmallLeg(@PathVariable(name = "id") int id) {
		smallLegService.delete(id);
	    return "redirect:/";       
	}
    // handler methods...
}