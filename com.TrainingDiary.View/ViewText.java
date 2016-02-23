package com.TrainingDiary.View;

public class ViewText {

	public static void showIntroduction() {
		System.out.println(
				"*** Witaj w Dzienniku Treningowym! ***\nWybierz odpowiednią opcję z menu i zatwierdź przyciskiem enter:");
	}

	public static void showMenu() {
		System.out.println("[0] Dodaj nowego użytkownika\n[1] Usuń użytkownika\n[2] Lista użytkowników\n[3] Dodaj nowe pomiary użytkownika\n"
				+ "[4] Usuń pomiary użytkownika\n[5] Przejrzyj ostatnie pomiary\n[6] Sprawdź progres\n[7] Wyjście z programu");
	}

	public static void showAddNewUserData() {
		System.out.println("Dodawanie nowego rekordu:");
	}

	public static void showWriteUserData() {
		System.out.println("Wpisz dane:");
	}

	public static void showUpdateUserData() {
		System.out.println("Wpisz wyniki kolejnych pomiarów:");
	}

	public static void showName() {
		System.out.print("Imię: ");
	}

	public static void showDate() {
		System.out.print("Data [rrrr-mm-dd]: ");
	}

	public static void showAge() {
		System.out.print("Wiek: ");
	}

	public static void showSex() {
		System.out.print("Płeć: ");
	}

	public static void showWeight() {
		System.out.print("Waga [kg]: ");
	}

	public static void showHeight() {
		System.out.print("Wzrost [cm]: ");
	}

	public static void showChestGirth() {
		System.out.print("Obwód klatki piersiowej [cm]: ");
	}

	public static void showBicepsGirth() {
		System.out.print("Obwód bicepsa [cm]: ");
	}

	public static void showStomachGirth() {
		System.out.print("Obwód brzucha [cm]: ");
	}

	public static void showThighGirth() {
		System.out.print("Obwód uda [cm]: ");
	}

	public static void showCalfGirth() {
		System.out.print("Obwód łydki [cm]: ");
	}

	public static void showWrongData() {
		System.out.println("Nieoprawnie wprowadzone dane.");
	}

	public static void showShowLastMeasurements() {
		System.out.println("Wskaż ile ostatnich wpisów chcesz przejrzeć:");
	}

	public static void showDeleteUserData() {
		System.out.print("Podaj Lp rekordu, który ma być usunięty: ");
	}

	public static void showShowDataDeleted() {
		System.out.println("Rekord usunięty.");
	}

	public static void showShowRecordAdded() {
		System.out.println("Rekord dodany.");
	}

	public static void showFailure() {
		System.out.println("Niepowodzenie.");
	}

	public static void showProgramExit() {
		System.out.println("Pomyślne wyjście z programu.");
	}

	public static void showRepeatOption() {
		System.out.println("Powrót do menu [P] lub wyjście z programu [W] oraz enter");
	}

	public static void showAddNewUser() {
		System.out.println("Tworzenie nowego użytkownika:");
	}

	public static void showPassUserNumber() {
		System.out.println("Podaj numer użytkownika: ");
	}

	public static void showOutOfRecords() {
		System.out.println("Brak rekordów.");
	}

	public static void showUsers() {
		System.out.println("Lista użytkowników: ");
	}

	public static void showActualProgress() {
		System.out.println("Aktualny progres: ");
	}

	public static void showChanges() {
		System.out.println("Zmiany obwodów pomiędzy ostatnimi pomiarami:");
	}
	
	public static void showDeleteUser(){
		System.out.println("Wskaż Id użytkownika, który ma być usnięty:");
	}
}
