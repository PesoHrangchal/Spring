package com.atm.dto;
import java.util.Date;
import java.util.Random;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor  // using these annotations to use getter & setters, parametrized and non-parametrized Constructor
@NoArgsConstructor
@Data
@Builder
public class UserAccountDTO {
	// we use dto class to transfer the object of our UserAccount class
	@NotBlank(message = "Invalid Name: Empty Name") // these annotations are used for validation
	@NotNull(message = "Invalid Name: name is NULL")
	@Size(min = 3, max = 25, message = "Invalid Name: Must be of 3-25 characters")
	private String name;
	@Email(message = "Invalid email") // for validating email 
	private String email;
	@NotNull(message = "Invalid Phone Number: number is NULL")
	@NotBlank(message = "Invalid Phone Number: Empty Number")
	@Pattern(regexp = "^\\d{10}$", message = "Invalid phone Number!!!!") // to check whether phone number is equal to 10 digit
	private String contact_number;
	@NotNull
    @Pattern(regexp = "savings|current") // these annotation only allow user to choose either saving or current
	private String accountType; // current/saving
	@NotNull
	@Size(min = 12, max = 12, message = "Must be of 12 digits")
	private String accountNumber;	
	@NotNull(message = "Invalid Date: Date is NULL")
	@Future(message = "Invalid expiry date: must be in the future")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy") // use for setting the format of date
	private Date expiryDate;
	@NotNull(message = "Amount cannot be null")	
	@DecimalMin(value= "1000.00",message = "Invalid Amount: you have to deposite minimum 1000 to create your account" )
	private Double amount; // decimal min use to set the minimum value which is 1000rs.
	@NotNull(message = "Pin cannot be null")		
	@Digits(integer = 4, fraction = 0, message = "Invalid Pin: Pin must be a 4-digit number")
	private Integer pin; 
	// below is argument constructor which is used to init the userDTO class
	// we did not use @NoArgs AllArgs because we need to write some algorithms
	public UserAccountDTO(String name, String email, String contact_number, String accountType, String accountNumber, Double amount,Integer pin, Date expiryDate) {
        this.name = name;
        this.email = email;
        this.contact_number = contact_number;
        this.accountType = accountType; 
        this.accountNumber=accountNumber;
        this.amount = amount;
        this.pin=pin;
        this.expiryDate = expiryDate;
    }
	//to generate random cvv no
	public String randomCvv() {
		Random random = new Random();
		return String.valueOf(100+random.nextInt(9000));
	}
	//to generate random card no
	public int randomCardNo() {
		Random random = new Random();
		return 100000 + random.nextInt(900000);
	}
}