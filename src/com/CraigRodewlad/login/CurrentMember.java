package com.CraigRodewlad.login;

import java.util.Scanner;

public class CurrentMember {
	public void checkLoginPhoneNumber(Scanner scan){
		System.out.print("Please enter your phone number: ");
		String answer = scan.next();
		
		boolean doesExisit = PatronsAccess.checkIfMemberExists(answer);
		
		if (doesExisit) {
			System.out.println("Login successfull!");
		}
		else {
			System.out.println("Number not found.  Eneter your information");
			NewMember newMember = new NewMember();
			newMember.createNewMember(scan);
		}
		
	}
}
