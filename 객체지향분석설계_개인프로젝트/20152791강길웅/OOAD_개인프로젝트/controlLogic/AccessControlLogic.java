package controlLogic;

import control.AccessControl;
import control.DoorControl;
import da.map.AccessMapStore;
import entity.User;
import entity.UserLevel;
import store.AccessStore;
import util.CheckUtil;
import util.UserNullException;

public class AccessControlLogic implements AccessControl{
	private DoorControl doorControl;
	private AccessStore accessStore;
	private User user;
	private CheckUtil checkUtil;
	
	public AccessControlLogic() {
		
		doorControl = new DoorControlLogic();
		accessStore = new AccessMapStore();
		checkUtil = new CheckUtil();
	}

	@Override
	public void openDoor() {
		// TODO Auto-generated method stub
		
		if(checkUtil.checkUserPossible(user)) {
			doorControl.open();
			return;
		}
	}

	@Override
	public void userSetting(String userNumber) throws UserNullException {
		// TODO Auto-generated method stub
		user = accessStore.retrieve(userNumber);
		if(user == null) {
			throw new UserNullException("Not found User");
		}
	}

	@Override
	public void authorityUpdate(String userNumber,UserLevel userlevel) {
		// TODO Auto-generated method stub
		if(!checkUtil.checkUserManager(user)) {
			return;
		}
		
		User newUser = new User(userNumber);
		newUser.setUserLevel(userlevel);
		
		if(accessStore.retrieve(userNumber) != null) {
			accessStore.update(newUser);
		}else {
			accessStore.create(newUser);
		}
		System.out.printf("User update : %s\n",userNumber);
	}

	@Override
	public void doorStateChange() throws UserNullException {
		// TODO Auto-generated method stub
		if(this.user == null) {
			throw new UserNullException("Not read User");
		}
		
		if(!checkUtil.checkUserManager(user)) {
			return;
		}
		
		doorControl.change();
	}
	@Override
	public void resetUser() {
		this.user = null;
	}
}
