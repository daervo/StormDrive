package apis;

import interfaces.UserManagement;

public class StormDrive {
	
	public static boolean setPassword(String username, String password) {
		UserManagement stormpath = new Stormpath();
		return stormpath.setPassword(username, password);
	}
	
	public static String getDetails(String username) {
		UserManagement stormpath = new Stormpath();
		return stormpath.getDetails(username);
	}
	
	public static boolean login(String username, String password){
		UserManagement stormpath = new Stormpath();
		return stormpath.authenticateAccount(username, password);
	}
	
	public static boolean register(String givenName, String surname, String userName, String password, String email){
		UserManagement stormpath = new Stormpath();
		return stormpath.createAccount(givenName, surname, userName, password, email, "Student");
	}
	
	public static boolean createAdmin(String givenName, String surname, String userName, String password, String email){
		UserManagement stormpath = new Stormpath();
		return stormpath.createAccount(givenName, surname, userName, password, email, "Teacher");
	}
}
