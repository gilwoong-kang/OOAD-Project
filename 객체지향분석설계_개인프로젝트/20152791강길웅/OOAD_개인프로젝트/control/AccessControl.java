package control;

import entity.UserLevel;
import util.UserNullException;

public interface AccessControl {
	
	public void openDoor();
	public void userSetting(String userNumber) throws UserNullException;
	public void authorityUpdate(String userNumber,UserLevel userlevel);
	public void doorStateChange() throws UserNullException;
	public void resetUser();
	
}
