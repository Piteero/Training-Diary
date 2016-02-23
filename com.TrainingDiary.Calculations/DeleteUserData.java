package com.TrainingDiary.Calculations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.TrainingDiary.View.ViewText;

public class DeleteUserData {

	private int id;

	public void deleteUserData() throws Exception {
		passRecordNumberToDelete();
		deleteRecord();
	}

	private void passRecordNumberToDelete() throws Exception {
		try {
			ViewText.showDeleteUserData();
			Scanner scanner = new Scanner(System.in);
			id = scanner.nextInt();
		} catch (Exception e) {
			ViewText.showWrongData();
			Menu repeatMenu = new Menu();
			repeatMenu.repeatMenu();
		}
	}

	private void deleteRecord() throws Exception {
		try {
			Connection con = GetConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("DELETE FROM UserData WHERE Lp=" + id + " ");
			ps.executeUpdate();
			ViewText.showShowDataDeleted();
		} catch (Exception e) {
			ViewText.showFailure();
			Menu repeatMenu = new Menu();
			repeatMenu.repeatMenu();
		}
	}
}
