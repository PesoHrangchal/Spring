package com.atm.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.atm.dto.UserAccountDTO;
import com.atm.entity.UserAccount;

@Component
public interface ATMService {

	// first we write CRUD operation
	
	// create 
	public UserAccount createUser(UserAccountDTO userAccountDTO);
	
	// update
	public UserAccount updateUser(int cardNumber, UserAccountDTO u);
	
	// getById
	public UserAccount getDetailsByCardNo(int cardNumber);
	
	// getAllDetails
	public List<UserAccount> getAllDetails();	// working
	
	// delete
	public String deleteAUser(int cardNumber , int pin);
	
	// deposit	
	public String depositeAmount(int cardNumber, int pin, double amount);
	
	// withdraw
	public String withdrawAmount(int cardNumber, int pin, double amount);	
	
	// check Balance
	public double checkBalance(int cardNumber , int pin);
	
	// change pin
	String changePin(int cardNumber, int pin, int newPin);
	
	
}