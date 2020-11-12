package da.map;

import java.util.Map;
import java.util.NoSuchElementException;

import da.map.io.MemoryMap;
import entity.User;
import entity.UserLevel;
import store.AccessStore;
import util.UserDuplicationException;

public class AccessMapStore implements AccessStore{
	private Map<String,User> userMap;
	
	public AccessMapStore() {
		this.userMap = MemoryMap.getInstance().getUserMap();
		User mUser = new User("111");
		mUser.setUserLevel(UserLevel.manager);
		create(mUser);
	}
	@Override
	public User retrieve(String userNumber) {
		// TODO Auto-generated method stub
		return userMap.get(userNumber);
	}

	@Override
	public String update(User user) {
		// TODO Auto-generated method stub
		if(userMap.get(user.getUserNumber()) == null) {
			throw new NoSuchElementException("No such a elements");
		}
		userMap.put(user.getUserNumber(), user);
		return user.getUserNumber();
	}

	@Override
	public String delete(User user) {
		// TODO Auto-generated method stub
		userMap.remove(user.getUserNumber());
		return user.getUserNumber();
	}
	@Override
	public String create(User user) {
		// TODO Auto-generated method stub
		if(userMap.get(user.getUserNumber()) != null) {
			throw new UserDuplicationException("User already exists");
		}
		
		userMap.put(user.getUserNumber(), user);
		return user.getUserNumber();
	}
	
}
