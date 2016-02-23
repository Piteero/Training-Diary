package com.TrainingDiary.Calculations;

import java.sql.Connection;
import java.util.Scanner;
import com.TrainingDiary.View.ViewText;
import com.mysql.jdbc.PreparedStatement;

public class AddUserData {

	private int userNumber;
	private String date;
	private double weight;
	private double height;
	private double chestGirth;
	private double bicepsGirth;
	private double stomachGirth;
	private double thighGirth;
	private double calfGirth;

	public void addUserData() throws Exception {
		passUserData();
		addUserDataToTheDatabase();
	}

	private void passUserData() throws Exception {
		Scanner scanner = new Scanner(System.in);
		try {
			ViewText.showAddNewUserData();
			ViewText.showPassUserNumber();
			userNumber = scanner.nextInt();
			ViewText.showDate();
			date = scanner.next();
			ViewText.showWeight();
			weight = scanner.nextDouble();
			ViewText.showHeight();
			height = scanner.nextDouble();
			ViewText.showChestGirth();
			chestGirth = scanner.nextDouble();
			ViewText.showBicepsGirth();
			bicepsGirth = scanner.nextDouble();
			ViewText.showStomachGirth();
			stomachGirth = scanner.nextDouble();
			ViewText.showThighGirth();
			thighGirth = scanner.nextDouble();
			ViewText.showCalfGirth();
			calfGirth = scanner.nextDouble();
		} catch (Exception e) {
			ViewText.showWrongData();
			Menu repeatMenu = new Menu();
			repeatMenu.repeatMenu();
		}
	}

	private void addUserDataToTheDatabase() throws Exception {
		try {
			Connection con = GetConnection.getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("INSERT INTO UserData VALUES (NULL,"
					+ userNumber + ",'" + date + "' " + ", '" + weight + "','" + height + "', '" + chestGirth + "'"
					+ ",'" + bicepsGirth + "','" + stomachGirth + "','" + thighGirth + "','" + calfGirth + "')");
			ps.executeUpdate();
			ViewText.showShowRecordAdded();
		} catch (Exception e) {
			ViewText.showFailure();
			Menu repeatMenu = new Menu();
			repeatMenu.repeatMenu();
		}
	}
}
