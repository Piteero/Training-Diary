package com.TrainingDiary.Calculations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.TrainingDiary.View.ViewText;

public class DeleteUser {

	private int id;

	public void deleteUser() throws Exception {
		passUserNumberToDelete();
		deleteUserFromDatabase();
	}

	private void passUserNumberToDelete() throws Exception {
		try {
			ViewText.showDeleteUser();
			Scanner scanner = new Scanner(System.in);
			id = scanner.nextInt();
		} catch (Exception e) {
			ViewText.showWrongData();
			Menu repeatMenu = new Menu();
			repeatMenu.repeatMenu();
		}
	}

	private void deleteUserFromDatabase() throws Exception {
		try {
			Connection con = GetConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("DELETE FROM User WHERE Id=" + id + " ");
			ps.executeUpdate();
			ViewText.showShowDataDeleted();
		} catch (Exception e) {
			ViewText.showFailure();
			Menu repeatMenu = new Menu();
			repeatMenu.repeatMenu();
		}
	}
	
}
