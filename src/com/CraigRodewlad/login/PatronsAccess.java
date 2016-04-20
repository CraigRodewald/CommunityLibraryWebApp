package com.CraigRodewlad.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PatronsAccess {
	private static Connection connect = null;
	private static Statement statement = null;
	private static PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;

	private static void getConnection() {
		String dbURL = "jdbc:mysql://localhost:3306/library?";
		String userName = "root";
		String password = "sesame";

		try {
			Class.forName("com.mysql.jdbc.Driver");

			connect = DriverManager.getConnection(dbURL, userName, password);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Error" + e);
		}
	}

	public static void readDataBase() {
		try {
			getConnection();
			statement = connect.createStatement();

			resultSet = statement.executeQuery("select * from library.patrons");

			while (resultSet.next()) {
				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");
				String phoneNumber = resultSet.getString("phone_number");
				String dateVisited = resultSet.getString("date_visited");

				System.out.println("First Name: " + firstName);
				System.out.println("Last Name: " + lastName);
				System.out.println("Phone Number: " + phoneNumber);
				System.out.println("Date Visited: " + dateVisited);
				System.out.println();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void addNewMemberToDatabase(String firstName, String lastName, String phoneNumber) {

		try {
			getConnection();
			preparedStatement = connect
					.prepareStatement("insert into patrons (first_name, last_name, phone_number) values (?,?,?)");
			preparedStatement.setString(1, firstName);
			preparedStatement.setString(2, lastName);
			preparedStatement.setString(3, phoneNumber);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static boolean checkIfMemberExists(String phoneNumber) {
		boolean doesExist = false;
		try {
			getConnection();
			statement = connect.createStatement();
			resultSet = statement.executeQuery("select * from library.patrons");


			while (resultSet.next()) {
				String userPhoneNumber = resultSet.getString("phone_number");
				System.out.println(userPhoneNumber);
				if (userPhoneNumber.equalsIgnoreCase(phoneNumber)) {
					doesExist = true;
					break;
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return doesExist;
	}

}
