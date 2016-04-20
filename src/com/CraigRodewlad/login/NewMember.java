package com.CraigRodewlad.login;

import java.util.Scanner;

public class NewMember {
	
	Member member = new Member(null, null, null);
	
	public void createNewMember(Scanner scan){
		// Initialize variables
		String answer;
		
		answer = getNewMemberFirstName(scan);
		member.setFirstName(answer);
		
		answer = getNewMemberLastName(scan);
		member.setLastName(answer);
		
		answer = getNewMemberPhoneNumber(scan);
		member.setPhoneNumber(answer);
		
		addNewMember();
	}
	
	private void addNewMember() {
		String firstName = member.getFirstName();
		String lastName = member.getLastName();
		String phoneNumber = member.getPhoneNumber();
		
		PatronsAccess.addNewMemberToDatabase(firstName, lastName, phoneNumber);
	}

	public String getNewMemberFirstName(Scanner scan){
		System.out.println("What is your first name?");
		String answer = scan.next();
		
		return answer;
	}
	
	public String getNewMemberLastName(Scanner scan){
		System.out.println("What is your last name?");
		String answer = scan.next();
		
		return answer;
	}
	
	public String getNewMemberPhoneNumber(Scanner scan){
		System.out.println("Enter your phone numnber:");
		String answer = scan.next();
		
		return answer;
	}
}
