package Emailapp;

import java.util.*;

public class Email {
	private final String LETTERS_NUMBERS_SIGN = "ABCDEFGHIJKLMNOPQRSTUVWXY" + "abcdefghijklmnopqrstuvwxy" + "0123456789" + "!#$%";
	private String firstname;
	private String lastname;
	private String password;
	private String department;
	private int mailboxCapacity = 500;
	private String alternativeEmail;
	private String email;
	public static Email allEmails [] = new Email[10];
	private static int index = 0;

	//Construktor for first name and lat name   CHECK
	
	public Email() {
		
	}
	
	public Email(String firstname, String lastname) {
		
		Scanner inp = new Scanner(System.in);
		this.firstname = firstname;
		this.lastname = lastname;
		setDepartment();

		
		System.out.print("Enter length of your generated password: ");
		int length = inp.nextInt();
		
		password = generateRandomPassword(length);
		System.out.println("password generated: " + password);
		System.out.println("Enter Y to continue or N to generate a new password");
		
		inp = new Scanner(System.in);
		
		String input = inp.nextLine();
		
			while(input.equalsIgnoreCase("n")) {
				password = generateRandomPassword(length);
				System.out.println("password generated: " + password);
				input = inp.nextLine();
				 
			 if(input.equalsIgnoreCase("y"))break;
			 	else if(!input.equalsIgnoreCase("n")) {
					 System.out.println("Please enter a N or Y");
					 input = inp.nextLine();
					 }
			}
		
			
			email = this.firstname + "." + this.lastname + "@" + this.department + ".company.com";
			
			Email newmail = new Email();
			newmail.firstname = this.firstname;
			newmail.lastname = this.lastname;
			newmail.password = this.password;
			newmail.department = this.department;
			newmail.mailboxCapacity = this.mailboxCapacity;
			newmail.alternativeEmail = this.alternativeEmail;
			newmail.email = this.email;
			
			addToEmail(newmail);
		
	}
	
	private void addToEmail(Email m) {
		allEmails[index] = m;
		index++;
	}
	
	public static void showAllEmails() {
		try {
			
	
		for(Email m : allEmails) {
			m.showInfo();
		}
		}
		catch(Exception e) {
			
		}
	}
	
public void setMailboxCapacity(int mailboxCapacity) { 
	this.mailboxCapacity = mailboxCapacity; 
}
	
public void setAlternativeEmail(String alternativeEmail) { 
	this.alternativeEmail = alternativeEmail; 
}

public void setPassword(String password) { 
	this.password = password; 
}

public void setFirstname(String firstname) { 
	this.firstname = firstname; 
}

public void setLastname(String lastname) { 
	this.lastname = lastname; 
}

public void setDepartment(String department) { 
	this.department = department; 
}

public void setEmail(String email) { 
	this.email = email; 
}


public int getMailboxCapacity() { return this.mailboxCapacity; }
public String getAlternativeEmail() { return this.alternativeEmail; }
public String getPassword() { return this.password; }
public String getFirstname() { return this.firstname; }
public String getLastname() { return this.lastname; }
public String getDepartment() { return this.department; }


	//ask for department 
	
	private void setDepartment() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the department");
		System.out.println("1 for sales");
		System.out.println("2 for Development");
		System.out.println("3 for Accounting");
		System.out.println("0 for none");
		
		int input = in.nextInt();
		
		if(input == 1) this.department = "sales";
		if(input == 2) this.department = "Dev";
		if(input == 3) this.department = "Acc";
		if(input == 0) this.department = "none";
	

	}
	
	//generate random password	
	
	
public String generateRandomPassword(int lengthOfPassword){

		String lettersAndNumbers = LETTERS_NUMBERS_SIGN;
		password = "";
		
		for(int i = 0; i < lengthOfPassword; i++) {
			password += lettersAndNumbers.charAt((int)  (lettersAndNumbers.length() * Math.random()));
		
		}
		
		return password;
	}
	

	
	public String toString() {
		return "your email is: " + this.email + "\nYour password is:" + this.password;
	}
	
	public void showInfo() {
		System.out.println("DISPLAY NAME: " + this.firstname + " " + 
				this.lastname + "\nCOMPANY EMAIL: " + this.email + 
				"\nMAILBOX CAPACITY: " + this.mailboxCapacity + "mb"); 
	}

}
