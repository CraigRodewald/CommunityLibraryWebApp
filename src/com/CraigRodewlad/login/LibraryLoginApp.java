package com.CraigRodewlad.login;

import java.util.Scanner;

public class LibraryLoginApp {
	public static void main(String[] args) {
		// Initialize objects
		Scanner scan = new Scanner(System.in);
		
		// Initialize variables
		String userAnswer;
		
		// Title bar
		System.out.println("Bharatiya Community Library Application");
		System.out.println("\tMain Page");
		
		// Ask user if they are a member or not
		System.out.println("\n\t1-MEMBER LOGIN\n\t2-Not a memeber? Sign up here!\n\n\tEnter a selection:");
		userAnswer=scan.next();
		
		// Runs the users selected option
		switch (Integer.parseInt(userAnswer)) {
		case 1:
			CurrentMember currentMember = new CurrentMember();
			// Login screen
			currentMember.checkLoginPhoneNumber(scan);
			// Check login vs database credentials
			break;
			
		case 2:
			NewMember newMember = new NewMember();
			// User sign up page
			newMember.createNewMember(scan);
			// Enters a first name, last name, and phone number
			System.out.println("You have been added to our database");
			break;

		default:
			break;
			
			// Show calendar events
			
			// Loop back to top
		}
		
		scan.close();
	}

}
