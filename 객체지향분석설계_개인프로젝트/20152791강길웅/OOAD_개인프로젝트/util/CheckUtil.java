package util;

import entity.User;
import entity.UserLevel;

public class CheckUtil {
	public CheckUtil() {
		//
	}
	
	public boolean checkUserManager(User user) {
		if(user.getUserLevel() != UserLevel.manager) {
			System.out.println("User is not Manager. Thin user : " + user.getUserLevel());
			return false;
		}
			
		return true;
	}
	
	public boolean checkUserPossible(User user) {
		if(user.getUserLevel() == UserLevel.Unauthorized) {
			System.out.println("User Unathorized.");
			return false;
		}
		return true;
	}
	
}
