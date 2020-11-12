package ui;

import java.util.Scanner;

import control.AccessControl;
import controlLogic.AccessControlLogic;
import entity.User;
import entity.UserLevel;
import util.UserNullException;

public class AccessSystemUI {
	private AccessControl accessControl;
	private Scanner scanner;
	
	public AccessSystemUI() {
		this.accessControl = new AccessControlLogic();
		this.scanner = new Scanner(System.in);
	}
	public void init() {
		while(true) {
			userRead(scanner);
			mainMenu();
			selectMenu(scanner);
		}
	}
	public void mainMenu() {
		
		System.out.println("----------------------------");
		System.out.println("Access System");
		System.out.println("----------------------------");
		System.out.println("1. Open Door");
		System.out.println("2. Door Lock / Door Open");
		System.out.println("3. User Update");
		System.out.println("4. end");
		System.out.println("----------------------------");
	}
	
	public void selectMenu(Scanner sc) {
		int number;
		while(true) {
		number = sc.nextInt();
		sc.nextLine();
			if(number > 4 || number < 1) {
				System.out.println("Number is Wrong. please retry.");
				continue;
			} else 	{
				break;
			}
		}
		
		switch(number) {
		case 1: 
			accessControl.openDoor();
			break;
		case 2:
			try {
				accessControl.doorStateChange();
			} catch (UserNullException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 3:
			User newUser = userUpdate(sc);
			accessControl.authorityUpdate(newUser.getUserNumber(), newUser.getUserLevel());
			break;
		case 4:
			endSystem(sc);
		}
		accessControl.resetUser();
	}
	
	public void userRead(Scanner scanner) {
		while(true) {
			System.out.println("Input Your UserNumber : ");
			String userNumber = scanner.nextLine();
			try {
				accessControl.userSetting(userNumber);
				return;				
			} catch (UserNullException e) {
				// TODO: handle exception
				System.out.println("User can't find. please retry.");
				continue;
			}
		}
	}
	
	public User userUpdate(Scanner scanner) {
		System.out.println("Input User Number : ");
		String newUserNumber = scanner.nextLine();
		System.out.println("Input User Level (1.Manager, 2.Normally, 3.Ben)");
		int newUserLevel = scanner.nextInt();
		scanner.nextLine();
		User newUser = new User(newUserNumber);
		switch(newUserLevel) {
		case 1:
			newUser.setUserLevel(UserLevel.manager);
			break;
		case 2:
			newUser.setUserLevel(UserLevel.authorized);
			break;
		case 3:
			newUser.setUserLevel(UserLevel.Unauthorized);
			break;
		}
		return newUser;
	}
	public void endSystem(Scanner sc) {
		sc.close();
		System.exit(0);
	}
}
