package yehric2018.keyp.data;

import java.util.Scanner;

import yehric2018.keyp.util.ClipboardManager;

public class DatabaseTester {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Database database = new Database();
		
		boolean running = true;
		do {
			running = prompt(s,  database);
		} while (running);
		
		s.close();
	}
	
	public static boolean prompt(Scanner s, Database database) {
		System.out.println("Choose an action:");
		System.out.println("    [1] Access a password");
		System.out.println("    [2] Add a password");
		System.out.println("    [0] Quit application");
		int choice = s.nextInt();
		s.nextLine();
		
		if (choice == 1) {
			System.out.println("Which site will you access? ");
			String site = s.nextLine();
			if (database.containsSite(site)) {
				ClipboardManager.copyText(database.getPassword(site));
				System.out.println("Password successfully copied!");
				System.out.println("Press enter to clear your clipboard.\n");
				s.nextLine();
				ClipboardManager.clearClipBoard();
			} else {
				System.out.println("Site not registered.");
			}
		} else if (choice == 2) {
			System.out.println("Which site did you join? ");
			String site = s.nextLine();
			System.out.println("What is the password?: ");
			String password = s.nextLine();
			System.out.println();
			
			database.addSite(site, password);
		} else if (choice == 0) {
			System.out.println("Thanks for using! ");
			database.saveData();
			return false;
		} else {
			System.out.println("Invalid option");
		}
		database.saveData();
		return true;
	}
}
