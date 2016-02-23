package com.TrainingDiary.Calculations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.TrainingDiary.View.ViewText;

public class CheckProgress {

	private final int BMI_MULTIPLIER = 10000;
	private int userNumber;
	private double bmi;
	private double lastWeight;
	private double lastChestGirth;
	private double lastBicepsGirth;
	private double lastStomachGirth;
	private double lastThighGirth;
	private double lastCalfGirth;
	private double actualWeight;
	private double actualHeight;
	private double actualChestGirth;
	private double actualBicepsGirth;
	private double actualStomachGirth;
	private double actualThighGirth;
	private double actualCalfGirth;

	public void checkProgress() throws Exception {
		passUserId();
		checkUserProgress();

	}

	private void passUserId() throws Exception {
		try {
			ViewText.showActualProgress();
			Scanner scanner = new Scanner(System.in);
			ViewText.showPassUserNumber();
			userNumber = scanner.nextInt();
		} catch (Exception e) {
			ViewText.showWrongData();
			Menu repeatMenu = new Menu();
			repeatMenu.repeatMenu();
		}
	}

	private void checkUserProgress() throws Exception {
		try {
			Connection con = GetConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"SELECT Waga,Wzrost FROM UserData WHERE " + "Id=" + userNumber + " ORDER BY Data DESC LIMIT 1 ");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				actualWeight = rs.getDouble("Waga");
				actualHeight = rs.getDouble("Wzrost");
				bmi = (actualWeight / Math.pow(actualHeight, 2)) * (BMI_MULTIPLIER);

				System.out.print("Twoje aktualne BMI wynosi: ");
				System.out.printf("%.2f", bmi);
				if (bmi < 16)
					System.out.println(" (wygłodzenie)");
				else if (bmi >= 16 && bmi < 17)
					System.out.println(" (wychudzenie)");
				else if (bmi >= 17 && bmi < 18.5)
					System.out.println(" (niedowaga)");
				else if (bmi >= 18.5 && bmi < 25)
					System.out.println(" (norma)");
				else if (bmi >= 25 && bmi < 30)
					System.out.println(" (nadwaga)");
				else if (bmi >= 30 && bmi < 35)
					System.out.println(" (I stopień otyłości)");
				else if (bmi >= 35 && bmi < 40)
					System.out.println(" (II stopień otyłości)");
				else if (bmi > 40)
					System.out.println(" (otyłość skrajna)");
			}

			PreparedStatement ps2 = con.prepareStatement(
					"SELECT * FROM UserData WHERE Id = " + userNumber + " " + "ORDER BY Data DESC LIMIT 1");
			ResultSet rs2 = ps2.executeQuery();
			while (rs2.next()) {
				actualWeight = rs2.getDouble("Waga");
				actualChestGirth = rs2.getDouble("Obwod_klatki");
				actualBicepsGirth = rs2.getDouble("Obwod_bicepsa");
				actualStomachGirth = rs2.getDouble("Obwod_brzucha");
				actualThighGirth = rs2.getDouble("Obwod_uda");
				actualCalfGirth = rs2.getDouble("Obwod_lydki");
			}

			PreparedStatement ps3 = con.prepareStatement(
					"SELECT * FROM UserData WHERE Id = " + userNumber + " " + "ORDER BY Data DESC LIMIT 2");
			ResultSet rs3 = ps3.executeQuery();
			while (rs3.next()) {
				lastWeight = rs3.getDouble("Waga");
				lastChestGirth = rs3.getDouble("Obwod_klatki");
				lastBicepsGirth = rs3.getDouble("Obwod_bicepsa");
				lastStomachGirth = rs3.getDouble("Obwod_brzucha");
				lastThighGirth = rs3.getDouble("Obwod_uda");
				lastCalfGirth = rs3.getDouble("Obwod_lydki");
			}

			ViewText.showChanges();
			if ((actualWeight - lastWeight) > 0)
				System.out.println("Waga: +" + (actualWeight - lastWeight) + " kg");
			else
				System.out.println("Waga: " + (actualWeight - lastWeight) + " kg");
			if ((actualChestGirth - lastChestGirth) > 0)
				System.out.println("Obwód klatki: +" + (actualChestGirth - lastChestGirth) + " cm");
			else
				System.out.println("Obwód klatki: " + (actualChestGirth - lastChestGirth) + " cm");
			if ((actualBicepsGirth - lastBicepsGirth) > 0)
				System.out.println("Obwód bicepsa: +" + (actualBicepsGirth - lastBicepsGirth) + " cm");
			else
				System.out.println("Obwód bicepsa: " + (actualBicepsGirth - lastBicepsGirth) + " cm");
			if ((actualStomachGirth - lastStomachGirth) > 0)
				System.out.println("Obwód brzucha: +" + (actualStomachGirth - lastStomachGirth) + " cm");
			else
				System.out.println("Obwód brzucha: " + (actualStomachGirth - lastStomachGirth) + " cm");
			if ((actualThighGirth - lastThighGirth) > 0)
				System.out.println("Obwód uda: +" + (actualThighGirth - lastThighGirth) + " cm");
			else
				System.out.println("Obwód uda: " + (actualThighGirth - lastThighGirth) + " cm");
			if ((actualCalfGirth - lastCalfGirth) > 0)
				System.out.println("Obwód łydki: +" + (actualCalfGirth - lastCalfGirth) + " cm");
			else
				System.out.println("Obwód łydki: " + (actualCalfGirth - lastCalfGirth) + " cm");
		} catch (Exception e) {
			ViewText.showFailure();
			Menu repeatMenu = new Menu();
			repeatMenu.repeatMenu();
		}
	}
}
