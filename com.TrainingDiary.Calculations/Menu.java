package com.TrainingDiary.Calculations;

import java.util.Scanner;

import com.TrainingDiary.View.ViewText;

public class Menu {

	private int pickFromMenu;
	private String repeatOption;

	public void menu() throws Exception {
		chooseFromMenu();
	}

	public void repeatMenu() throws Exception {
		menuRepeat();
	}

	private void menuRepeat() throws Exception {
		try {
			System.out.println("");
			ViewText.showMenu();
			Scanner scanner = new Scanner(System.in);
			pickFromMenu = scanner.nextInt();
		} catch (Exception e) {
			ViewText.showWrongData();
			menuRepeat();
		}
		if (pickFromMenu == 0 || pickFromMenu == 1 || pickFromMenu == 2 || pickFromMenu == 3 || pickFromMenu == 4
				|| pickFromMenu == 5 || pickFromMenu == 6 || pickFromMenu == 7) {
			switch (pickFromMenu) {
			case 0:
				AddNewUser newUser = new AddNewUser();
				newUser.addNewUser();
				repeatMenu();
				break;
			case 1:
				DeleteUser deleteUser = new DeleteUser();
				deleteUser.deleteUser();
				repeatMenu();
				break;
			case 2:
				BrowseUsers browseUsers = new BrowseUsers();
				browseUsers.browseUsers();
				repeatMenu();
				break;
			case 3:
				AddUserData addUserData = new AddUserData();
				addUserData.addUserData();
				repeatMenu();
				break;
			case 4:
				DeleteUserData deleteUserData = new DeleteUserData();
				deleteUserData.deleteUserData();
				repeatMenu();
				break;
			case 5:
				BrowseLastMeasurements browseMeasurements = new BrowseLastMeasurements();
				browseMeasurements.browseLastMeasurements();
				repeatMenu();
				break;
			case 6:
				CheckProgress checkProgress = new CheckProgress();
				checkProgress.checkProgress();
				repeatMenu();
				break;
			case 7:
				ViewText.showProgramExit();
				break;
			}
		} else {
			ViewText.showWrongData();
			repeatMenu();
		}
	}

	private void chooseFromMenu() throws Exception {
		try {
			ViewText.showIntroduction();
			ViewText.showMenu();
			Scanner scanner = new Scanner(System.in);
			pickFromMenu = scanner.nextInt();
		} catch (Exception e) {
			ViewText.showWrongData();
			chooseFromMenu();
		}

		if (pickFromMenu == 0 || pickFromMenu == 1 || pickFromMenu == 2 || pickFromMenu == 3 || pickFromMenu == 4
				|| pickFromMenu == 5 || pickFromMenu == 6 || pickFromMenu == 7) {
			switch (pickFromMenu) {
			case 0:
				AddNewUser newUser = new AddNewUser();
				newUser.addNewUser();
				break;
			case 1:
				DeleteUser deleteUser = new DeleteUser();
				deleteUser.deleteUser();
				break;
			case 2:
				BrowseUsers browseUsers = new BrowseUsers();
				browseUsers.browseUsers();
				break;
			case 3:
				AddUserData addUserData = new AddUserData();
				addUserData.addUserData();
				break;
			case 4:
				DeleteUserData deleteUserData = new DeleteUserData();
				deleteUserData.deleteUserData();
				break;
			case 5:
				BrowseLastMeasurements browseMeasurements = new BrowseLastMeasurements();
				browseMeasurements.browseLastMeasurements();
				break;
			case 6:
				CheckProgress checkProgress = new CheckProgress();
				checkProgress.checkProgress();
				break;
			case 7:
				ViewText.showProgramExit();
				break;
			}
		} else {
			ViewText.showWrongData();
			repeatMenu();
		}
	}
}
