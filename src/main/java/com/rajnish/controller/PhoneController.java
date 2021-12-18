package com.rajnish.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.rajnish.model.Phone;
import com.rajnish.services.PhoneServices;

@Controller
public class PhoneController {

	@Autowired
	private PhoneServices phoneServices;
	
	@GetMapping("/")
	public String showContacts(Model model) {
		List<Phone> contacts = this.phoneServices.getContacts();
		
		model.addAttribute("contacts",contacts );
		return "index";
		
	}
	
	
	@GetMapping("/showcontactform")
	public String showContactForm(Model model) {
		Phone contact=new Phone();
		model.addAttribute("contact", contact);
		return "showcontactform";
		
	}
	@PostMapping("/savecontact")
	public String saveContact(@ModelAttribute("contact") Phone phone, Model model) {
	
		this.phoneServices.saveContact(phone);
		return "redirect:/";
		
	}
	
	@GetMapping("/showeditform/{id}")
	public String showEditForm(@PathVariable Integer id,Model model) {
		Phone contact = this.phoneServices.getContact(id);
		
		//Phone contact=new Phone();
		model.addAttribute("contact", contact);
		return "showeditform";
		
	}
	@GetMapping("/deletecontact/{id}")
	public String deleteContactById(@PathVariable Integer id) {
		
		String deleteContact = this.phoneServices.deleteContact(id);
		return deleteContact;
	}
}
