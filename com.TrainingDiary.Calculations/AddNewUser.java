package com.TrainingDiary.Calculations;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.GregorianCalendar;
import java.util.Scanner;

import com.TrainingDiary.View.ViewText;

public class AddNewUser {

	private String name;
	private String sex;
	private long time;

	public void addNewUser() throws Exception {
		passNewUserData();
		addNewUserToTheDatabase();
	}

	private void passNewUserData() throws Exception {
		try {
			ViewText.showAddNewUser();
			Scanner scanner = new Scanner(System.in);
			ViewText.showName();
			name = scanner.next();
			ViewText.showSex();
			sex = scanner.next();
			GregorianCalendar gregorianCalendar = new GregorianCalendar();
			time = gregorianCalendar.getTimeInMillis();
		} catch (Exception e) {
			ViewText.showWrongData();
			Menu repeatMenu = new Menu();
			repeatMenu.repeatMenu();
		}
	}

	private void addNewUserToTheDatabase() throws Exception {
		try {
			Connection con = GetConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO User VALUES (NULL, '" + name + "'," + " '" + sex + "', '" + time + "')");
			ps.executeUpdate();
			ViewText.showShowRecordAdded();
			PreparedStatement ps2 = con.prepareStatement("SELECT Id FROM User ORDER BY Time DESC LIMIT 1");
			ResultSet rs = ps2.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("Id");
				System.out.println("Twój numer użytkownika to: " + id + " ,zapamiętaj go.");
			}
		} catch (Exception e) {
			ViewText.showFailure();
			Menu repeatMenu = new Menu();
			repeatMenu.repeatMenu();
		}
	}
}
