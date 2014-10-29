package apis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import other.Constants;
import other.FileDownloadLink;
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
	
	public static ArrayList<FileDownloadLink> getDownloadLinks (){
		GoogleDrive drive = new GoogleDrive();
		drive.initDrive(Constants.OAUTH_CODE);
		try {
			return drive.getFileDownloadLinks();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
