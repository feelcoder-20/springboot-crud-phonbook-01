package com.rajnish.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="phonebook")
@Data
public class Phone {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="first_name")
	private String contactFirstName;
	@Column(name="last_name")
	private String contactLastName;
	
	@Column(name="contact_email")
	private String contactEmail;
	
	@Column(name="contact_phone")
	private String contactPhone;
	
}
