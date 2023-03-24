package com.atm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atm.entity.UserAccount;
public interface ATMRepository extends JpaRepository<UserAccount, Integer> {

	UserAccount findByCardNumber(Integer cardNumber); // custom operation to find cardNumber as it is unique

	void deleteByCardNumber(int cardNumber); // to delete object using cardNumber
}