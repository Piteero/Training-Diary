package com.TrainingDiary.Calculations;

import java.sql.Connection;
import java.sql.DriverManager;

public class GetConnection {

	public static Connection getConnection() {
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://mysql6.superhost.pl:3306/sh201912_trainingdiary";
			String user = "sh201912_train";
			String pass = "exercise123";
			Class.forName(driver);

			Connection con = DriverManager.getConnection(url, user, pass);
			return con;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

}
