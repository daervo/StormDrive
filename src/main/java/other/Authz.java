package other;

import com.stormpath.sdk.account.Account;
import com.stormpath.sdk.group.Group;
import com.stormpath.sdk.group.GroupList;
import apis.Stormpath;

public class Authz extends Stormpath {
	
	
	public static boolean IsAuthorized(String username, String operation) {
		System.out.println("the sent user name is"+username);
		if (username==null)
			return false;
		Account current = new apis.Stormpath().searchAccount(username);
		String href ="https://api.stormpath.com/v1/groups/PCv2f0N9VvnmIjmgmRNTO";
		Group studentgroup = client.getResource(href, Group.class);
		String href2 ="https://api.stormpath.com/v1/groups/PbFvCMHUOLm0oqx8iFZmQ";
		Group teachergroup = client.getResource(href2, Group.class);
		
		
		System.out.println(current.getFullName());
		GroupList groups = current.getGroups();
		
		for( Group group : groups) {
			
		
		    if (group.equals(studentgroup)&& operation=="upload")
		    	{
		    	System.out.println("student is Authorised");
		    	return true;
		    	}
		    else if (group.equals(teachergroup)&& (operation=="download" || operation=="list"))
		    {
		    	System.out.println("teacher is Authorised");
		    	return true;
		    	}}
		   
		    	
	return false;
		    
	}
}

