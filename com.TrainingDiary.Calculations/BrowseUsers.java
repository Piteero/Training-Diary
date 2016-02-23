package com.TrainingDiary.Calculations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import com.TrainingDiary.View.ViewText;

public class BrowseUsers {

	private int id;
	private String name;
	private String sex;
	private long time;
	private Date date;

	public void browseUsers() throws Exception {
		try {
			ViewText.showUsers();
			Connection con = GetConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM User");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				id = rs.getInt("Id");
				name = rs.getString("Imie");
				sex = rs.getString("Plec");
				time = rs.getLong("Time");
				date = new Date(time);
				System.out.print("Id: " + id + " Imię: " + name + " Płeć: " + sex + " Data dodania: ");
				System.out.printf("%tc\n", date);
			}
		} catch (Exception e) {
			ViewText.showFailure();
			Menu repeatMenu = new Menu();
			repeatMenu.repeatMenu();
		}
	}
}
