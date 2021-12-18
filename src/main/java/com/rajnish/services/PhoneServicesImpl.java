package com.rajnish.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rajnish.model.Phone;
import com.rajnish.repository.PhoneRepository;

@Service
public class PhoneServicesImpl implements PhoneServices{

	@Autowired
	private PhoneRepository phoneRepo;
	
	
	@Override
	public List<Phone> getContacts() {
		
		return this.phoneRepo.findAll();
	
	}

	@Override
	public Phone getContact(Integer id) {
		Optional<Phone> findById = this.phoneRepo.findById(id);
		Phone phone=null;
		if(findById.isPresent()) {
			phone=findById.get();
		}else
		{
			throw new RuntimeException("Data not found::"+id);
		}
		return phone;
	}

	@Override
	public String saveContact(Phone phone) {
	    this.phoneRepo.save(phone);
		return "Data Added";
	}

	@Override
	public String deleteContact(Integer id) {
		this.phoneRepo.deleteById(id);
		return "redirect:/";
	}

}
