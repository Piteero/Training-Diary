package com.TrainingDiary.Calculations;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import com.TrainingDiary.View.ViewText;

public class BrowseLastMeasurements {

	private int lastMeasurements;
	private int userNumber;
	private int id;
	private Date date;
	private double weight;
	private double height;
	private double chestGirth;
	private double bicepsGirth;
	private double stomachGirth;
	private double thighGirth;
	private double calfGirth;

	public void browseLastMeasurements() throws Exception {
		passNumberOfLastMeasurements();
		showLastMeasurements();
	}

	private void passNumberOfLastMeasurements() throws Exception {
		try {
			Scanner scanner = new Scanner(System.in);
			ViewText.showPassUserNumber();
			userNumber = scanner.nextInt();
			ViewText.showShowLastMeasurements();
			lastMeasurements = scanner.nextInt();
		} catch (Exception e) {
			ViewText.showWrongData();
			Menu repeatMenu = new Menu();
			repeatMenu.repeatMenu();
		}
	}

	private void showLastMeasurements() throws Exception {
		try {
			Connection con = GetConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM UserData WHERE Id= " + userNumber
					+ " ORDER BY Data DESC LIMIT " + lastMeasurements + " ");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				id = rs.getInt("Lp");
				date = rs.getDate("Data");
				weight = rs.getDouble("Waga");
				height = rs.getDouble("Wzrost");
				chestGirth = rs.getDouble("Obwod_klatki");
				bicepsGirth = rs.getDouble("Obwod_bicepsa");
				stomachGirth = rs.getDouble("Obwod_brzucha");
				thighGirth = rs.getDouble("Obwod_uda");
				calfGirth = rs.getDouble("Obwod_lydki");

				System.out.println("Lp: " + id + " Data: " + date + " Waga: " + weight + "kg Wzrost: " + height
						+ "cm Obwód klatki: " + chestGirth + "cm Obwód bicepsa: " + bicepsGirth + "cm Obwód brzucha: " + ""
						+ stomachGirth + "cm Obwód uda: " + thighGirth + "cm Obwód łydki: " + calfGirth);
			}
		} catch (Exception e) {
			ViewText.showFailure();
			Menu repeatMenu = new Menu();
			repeatMenu.repeatMenu();
		}
	}
}
