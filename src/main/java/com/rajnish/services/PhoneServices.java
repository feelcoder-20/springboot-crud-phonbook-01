package com.rajnish.services;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rajnish.model.*;
@Service
public interface PhoneServices {

	public List<Phone>  getContacts();
	
	public Phone getContact(Integer id);
	
	public String saveContact(Phone phone);
	
	public String deleteContact(Integer id);
	
}
