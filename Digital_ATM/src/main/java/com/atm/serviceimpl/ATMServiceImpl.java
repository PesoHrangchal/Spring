package com.atm.serviceimpl;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.atm.dto.UserAccountDTO;
import com.atm.entity.UserAccount;
import com.atm.repository.ATMRepository;
import com.atm.service.ATMService;
@Service
public class ATMServiceImpl implements ATMService {
	@Autowired
	private ATMRepository atmRepository;
	@Override
	public UserAccount createUser(UserAccountDTO userAccountDTO) {
		// DTO to Entity
		// Entity to DTO
		UserAccount _userAccount = UserAccount.builder().name(userAccountDTO.getName()).email(userAccountDTO.getEmail()).accountNumber(userAccountDTO.getAccountNumber())
				.contact_number(userAccountDTO.getContact_number()).accountType(userAccountDTO.getAccountType())
				.accountNumber(userAccountDTO.getAccountNumber())
				.CVV(userAccountDTO.randomCvv()).date(userAccountDTO.getExpiryDate())
				.cardNumber(userAccountDTO.randomCardNo()).amount(userAccountDTO.getAmount())
				.pin(userAccountDTO.getPin()).build();
		String newPin = "congratulations your digital debit card has been created successfully, you card number is:"+userAccountDTO.randomCardNo();
		System.out.println(newPin);
		return atmRepository.save(_userAccount);
		}
    @Override
	public UserAccount updateUser(int cardNumber, UserAccountDTO userAccountDTO) {
		// first find the cardNumber and validate
		UserAccount _UserAccount = atmRepository.findByCardNumber(cardNumber);
		if (_UserAccount == null) {
			return null; // user account does not exist
		} else {	//after validation update value from Entity to DTO
			_UserAccount.setName(userAccountDTO.getName());
			_UserAccount.setEmail(userAccountDTO.getEmail());
			_UserAccount.setContact_number(userAccountDTO.getContact_number());
			_UserAccount.setAccountType(userAccountDTO.getAccountType());
			_UserAccount.setAmount(userAccountDTO.getAmount());
			_UserAccount.setPin(userAccountDTO.getPin());
			return atmRepository.save(_UserAccount); // save the updated object
		}
	}
	@Override
	public UserAccount getDetailsByCardNo(int cardNumber) {
		UserAccount u = atmRepository.findByCardNumber(cardNumber); // fetch the data
		if(u == null)	// validate
		{
			return null; // means cardNumber is not present in the database
		} 	else return atmRepository.findByCardNumber(cardNumber);// return the object
	}
	@Override
	public String depositeAmount(int cardNumber, int pin, double amount) {
		// first we choose the account by card Number
		UserAccount _Account = atmRepository.findByCardNumber(cardNumber);
		if (_Account == null) {
			return "Invalid card number";
		}
		// then verify the pin
		if (_Account.getPin() != pin)
			return "Invalid Pin Number";
		// if both are correct then
		// we first get last amount
		double last_amount = _Account.getAmount(); // it will return amount & save in varaiable
		// now set the new amount = last + entered amount
		double latest_amount = (amount + last_amount);
		// now update amount in database
		_Account.setAmount(latest_amount);
		// now save the _account
		atmRepository.save(_Account);
		return "Amount deposited Successfully.. your latest amount status is:" + latest_amount;
	}
	@Override
	public String withdrawAmount(int cardNumber, int pin, double amount) {
		// the withdraw is something same as deposit
		UserAccount _Account = atmRepository.findByCardNumber(cardNumber);
		if (_Account == null) {
			return "Invalid card number";
		}
		// then verify the pin
		if (_Account.getPin() != pin)
			return "Invalid Pin Number";
		// now steps to withdraw
		double current_amount = _Account.getAmount();
		// check whether withdraw amount is not greater then current balance
		if (current_amount < amount) {
			return "Insufficient Balance, you current balance is" + current_amount;
		} else {
			double newBalance = (current_amount - amount);
			_Account.setAmount(newBalance);
			atmRepository.save(_Account);
			return "Successfully Amount :" + amount + "has been withdraw.. you current balance is" + newBalance;
		}
	}

	@Override
	public String changePin(int cardNumber, int pin, int newPin) {
		// first validate the parameters
		UserAccount _Account = atmRepository.findByCardNumber(cardNumber);
		if (_Account == null) {
			return "Invalid card number";
		}
		// then verify the pin
		if (_Account.getPin() != pin)
			return "Invalid Pin Number";
		
		// steps to change pin number
		int oldPin = _Account.getPin();
		if(oldPin == newPin) {
			return "Entered PIN match with older, please enter another PIN";
		} else 
		{
			_Account.setPin(newPin);
			atmRepository.save(_Account);
			return "PIN number has been changed Successfully";
		}
	}

	@Override
	public double checkBalance(int cardNumber, int pin) {
		// first find the cardNumber
		UserAccount _Account = atmRepository.findByCardNumber(cardNumber);
		// return the amount
		return _Account.getAmount();
	}

	@Transactional
	@Override
	public String deleteAUser(int cardNumber, int pin) {
		// first validate the parameters
		UserAccount _Account = atmRepository.findByCardNumber(cardNumber);
		if (_Account == null) {
			return "Invalid card number";
		}
		// then verify the pin
		if (_Account.getPin() != pin) {
			return "Invalid Pin Number";
				
		}		
		 atmRepository.deleteByCardNumber(cardNumber);
		return "Account with CardNumber:"+cardNumber+"has been deleted";
	}

	@Override
	public List<UserAccount> getAllDetails() {
		// below is the process of fetching DTO data  without creating DTO repository
		List<UserAccount> accounts = atmRepository.findAll();	// first fetch all data
	    if(accounts!=null)
	    	return atmRepository.findAll();
	    else
	    	return null;

	}

}